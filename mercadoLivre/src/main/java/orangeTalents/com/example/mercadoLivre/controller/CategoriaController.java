package orangeTalents.com.example.mercadoLivre.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import orangeTalents.com.example.mercadoLivre.controller.form.CategoriaForm;
import orangeTalents.com.example.mercadoLivre.model.Categoria;
import orangeTalents.com.example.mercadoLivre.repository.CategoriaRepository;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

	@Autowired
	private CategoriaRepository categoriaRepository;

	@PostMapping
	public ResponseEntity<?> cadastraCategoria(@RequestBody @Valid CategoriaForm form) {
		Categoria categoria = form.converter(categoriaRepository);

		categoriaRepository.save(categoria);

		return ResponseEntity.ok().build();
	}
}
