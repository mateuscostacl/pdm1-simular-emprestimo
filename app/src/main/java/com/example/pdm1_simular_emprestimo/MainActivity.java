package com.example.pdm1_simular_emprestimo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.pdm1_simular_emprestimo.model.Cliente;
import com.example.pdm1_simular_emprestimo.util.Util;

public class MainActivity extends AppCompatActivity {

    EditText etNome;
    EditText etValorEmprestimo;
    EditText etParcelas;
    EditText etSalario;
    Button btSolicitar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inicializar();
    }

    private void inicializar() {
        etNome = findViewById(R.id.et_nome);
        etValorEmprestimo = findViewById(R.id.et_valor_emprestimo);
        etParcelas = findViewById(R.id.et_parcelas);
        etSalario = findViewById(R.id.et_salario);
        btSolicitar = findViewById(R.id.bt_solicitar);

        btSolicitar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                solicitar_emprestimo();
            }
        });
    }

    private void solicitar_emprestimo() {
        Cliente cliente = new Cliente();
        cliente.setNome(etNome.getText().toString());
        cliente.setSalario(Double.parseDouble(etSalario.getText().toString()));
        cliente.setValorEmprestimo(Double.parseDouble(etValorEmprestimo.getText().toString()));
        cliente.setParcelas(Integer.parseInt(etParcelas.getText().toString()));

        if (!indicador(cliente, 30.0)) {
            Util.mostrarUmaMensagem_AlertDialog(this, "Que pena!", "Desculpe mas não será possível conceder o empréstimo!");
            return;
        }

        String mensagem = String.format("Seu empréstimo será de %.2f, dividido em %d parcelas de %.2f", cliente.getValorEmprestimo(), cliente.getParcelas(), cliente.getValorEmprestimo() / cliente.getParcelas());

        Util.mostrarUmaMensagem_AlertDialog(this, "Parabéns!", mensagem);

    }

    private boolean indicador(Cliente c, Double porcentagem) {
        Double trinta = c.getSalario() * (porcentagem / 100);
        Double valorParcelado = c.getValorEmprestimo() / c.getParcelas();
        return valorParcelado <= trinta;
    }
}