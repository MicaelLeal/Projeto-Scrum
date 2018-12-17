package com.example.softwareengineering.diminuto.models;

import java.util.Date;

public class Aluguel {

    private Instrumento instrumento;
    private Date dataRecebimento;
    private Date dataEntrega;
    private Usuario alugador;


    public Aluguel(Instrumento instrumento, Usuario alugador, Date dataRecebimento, Date dataEntrega) {
        this.instrumento = instrumento;
        this.dataRecebimento = dataRecebimento;
        this.dataEntrega = dataEntrega;
        this.alugador = alugador;
    }
}
