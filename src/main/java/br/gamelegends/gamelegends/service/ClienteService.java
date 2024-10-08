package br.gamelegends.gamelegends.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;

import br.gamelegends.gamelegends.model.Cliente;
import br.gamelegends.gamelegends.model.ClienteRepository;

@Service
public class ClienteService {
    // Criar objeto repository
    final ClienteRepository clienteRepository;

    // Injeção de Dependência
    public ClienteService(ClienteRepository _clienteRepository) {
        this.clienteRepository = _clienteRepository;
    }

    // Método INSERT INTO Cliente
    @Transactional
    public Cliente save(Cliente _cliente) {
        return clienteRepository.save(_cliente);
    }

    // Método SELECT * FROM Cliente
    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }

    public Cliente findAllById(long id) {
        return clienteRepository.findById(id).orElse(null); // Use findById para retornar um Optional
    }

    // Método UPDATE FUNCIONARIO
    @Transactional
    public Cliente update(Long id, Cliente cliente) {
        Optional<Cliente> optionalCliente = clienteRepository.findById(id);

        if (optionalCliente.isPresent()) {
            Cliente existingCliente = optionalCliente.get();
            // Atualiza os campos necessários
            existingCliente.setEmail(cliente.getEmail());
            existingCliente.setNome(cliente.getNome());
            existingCliente.setSenha(cliente.getSenha());

            // Salva as alterações no banco de dados
            return clienteRepository.save(existingCliente);
        } else {
            throw new RuntimeException("Cliente não encontrado com o ID: " + id);
        }
    }

    // Método DELETE FUNCIONARIO
    @Transactional
    public void delete(long id) {
        clienteRepository.deleteById(id);
    }

}