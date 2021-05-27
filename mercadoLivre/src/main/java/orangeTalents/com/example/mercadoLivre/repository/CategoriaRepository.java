package orangeTalents.com.example.mercadoLivre.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import orangeTalents.com.example.mercadoLivre.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

}
