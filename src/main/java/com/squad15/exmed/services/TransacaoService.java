package com.squad15.exmed.services;

import com.squad15.exmed.interfaces.TransacaoRepository;
import com.squad15.exmed.models.Transacao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransacaoService {

    private final TransacaoRepository transacaoRepository;

    @Autowired
    public TransacaoService(TransacaoRepository transacaoRepository) {
        this.transacaoRepository = transacaoRepository;
    }

    public List<Transacao> getAllTransacoes() {
        return transacaoRepository.findAll();
    }

    public Transacao saveTransacao(Transacao transacao) {
        return transacaoRepository.save(transacao);
    }

}
