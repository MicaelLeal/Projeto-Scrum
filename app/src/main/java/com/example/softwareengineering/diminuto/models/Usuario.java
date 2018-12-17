package com.example.softwareengineering.diminuto.models;

import java.util.ArrayList;
import java.util.List;

public class Usuario {

    private String nome;
    private String email;
    private String telefone;
    private String senha;

    public Usuario(String nome, String email, String senha, String telefone) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.senha = senha;
    }

}
