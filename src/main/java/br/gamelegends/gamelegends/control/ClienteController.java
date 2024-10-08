package br.gamelegends.gamelegends.control;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.gamelegends.gamelegends.model.Cliente;
import br.gamelegends.gamelegends.service.ClienteService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600, allowCredentials = "false")
@RequestMapping("/cliente")
public class ClienteController {

    final ClienteService clienteService;

    public ClienteController(ClienteService _clienteService) {
        this.clienteService = _clienteService;
    }

    // ROTA POST - Criar novo cliente
    @PostMapping
    public ResponseEntity<Object> saveCliente(@RequestBody Cliente cliente) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(clienteService.save(cliente));
    }

    // ROTA GET - Listar todos os Clientes
    @GetMapping
    public ResponseEntity<List<Cliente>> getAllCliente() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(clienteService.findAll());
    }

    // ROTA PUT - Atualizar Clientes existentes
    @PutMapping("/{id}")
    public ResponseEntity<Object> updateCliente(@PathVariable Long id, @RequestBody Cliente cliente) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(clienteService.update(id, cliente));
    }

    @ControllerAdvice
    public static class GlobalExceptionHandler {

        @ExceptionHandler(Exception.class)
        public ResponseEntity<String> handleException(Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
        }
    }

}