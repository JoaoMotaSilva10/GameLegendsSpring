package br.gamelegends.gamelegends.control;

import br.gamelegends.gamelegends.model.Cadastro;
import br.gamelegends.gamelegends.model.Login;
import br.gamelegends.gamelegends.service.CadastroService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600, allowCredentials = "false")
@RequestMapping("/login")
public class LoginController {

    private final CadastroService cadastroService;

    public LoginController(CadastroService cadastroService) {
        this.cadastroService = cadastroService;
    }

    // ROTA POST - Para fazer o login
    @PostMapping
    public ResponseEntity<Object> login(@RequestBody Login login) {
        // Busca o cadastro pelo e-mail
        Cadastro cadastro = cadastroService.findByEmail(login.getEmail());

        if (cadastro == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cadastro não encontrado");
        }

        // Verifica se a senha está correta
        if (!cadastro.getSenha().equals(login.getSenha())) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Senha incorreta");
        }

        // Login bem-sucedido
        return ResponseEntity.status(HttpStatus.OK).body("Login realizado com sucesso!");
    }

    // ROTA GET - Buscar informações do cadastro pelo ID
    @GetMapping("/cadastro/{id}")
    public ResponseEntity<Cadastro> getCadastroById(@PathVariable Long id) {
        return cadastroService.findById(id)
                .map(cadastro -> ResponseEntity.ok().body(cadastro))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }
}
