package orangeTalents.com.example.mercadoLivre.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;

@Entity
public class Categoria {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank
	private String nome;

	@ManyToOne
	private Categoria categoria_mae;

	public Categoria() {
		super();
	}

	public Categoria(@NotBlank String nome, Categoria categoria) {
		super();
		this.nome = nome;
		this.categoria_mae = categoria;
	}

	public Categoria(@NotBlank String nome) {
		super();
		this.nome = nome;
	}

}
