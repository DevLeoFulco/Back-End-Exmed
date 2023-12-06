package com.squad15.exmed.models;

import com.squad15.exmed.enums.UserRole;
import com.squad15.exmed.utils.GerarCodIndicacao;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "usuarios")
public class Usuario implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private int idade;


    @Enumerated(EnumType.STRING)
    private Sexo sexo;
    private String login;
    private String email;
    private String senha;
    private int saldoExmedCoin;
    private String codIndicacao;
    private String codEntrada;
    @Enumerated(EnumType.STRING)
    private UserRole role = UserRole.USER;
    private int QuantidadeIndicacoes;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "indicado")
    private Indicacao indicacaoRecebida;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "usuario")
    private List<Transacao> transacoes;

    @Embedded
    private Endereco endereco;

    public Usuario(String login, String senha) {
        this.email = login;
        this.senha= senha;
    }

    @PrePersist
    private void prePersist() {
        if (1 == 1) {
            this.codIndicacao = GerarCodIndicacao.gerarCodigoIndicacao();
        }
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (this.role == UserRole.ADMIN) return List.of(new SimpleGrantedAuthority("ROLE_ADMIN"), new SimpleGrantedAuthority("ROLE_USER"));
        else return List.of(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public String getPassword() {
        return senha;
    }

    @Override
    public String getUsername() {
        return login;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
