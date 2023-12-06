package com.squad15.exmed.interfaces;

import com.squad15.exmed.models.Campanha;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CampanhaRepository extends JpaRepository<Campanha, Long> {
}