package orangeTalents.com.example.mercadoLivre.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import orangeTalents.com.example.mercadoLivre.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {


	Optional<Usuario> findByLogin(String username);

}
