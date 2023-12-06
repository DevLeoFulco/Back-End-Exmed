package com.squad15.exmed.controllers;

import com.squad15.exmed.models.Transacao;
import com.squad15.exmed.services.TransacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transacao")
public class TransacaoController {

    private final TransacaoService transacaoService;

    @Autowired
    public TransacaoController(TransacaoService transacaoService) {
        this.transacaoService = transacaoService;
    }

    @GetMapping
    public List<Transacao> getAllTransacoes() {
        return transacaoService.getAllTransacoes();
    }

    @PostMapping
    public Transacao saveTransacao(@RequestBody Transacao transacao) {
        return transacaoService.saveTransacao(transacao);
    }

}
