package orangeTalents.com.example.mercadoLivre.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import orangeTalents.com.example.mercadoLivre.controller.form.UsuarioForm;
import orangeTalents.com.example.mercadoLivre.model.Usuario;
import orangeTalents.com.example.mercadoLivre.repository.UsuarioRepository;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@PostMapping
	public ResponseEntity<?> cadastraUsuario(@RequestBody @Valid UsuarioForm form) {
		Usuario usuario = form.converter();
		
		usuarioRepository.save(usuario);
		return ResponseEntity.ok().build();
	}
}
