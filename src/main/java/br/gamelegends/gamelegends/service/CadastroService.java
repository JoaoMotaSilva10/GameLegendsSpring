package br.gamelegends.gamelegends.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;

import br.gamelegends.gamelegends.model.Cadastro;
import br.gamelegends.gamelegends.model.CadastroRepository;

@Service
public class CadastroService {
    // Injeção de Dependência do CadastroRepository
    final CadastroRepository cadastroRepository;

    public CadastroService(CadastroRepository _cadastroRepository) {
        this.cadastroRepository = _cadastroRepository;
    }

    // Método INSERT INTO CADASTRO
    @Transactional
    public Cadastro save(Cadastro _cadastro) {
        return cadastroRepository.save(_cadastro);
    }

    // Método SELECT * FROM CADASTRO
    public List<Cadastro> findAll() {
        return cadastroRepository.findAll();
    }

    // Método SELECT CADASTRO por ID
    public Optional<Cadastro> findById(long id) {
        return cadastroRepository.findById(id);
    }

    // Método SELECT CADASTRO por email
    public Cadastro findByEmail(String email) {
        return cadastroRepository.findByEmail(email);
    }

    // Método UPDATE CADASTRO
    @Transactional
    public Cadastro update(Long id, Cadastro cadastro) {
        Optional<Cadastro> optionalCadastro = cadastroRepository.findById(id);

        if (optionalCadastro.isPresent()) {
            Cadastro existingCadastro = optionalCadastro.get();
            // Atualiza os campos necessários
            existingCadastro.setEmail(cadastro.getEmail());
            existingCadastro.setNome(cadastro.getNome());
            existingCadastro.setSenha(cadastro.getSenha());

            // Salva as alterações no banco de dados
            return cadastroRepository.save(existingCadastro);
        } else {
            throw new RuntimeException("Cadastro não encontrado com o ID: " + id);
        }
    }

    // Método DELETE CADASTRO
    @Transactional
    public void delete(long id) {
        cadastroRepository.deleteById(id);
    }
}
