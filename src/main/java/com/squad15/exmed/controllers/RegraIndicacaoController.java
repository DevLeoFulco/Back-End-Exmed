package com.squad15.exmed.controllers;

import com.squad15.exmed.models.RegraIndicacao;
import com.squad15.exmed.services.RegraIndicacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/regras-indicacao")
public class RegraIndicacaoController {

    @Autowired
    private RegraIndicacaoService regraIndicacaoService;

    @PostMapping
    public ResponseEntity<RegraIndicacao> criarRegra(@RequestBody RegraIndicacao regra) {
        return ResponseEntity.ok(regraIndicacaoService.criarRegra(regra));
    }

    @GetMapping
    public ResponseEntity<List<RegraIndicacao>> listarRegras() {
        return ResponseEntity.ok(regraIndicacaoService.listarRegras());
    }

    @PutMapping("/{id}")
    public ResponseEntity<RegraIndicacao> atualizarRegra(@PathVariable Long id, @RequestBody RegraIndicacao regra) {
        return ResponseEntity.ok(regraIndicacaoService.atualizarRegra(id, regra));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarRegra(@PathVariable Long id) {
        regraIndicacaoService.deletarRegra(id);
        return ResponseEntity.ok().build();
    }
}