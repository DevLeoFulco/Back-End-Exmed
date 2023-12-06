package com.squad15.exmed.interfaces;

import com.squad15.exmed.models.Sexo;
import com.squad15.exmed.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Usuario findByEmail(String email);
    Optional<Usuario> findByCodIndicacao(String codIndicacao);

    UserDetails findByLogin(String login);
}
