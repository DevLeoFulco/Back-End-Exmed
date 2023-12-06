package com.squad15.exmed.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "indicacoes")
public class Indicacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "indicado_id", referencedColumnName = "id")
    private Usuario indicado;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "indicador_id", referencedColumnName = "id")
    private Usuario indicador;

    public void setDataIndicacao(Date date) {
    }
}
