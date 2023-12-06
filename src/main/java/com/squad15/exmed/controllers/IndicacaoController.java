package com.squad15.exmed.controllers;

import com.squad15.exmed.models.Indicacao;
import com.squad15.exmed.services.IndicacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/indicacoes")
public class IndicacaoController {

    private final IndicacaoService indicacaoService;

    @Autowired
    public IndicacaoController(IndicacaoService indicacaoService) {
        this.indicacaoService = indicacaoService;
    }

    @GetMapping
    public List<Indicacao> getAllIndicacoes() {
        return indicacaoService.getAllIndicacoes();
    }

    @PostMapping
    public Indicacao saveIndicacao(@RequestBody Indicacao indicacao) {
        return indicacaoService.saveIndicacao(indicacao);
    }

}
