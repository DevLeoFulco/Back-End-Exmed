package com.squad15.exmed.controllers;

import com.squad15.exmed.configs.security.TokenService;
import com.squad15.exmed.dtos.AutenticacaoDTO;
import com.squad15.exmed.dtos.LoginResponseDTO;
import com.squad15.exmed.interfaces.UsuarioRepository;
import com.squad15.exmed.models.Usuario;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.authentication.AuthenticationManager;


import java.net.Authenticator;

@RestController
public class AutenticacaoController {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    UsuarioRepository usuarioRepository;
    @Autowired
    TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody @Valid AutenticacaoDTO data) {
        if (this.usuarioRepository.findByEmail(data.login()) == null) {
            return ResponseEntity.badRequest().body("Usuário não encontrado");
        }
        var usernamePassword = new UsernamePasswordAuthenticationToken(data.login(), data.senha());
        var auth = this.authenticationManager.authenticate(usernamePassword);
        var token = tokenService.generateToken((Usuario) auth.getPrincipal());
        return ResponseEntity.ok(new LoginResponseDTO(token));
    }

}
