package com.example.softwareengineering.diminuto.models;

public class Instrumento {
    private String nome;
    private int idade;
    private Usuario dono;

    public Instrumento(String nome, int idade, Usuario dono) {
        this.nome = nome;
        this.idade = idade;
        this.dono = dono;
    }
}
