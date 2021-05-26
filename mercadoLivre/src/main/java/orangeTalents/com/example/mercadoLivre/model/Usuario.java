package orangeTalents.com.example.mercadoLivre.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import orangeTalents.com.example.mercadoLivre.controller.form.validation.SenhaLimpa;

@Entity
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank
	@Email
	private String login;
	@NotBlank
	@Length(min = 6)
	private String senha;
	private LocalDateTime instante = LocalDateTime.now();

	public Usuario() {
		super();
	}
	
	/**
	 * O email é uma string no formato de email
	 * Senha é uma string no formato de um texto limpo
	*/
	public Usuario(@NotBlank @Email String login, @Valid @NotNull SenhaLimpa senhaLimpa) {
		super();
		this.login = login;
		this.senha = senhaLimpa.hash();
	}

}
