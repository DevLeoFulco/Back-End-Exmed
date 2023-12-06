package com.squad15.exmed.interfaces;

import com.squad15.exmed.models.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
