package com.squad15.exmed.services;

import com.squad15.exmed.interfaces.IndicacaoRepository;
import com.squad15.exmed.interfaces.RegraIndicacaoRepository;
import com.squad15.exmed.interfaces.UsuarioRepository;
import com.squad15.exmed.models.Indicacao;
import com.squad15.exmed.models.RegraIndicacao;
import com.squad15.exmed.models.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final IndicacaoRepository indicacaoRepository;
    private final RegraIndicacaoRepository regraIndicacaoRepository;

    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository, IndicacaoRepository indicacaoRepository, RegraIndicacaoRepository regraIndicacaoRepository) {
        this.usuarioRepository = usuarioRepository;
        this.indicacaoRepository = indicacaoRepository;
        this.regraIndicacaoRepository = regraIndicacaoRepository;
    }

    public List<Usuario> getAllUsuarios() {
        return usuarioRepository.findAll();
    }

    public Optional<Usuario> getUsuarioById(Long id) {
        return usuarioRepository.findById(id);
    }

    @Transactional
    public Usuario saveUsuario(Usuario usuario, String codIndicacao) {
        // Salva o novo usuário
        usuario = usuarioRepository.save(usuario);

        String codEntrada = usuario.getCodEntrada();

        // Se um código de indicação foi fornecido, atribua os ExmedCoins ao indicador
        if (codEntrada != null && !codEntrada.isEmpty()) {
            System.out.println("entrou");
            Optional<Usuario> usuarioIndicadorOpt = usuarioRepository.findByCodIndicacao(codEntrada);
            usuarioIndicadorOpt.ifPresent(indicador -> {
                // Define a quantidade de ExmedCoins que serão atribuídos
                int recompensa = 100; // Valor de recompensa a ser definido pela regra de negócio
                indicador.setSaldoExmedCoin(indicador.getSaldoExmedCoin() + recompensa);
                usuarioRepository.save(indicador);
            });
        }

        return usuario;
    }


    private void criarIndicacaoEAtualizarExmedCoins(Usuario indicador, Usuario usuario) {
        Indicacao indicacao = new Indicacao();
        indicacao.setIndicador(indicador);
        indicacao.setIndicado(usuario);

        indicacaoRepository.save(indicacao);

        int recompensa = 100;
        indicador.setSaldoExmedCoin(indicador.getSaldoExmedCoin() + recompensa);
        usuarioRepository.save(indicador);
    }



    public void deleteUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }

    public void saveUsuario(Usuario usuario) {
        usuarioRepository.save(usuario);
    }

    private void aplicarRegraDeIndicacao(Usuario indicador, Usuario indicado) {
        List<RegraIndicacao> regras = regraIndicacaoRepository.findRegraByQuantidadeIndicacaoOrLess(indicador.getQuantidadeIndicacoes());

        if (!regras.isEmpty()) {
            RegraIndicacao regraIndicacao = regras.get(0);

            indicador.setSaldoExmedCoin(indicador.getSaldoExmedCoin() + regraIndicacao.getValorExmedcoin());
            usuarioRepository.save(indicador);
        }
    }

    public Usuario findByEmail(String email) {
        return usuarioRepository.findByEmail(email);
    }

    public Optional<Usuario> findByCodIndicacao(String codIndicacao) {
        return usuarioRepository.findByCodIndicacao(codIndicacao);
    }
}

