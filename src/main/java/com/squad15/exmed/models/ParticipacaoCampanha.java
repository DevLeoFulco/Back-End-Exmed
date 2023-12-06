package com.squad15.exmed.models;

import jakarta.persistence.Embeddable;
import lombok.Data;

import java.util.Date;

@Embeddable
@Data
public class ParticipacaoCampanha {

    private Date dataParticipacao;

    private Usuario usuario;


}
