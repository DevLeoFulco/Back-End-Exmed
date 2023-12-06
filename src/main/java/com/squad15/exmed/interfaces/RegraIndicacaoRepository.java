package com.squad15.exmed.interfaces;

import com.squad15.exmed.models.RegraIndicacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface RegraIndicacaoRepository extends JpaRepository<RegraIndicacao, Long> {
    @Query("SELECT r FROM RegraIndicacao r WHERE r.quantidadeIndicacao <= :quantidade ORDER BY r.quantidadeIndicacao DESC")
    List<RegraIndicacao> findRegraByQuantidadeIndicacaoOrLess(@Param("quantidade") Integer quantidade);

    // Assumindo que você sempre vai pegar o primeiro resultado, pois a lista está em ordem decrescente
    Optional<RegraIndicacao> findFirstByQuantidadeIndicacaoLessThanEqualOrderByQuantidadeIndicacaoDesc(int quantidadeIndicacoes);
}
