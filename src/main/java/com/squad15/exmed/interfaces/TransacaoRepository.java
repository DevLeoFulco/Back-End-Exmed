package com.squad15.exmed.interfaces;

import com.squad15.exmed.models.Transacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransacaoRepository extends JpaRepository<Transacao, Long> {

}
