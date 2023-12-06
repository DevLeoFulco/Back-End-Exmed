package com.squad15.exmed.controllers;

import com.squad15.exmed.configs.security.TokenService;
import com.squad15.exmed.dtos.AutenticacaoDTO;
import com.squad15.exmed.dtos.LoginResponseDTO;
import com.squad15.exmed.dtos.UserDTO;
import com.squad15.exmed.interfaces.UsuarioRepository;
import com.squad15.exmed.models.Usuario;
import com.squad15.exmed.services.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    private final UsuarioService usuarioService;
    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public UsuarioController(UsuarioService usuarioService, BCryptPasswordEncoder passwordEncoder) {
        this.usuarioService = usuarioService;
        this.passwordEncoder = passwordEncoder;
    }

    @Autowired
    UsuarioRepository usuarioRepository;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    TokenService tokenService;

    @GetMapping
    public List<Usuario> getAllUsuarios() {
        return usuarioService.getAllUsuarios();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> getUsuarioById(@PathVariable Long id) {
        Optional<Usuario> usuario = usuarioService.getUsuarioById(id);
        return usuario.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Object> saveUsuario(@RequestBody @Valid UserDTO data, @RequestParam(required = false) String codIndicacao) {

        Usuario usuario = new Usuario();
        BeanUtils.copyProperties(data, usuario);
        usuario.setSenha(passwordEncoder.encode(data.getSenha()));

        // Você não precisa mais do bloco de código para buscar o indicador, pois isso será tratado no service
        Usuario savedUsuario = usuarioService.saveUsuario(usuario, codIndicacao);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedUsuario);
    }

    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody @Valid AutenticacaoDTO data) {
        if (this.usuarioRepository.findByLogin(data.login()) == null) {
            return ResponseEntity.badRequest().body("Usuário não encontrado");
        }
        var usernamePassword = new UsernamePasswordAuthenticationToken(data.login(), data.senha());
        var auth = this.authenticationManager.authenticate(usernamePassword);
        var token = tokenService.generateToken((Usuario) auth.getPrincipal());
        return ResponseEntity.ok(new LoginResponseDTO(token));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUsuario(@PathVariable Long id) {
        if (!usuarioService.getUsuarioById(id).isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        usuarioService.deleteUsuario(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}