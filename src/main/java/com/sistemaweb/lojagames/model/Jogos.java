package com.sistemaweb.lojagames.model;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
@Entity 
@Table(name = "jogos")
public class Jogos {

    @Id // Indica que este campo é a chave primária
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Configura auto-incremento para PostgreSQL
    private Long id;

    @NotBlank(message = "O nome do jogo é obrigatório!")
    @Size(min = 2, max = 100, message = "O nome deve ter entre 2 e 100 caracteres.")
    @Column(name = "nome_jogo", nullable = false, length = 100) // Mapeamento da coluna: nome no BD, não nulo, tamanho
    private String nome;

    @NotBlank(message = "O preenchimento do estado do jogo é obrigatório!")
    @Column(name = "estado_jogo", nullable = false, length = 100)
    private String estado;

    @NotNull(message = "O preço é obrigatório!")
    @DecimalMin(value = "0.01", message = "O preço deve ser maior que zero.")
    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal preco;

    @NotBlank(message = "O console é obrigatório!")
    @Size(min = 2, max = 50, message = "O console deve ter entre 2 e 50 caracteres.")
    @Column(name = "console", nullable = false, length = 50)
    private String console;

    // Sobrecarga
    // Para cadastrar um registro
    public Jogos() {

    }

    // Para inserir o registro
    public Jogos(String nome, String estado, BigDecimal preco, String console) {
        this.nome = nome;
        this.estado = estado;
        this.preco = preco;
        this.console = console;
    }

    // Para atualização de registro
    public Jogos(Long id, String nome, String estado, BigDecimal preco, String console) {
        this.id = id;
        this.nome = nome;
        this.estado = estado;
        this.preco = preco;
        this.console = console;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public String getConsole() {
        return console;
    }

    public void setConsole(String console) {
        this.console = console;
    }

    // Opcional: Adicione um método toString() para facilitar o debug
    @Override
    public String toString() {
        return "Jogos{" +
               "id=" + id +
               ", nome='" + nome + '\'' +
               ", estado='" + estado + '\'' +
               ", preco=" + preco +
               ", console='" + console + '\'' +
               '}';
    }
}
