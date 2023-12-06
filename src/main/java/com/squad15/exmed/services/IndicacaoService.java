package com.squad15.exmed.services;

import com.squad15.exmed.interfaces.IndicacaoRepository;
import com.squad15.exmed.models.Indicacao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IndicacaoService {

    private final IndicacaoRepository indicacaoRepository;

    @Autowired
    public IndicacaoService(IndicacaoRepository indicacaoRepository) {
        this.indicacaoRepository = indicacaoRepository;
    }

    public List<Indicacao> getAllIndicacoes() {
        return indicacaoRepository.findAll();
    }

    public Indicacao saveIndicacao(Indicacao indicacao) {
        return indicacaoRepository.save(indicacao);
    }

}
