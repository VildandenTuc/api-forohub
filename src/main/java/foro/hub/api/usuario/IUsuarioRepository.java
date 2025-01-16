package foro.hub.api.usuario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

public interface IUsuarioRepository extends JpaRepository<Usuario, Long> {
    //UserDetails findByLogin(String login);
    Optional<Usuario> findByLogin(String login);
}
