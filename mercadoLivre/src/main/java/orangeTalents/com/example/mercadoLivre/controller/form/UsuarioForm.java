package orangeTalents.com.example.mercadoLivre.controller.form;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import orangeTalents.com.example.mercadoLivre.annotation.UniqueValue;
import orangeTalents.com.example.mercadoLivre.controller.form.validation.SenhaLimpa;
import orangeTalents.com.example.mercadoLivre.model.Usuario;

public class UsuarioForm {

	@NotBlank
	@Email
	@UniqueValue(domainClass = Usuario.class, fieldName = "login")
	private String login;
	@NotBlank
	@Length(min = 6)
	private String senha;

	public String getLogin() {
		return login;
	}

	public String getSenha() {
		return senha;
	}

	public Usuario converter() {
		return new Usuario(this.login, new SenhaLimpa(senha));
	}
}
