package orangeTalents.com.example.mercadoLivre.controller.form;

import java.util.Optional;

import javax.validation.constraints.NotBlank;

import orangeTalents.com.example.mercadoLivre.annotation.UniqueValue;
import orangeTalents.com.example.mercadoLivre.model.Categoria;
import orangeTalents.com.example.mercadoLivre.repository.CategoriaRepository;

public class CategoriaForm {

	@NotBlank
	@UniqueValue(domainClass = Categoria.class, fieldName = "nome")
	private String nome;
	private Long id_categoriaMae;

	public String getNome() {
		return nome;
	}

	public Long getId_categoriaMae() {
		return id_categoriaMae;
	}

	public void setId_categoriaMae(Long id_categoriaMae) {
		this.id_categoriaMae = id_categoriaMae;
	}

	public Categoria converter(CategoriaRepository categoriaRepository) {

		if (id_categoriaMae == null) {
			return new Categoria(this.nome);
		}

		Optional<Categoria> categoria = categoriaRepository.findById(this.id_categoriaMae);

		return new Categoria(this.nome, categoria.get());
	}
}
