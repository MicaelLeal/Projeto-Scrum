package com.example.softwareengineering.diminuto.models;

import java.util.ArrayList;
import java.util.List;

public class Usuario {

    private String nome;
    private String email;
    private String telefone;
    private String senha;
    private List<Instrumento> instrumentosParaAlugar;
    private  List<InstrumentoAlugado> instrumentosAlugados;

    public Usuario(String nome, String email, String senha, String telefone) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.senha = senha;
        this.instrumentosParaAlugar = new ArrayList<>();
        this.instrumentosAlugados = new ArrayList<>();
    }

    public void addInstrumentoParaAlugar(Instrumento instrumento){
        this.instrumentosParaAlugar.add(instrumento);
    }

    public void addInstrumentoAlugado(InstrumentoAlugado instrumento){
        this.instrumentosAlugados.add(instrumento);
    }
}
