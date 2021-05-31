package orangeTalents.com.example.mercadoLivre.config.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import orangeTalents.com.example.mercadoLivre.model.Usuario;
import orangeTalents.com.example.mercadoLivre.repository.UsuarioRepository;

public class AutenticacaoViaTokenFilter extends OncePerRequestFilter {

	private TokenComponent tokenComponent;
	private UsuarioRepository repository;
	
	

	public AutenticacaoViaTokenFilter(TokenComponent tokenComponent, UsuarioRepository repository) {
		this.tokenComponent = tokenComponent;
		this.repository = repository;
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		String token = recuperarToken(request);
		boolean valido = tokenComponent.isTokenValid(token); 
		
		if (valido) {
			autenticarCliente(token);
		}
		
		
		filterChain.doFilter(request, response); 

	}
	
	private void autenticarCliente(String token) {
		Long idUsuario = tokenComponent.getIdUsuario(token);
		Usuario usuario = repository.findById(idUsuario).get();
		UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(usuario, null, usuario.getAuthorities());
		SecurityContextHolder.getContext().setAuthentication(authentication);
	}

	private String recuperarToken(HttpServletRequest request) {
		String token = request.getHeader("Authorization");
		if (token == null || token.isEmpty() || !token.startsWith("Bearer ")) {
			return null;
		}
		
		return token.substring(7, token.length()); 

	}
}
