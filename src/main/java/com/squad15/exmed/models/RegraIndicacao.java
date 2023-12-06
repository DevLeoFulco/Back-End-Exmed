package com.squad15.exmed.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "regras_indicacao")
public class RegraIndicacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRegra;

    private Integer quantidadeIndicacao;
    private int valorExmedcoin;
    private String descricao;

}