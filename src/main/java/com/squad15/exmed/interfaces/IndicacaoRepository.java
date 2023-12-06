package com.squad15.exmed.interfaces;

import com.squad15.exmed.models.Indicacao;
import com.squad15.exmed.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IndicacaoRepository extends JpaRepository<Indicacao, Long> {
    boolean existsByIndicado(Usuario indicado);
}
