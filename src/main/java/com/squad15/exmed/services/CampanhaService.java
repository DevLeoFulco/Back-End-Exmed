package com.squad15.exmed.services;

import com.squad15.exmed.interfaces.CampanhaRepository;
import com.squad15.exmed.models.Campanha;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CampanhaService {

    @Autowired
    private CampanhaRepository campanhaRepository;

    public Campanha salvarCampanha(Campanha campanha) {
        // Validações e lógica antes de salvar...
        return campanhaRepository.save(campanha);
    }

    public List<Campanha> listarTodasCampanhas() {
        return campanhaRepository.findAll();
    }


}
