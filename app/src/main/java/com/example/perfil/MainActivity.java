package com.example.perfil;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {
    private Button btnPessoal;
    private Button btnSaude;
    private Button btnAtualiza;
    private Button btnSobre;
    private TextView textNome;
    private TextView textNascimento;
    private TextView textCpf;
    private TextView textCelular;
    private TextView textEmail;
    private TextView textAltura;
    private TextView textPeso;
    private TextView textIMC;
    private TextView textSituacao;

    private static final String ARQUIVO_PREFERENCIA = "Arquivo_preferencia";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSobre = findViewById(R.id.btnSobre);
        btnAtualiza = findViewById(R.id.btnAtualiza);
        btnPessoal = findViewById(R.id.btnPessoal);
        btnSaude = findViewById(R.id.btnSaude);
        textNome = findViewById(R.id.textNome);
        textNascimento = findViewById(R.id.textNascimento);
        textCpf = findViewById(R.id.textCpf);
        textCelular = findViewById(R.id.textCelular);
        textEmail = findViewById(R.id.textEmail);
        textAltura = findViewById(R.id.textAltura);
        textPeso = findViewById(R.id.textPeso);
        textIMC = findViewById(R.id.textIMC);
        textSituacao = findViewById(R.id.textSituacao);

        btnAtualiza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences preferences = getSharedPreferences(ARQUIVO_PREFERENCIA, 0);
                //
                if(preferences.contains("nome")){
                    String nome = preferences.getString("nome","Faça seu cadastrado");
                    if(nome.equals("")) {
                        textNome.setText("Faça seu cadastrado");
                    }else{
                        textNome.setText(nome);
                    }
                }else{
                    textNome.setText("Faça seu cadastrado");
                }
                //
                if(preferences.contains("nascimento")){
                    String nascimento = preferences.getString("nascimento","");
                    textNascimento.setText(nascimento);
                }else{
                    textNascimento.setText("");
                }
                //
                if(preferences.contains("cpf")){
                    String cpf = preferences.getString("cpf","");
                    textCpf.setText(cpf);
                }else{
                    textCpf.setText("");
                }
                //
                if(preferences.contains("celular")){
                    String celular = preferences.getString("celular","");
                    textCelular.setText(celular);
                }else{
                    textCelular.setText("");
                }
                //
                if(preferences.contains("email")){
                    String email = preferences.getString("email","");
                    textEmail.setText(email);
                }else{
                    textEmail.setText("");
                }
                //
                if(preferences.contains("altura")){
                    String altura = preferences.getString("altura","");
                    textAltura.setText(altura);
                }else{
                    textAltura.setText("");
                }
                //
                if(preferences.contains("peso")){
                    String peso = preferences.getString("peso","");
                    textPeso.setText(peso);
                }else{
                    textPeso.setText("");
                }
                //
                if(preferences.contains("imc")){
                    String imc = preferences.getString("imc","");
                    textIMC.setText(imc);
                }else{
                    textIMC.setText("");
                }
                //
                if(preferences.contains("situacao")){
                    String situacao = preferences.getString("situacao","");
                    textSituacao.setText(situacao);
                }else{
                    textSituacao.setText("");
                }
            }
        });
        //
        btnPessoal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), PessoalActivity.class);

                startActivity( intent );
            }
        });
        //
        btnSaude.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentS = new Intent(getApplicationContext(),SaudeActivity.class);

                startActivity( intentS );
            }
        });
        //
        btnSobre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentSobre = new Intent(getApplicationContext(),SobreActivity.class);

                startActivity(intentSobre);
            }
        });

        SharedPreferences preferences = getSharedPreferences(ARQUIVO_PREFERENCIA, 0);
        //
        if(preferences.contains("nome")){

            String nome = preferences.getString("nome","Faça seu cadastrado");
            if(nome.equals("")) {
                textNome.setText("Faça seu cadastrado");
            }else{
                textNome.setText(nome);
            }
        }else{
            textNome.setText("Faça seu cadastrado");
        }
        //
        if(preferences.contains("nascimento")){
            String nascimento = preferences.getString("nascimento","");
            textNascimento.setText(nascimento);
        }else{
            textNascimento.setText("");
        }
        //
        if(preferences.contains("cpf")){
            String cpf = preferences.getString("cpf","");
            textCpf.setText(cpf);
        }else{
            textCpf.setText("");
        }
        //
        if(preferences.contains("celular")){
            String celular = preferences.getString("celular","");
            textCelular.setText(celular);
        }else{
            textCelular.setText("");
        }
        //
        if(preferences.contains("email")){
            String email = preferences.getString("email","");
            textEmail.setText(email);
        }else{
            textEmail.setText("");
        }
        //
        if(preferences.contains("altura")){
            String altura = preferences.getString("altura","");
            textAltura.setText(altura);
        }else{
            textEmail.setText("");
        }
        //
        if(preferences.contains("peso")){
            String peso = preferences.getString("peso","");
            textPeso.setText(peso);
        }else{
            textPeso.setText("");
        }
        //
        if(preferences.contains("imc")){
            String imc = preferences.getString("imc","");
            textIMC.setText(imc);
        }else{
            textIMC.setText("");
        }
        //
        if(preferences.contains("situacao")){
            String situacao = preferences.getString("situacao","");
            textSituacao.setText(situacao);
        }else{
            textSituacao.setText("");
        }

    }
}
