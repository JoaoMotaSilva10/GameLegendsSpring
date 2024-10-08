package br.gamelegends.gamelegends.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="projetos")
public class Projetos {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;



    private byte foto;
    private String nome;
    private String descricao;
    private String genero_jogo;
    private String contato;
    private String statusProjeto;
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public byte getFoto() {
        return foto;
    }
    public void setFoto(byte foto) {
        this.foto = foto;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public String getGenero_jogo() {
        return genero_jogo;
    }
    public void setGenero_jogo(String genero_jogo) {
        this.genero_jogo = genero_jogo;
    }
    public String getContato() {
        return contato;
    }
    public void setContato(String contato) {
        this.contato = contato;
    }
    public String getStatusProjeto() {
        return statusProjeto;
    }
    public void setStatusProjeto(String statusProjeto) {
        this.statusProjeto = statusProjeto;
    }
}


