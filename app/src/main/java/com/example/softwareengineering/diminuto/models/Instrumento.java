package com.example.softwareengineering.diminuto.models;

public class Instrumento {
    private String nome;
    private String descricacao;
    private Usuario dono;
    private double valor;

    public Instrumento(String nome, String descricacao, Usuario dono, double valor) {
        this.nome = nome;
        this.descricacao = descricacao;
        this.dono = dono;
        this.valor = valor;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricacao() {
        return descricacao;
    }

    public Usuario getDono() {
        return dono;
    }

    public double getValor() {
        return valor;
    }
}
