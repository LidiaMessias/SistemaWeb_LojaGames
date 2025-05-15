package com.sistemaweb.lojagames.model;

import java.math.BigDecimal;

public class Jogos {

    private int id;
    private String nome;
    private String estado;
    private BigDecimal preco;
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
    public Jogos(int id, String nome, String estado, BigDecimal preco, String console) {
        this.id = id;
        this.nome = nome;
        this.estado = estado;
        this.preco = preco;
        this.console = console;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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
}
