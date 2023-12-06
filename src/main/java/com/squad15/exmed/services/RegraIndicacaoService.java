package com.squad15.exmed.services;

import com.squad15.exmed.interfaces.RegraIndicacaoRepository;
import com.squad15.exmed.models.RegraIndicacao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegraIndicacaoService {

    @Autowired
    private RegraIndicacaoRepository regraIndicacaoRepository;

    public RegraIndicacao criarRegra(RegraIndicacao regra) {
        return regraIndicacaoRepository.save(regra);
    }

    public List<RegraIndicacao> listarRegras() {
        return regraIndicacaoRepository.findAll();
    }

    public RegraIndicacao atualizarRegra(Long id, RegraIndicacao regra) {
        regra.setIdRegra(id);
        return regraIndicacaoRepository.save(regra);
    }

    public void deletarRegra(Long id) {
        regraIndicacaoRepository.deleteById(id);
    }
}
