package com.example.softwareengineering.diminuto.models;

import java.util.Date;

public class InstrumentoAlugado {

    private Instrumento instrumento;
    private Date dataRecebimento;
    private Date dataEntrega;

    public InstrumentoAlugado(Instrumento instrumento, Date dataRecebimento, Date dataEntrega) {
        this.instrumento = instrumento;
        this.dataRecebimento = dataRecebimento;
        this.dataEntrega = dataEntrega;
    }
}
