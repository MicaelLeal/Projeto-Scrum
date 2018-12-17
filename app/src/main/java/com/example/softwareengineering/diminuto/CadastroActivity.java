package com.example.softwareengineering.diminuto;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.softwareengineering.diminuto.models.Instrumento;
import com.example.softwareengineering.diminuto.models.Usuario;

public class CadastroActivity extends AppCompatActivity {

    private EditText edtNome;
    private EditText edtDescricao;
    private EditText edtValor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        setupViews();

    }

    private void setupViews() {
        edtNome = findViewById(R.id.edit_cadastro_nome);
        edtDescricao = findViewById(R.id.edit_cadastro_desc);
        edtValor = findViewById(R.id.edit_cadastro_valor);
    }

    public void cadastrarInstrumento(View view) {
        String nome = edtNome.getText().toString();
        String descricao = edtDescricao.getText().toString();
        Double valor = Double.parseDouble(edtValor.getText().toString());
        Usuario usuario = MainActivity.usuarioLogado;

        Instrumento instrumento = new Instrumento(nome, descricao, usuario, valor);

        MainActivity.instrumentos.add(instrumento);
        finish();
    }
}
