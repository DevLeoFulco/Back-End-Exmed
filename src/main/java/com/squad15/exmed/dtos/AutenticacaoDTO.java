package com.squad15.exmed.dtos;

import jakarta.validation.constraints.NotBlank;

public record AutenticacaoDTO(@NotBlank String login, @NotBlank String senha) {
}
