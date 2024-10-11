package br.gamelegends.gamelegends.control;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.gamelegends.gamelegends.model.Cadastro;
import br.gamelegends.gamelegends.service.CadastroService;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600, allowCredentials = "false")
@RequestMapping("/cadastro")
public class CadastroController {

    final CadastroService cadastroService;

    public CadastroController(CadastroService _cadastroService) {
        this.cadastroService = _cadastroService;
    }

    // ROTA POST - Criar novo usuário
    @PostMapping
    public ResponseEntity<Object> saveCadastro(@RequestBody Cadastro cadastro) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(cadastroService.save(cadastro));
    }

    // ROTA GET - Listar todos os usuários
    @GetMapping
    public ResponseEntity<List<Cadastro>> getAllCadastro() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(cadastroService.findAll());
    }

    // ROTA PUT - Atualizar usuário existente
    @PutMapping("/{id}")
    public ResponseEntity<Object> updateCadastro(@PathVariable Long id, @RequestBody Cadastro cadastro) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(cadastroService.update(id, cadastro));
    }

    // ROTA DELETE - Excluir usuário por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteCadastro(@PathVariable long id) {
        cadastroService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
