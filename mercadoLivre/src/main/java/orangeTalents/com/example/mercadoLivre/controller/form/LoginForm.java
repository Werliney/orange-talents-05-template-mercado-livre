package orangeTalents.com.example.mercadoLivre.controller.form;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;


public class LoginForm {

	@NotBlank
	@Email
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
	
	public UsernamePasswordAuthenticationToken converter() {
		return new UsernamePasswordAuthenticationToken(login, senha);
	}

}
