package com.squad15.exmed.dtos;

import com.squad15.exmed.models.Sexo;

public record UserDTO(String nome,
                      int idade,
                      Sexo sexo,
                      String login,
                      String email,
                      String senha,
                      int saldoExmedCoin,
                      String codIndicacao,
                      int QuantidadeIndicacoes,
        String codEntrada){

    // Getter para email
    public String getEmail() {
        return email;
    }

    // Getter para senha
    public String getSenha() {
        return senha;
    }

    // Você pode adicionar getters adicionais para os outros campos se necessário
}