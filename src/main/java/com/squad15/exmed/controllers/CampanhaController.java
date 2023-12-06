package com.squad15.exmed.controllers;

import com.squad15.exmed.models.Campanha;
import com.squad15.exmed.services.CampanhaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/campanhas")
public class CampanhaController {

    @Autowired
    private CampanhaService campanhaService;

    @PostMapping
    public ResponseEntity<Campanha> criarCampanha(@RequestBody Campanha campanha) {
        Campanha novaCampanha = campanhaService.salvarCampanha(campanha);
        return new ResponseEntity<>(novaCampanha, HttpStatus.CREATED);
    }

    @GetMapping
    public List<Campanha> listarCampanhas() {
        return campanhaService.listarTodasCampanhas();
    }

}