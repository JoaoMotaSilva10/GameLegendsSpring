package br.gamelegends.gamelegends.control;

import java.util.List;

import br.gamelegends.gamelegends.model.Projetos;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.gamelegends.gamelegends.service.ProjetosService;

@RestController
@CrossOrigin(origins="*", maxAge=3600)
@RequestMapping("/projetos")
public class ProjetosController {
	
	final ProjetosService projetosService;
	
	public ProjetosController(ProjetosService _projetosService) {
		this.projetosService = _projetosService;
	}

	// GET
	@GetMapping
	public ResponseEntity<List<Projetos>> getAllProjetos (){
		return ResponseEntity.status(HttpStatus.OK)
				.body(projetosService.fintAll());
}
	
	// POST
	@PostMapping
	public ResponseEntity<Object> saveProjetos (Projetos projetos){
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(projetosService.save(projetos));
	}
	
}

