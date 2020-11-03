package com.example.perfil;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class PessoalActivity extends AppCompatActivity {

    private Button btnSalvar;
    private Button bntLimpar;
    private TextInputEditText editNome;
    private TextInputEditText editNascimento;
    private TextInputEditText editCpf;
    private TextInputEditText editCelular;
    private TextInputEditText editEmail;

    private static final String ARQUIVO_PREFERENCIA = "Arquivo_preferencia";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pessoal);

        btnSalvar = findViewById(R.id.bntSalva);
        bntLimpar = findViewById(R.id.bntLimpar);
        editNome = findViewById(R.id.editNome);
        editNascimento = findViewById(R.id.editNascimento);
        editCpf = findViewById(R.id.editCpf);
        editCelular = findViewById(R.id.editCelular);
        editEmail = findViewById(R.id.editEmail);

        bntLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences preferences = getSharedPreferences(ARQUIVO_PREFERENCIA,0);
                SharedPreferences.Editor editor = preferences.edit();

                editor.putString("nome","");
                editor.putString("nascimento","");
                editor.putString("cpf","");
                editor.putString("celular","");
                editor.putString("email","");
                editor.commit();

                editNome.setText("");
                editNascimento.setText("");
                editCpf.setText("");
                editCelular.setText("");
                editEmail.setText("");
                editNome.requestFocus();

                Toast.makeText(getApplicationContext(),"Os dados foram apagados.",Toast.LENGTH_LONG).show();
            }
        });

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences preferences = getSharedPreferences(ARQUIVO_PREFERENCIA,0);
                SharedPreferences.Editor editor = preferences.edit();

                //
                if(editNome.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(),"Preencha o nome",Toast.LENGTH_LONG).show();
                    return;
                }else{
                    String nome = editNome.getText().toString();
                    editor.putString("nome",nome);
                }

                //
                if(editNascimento.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(),"Preencha a data de nascimento",Toast.LENGTH_LONG).show();
                    return;
                }else{
                    String nascimento = editNascimento.getText().toString();
                    editor.putString("nascimento",nascimento);
                }

                //
                if(editCpf.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(),"Preencha o CPF",Toast.LENGTH_LONG).show();
                    return;
                }else{
                    String cpf = editCpf.getText().toString();
                    editor.putString("cpf",cpf);
                }

                //
                if(editCelular.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(),"Preencha o celular",Toast.LENGTH_LONG).show();
                    return;
                }else{
                    String celular = editCelular.getText().toString();
                    editor.putString("celular",celular);
                }

                //
                if(editEmail.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(),"Preencha o e-mail",Toast.LENGTH_LONG).show();
                    return;
                }else{
                    String email = editEmail.getText().toString();
                    editor.putString("email",email);
                }


                editor.commit();
                editNome.setText("");
                editNascimento.setText("");
                editCpf.setText("");
                editCelular.setText("");
                editEmail.setText("");
                editNome.requestFocus();

                Toast.makeText(getApplicationContext(),"Salvo",Toast.LENGTH_LONG).show();

            }
        });

        SharedPreferences preferences = getSharedPreferences(ARQUIVO_PREFERENCIA, 0);
        //
        if(preferences.contains("nome")){
            String nome = preferences.getString("nome","");
            editNome.setText(nome);
        }else{
            editNome.setText("");
        }
        //
        if(preferences.contains("nascimento")){
            String nascimento = preferences.getString("nascimento","");
            editNascimento.setText(nascimento);
        }else{
            editNascimento.setText("");
        }
        //
        if(preferences.contains("cpf")){
            String cpf = preferences.getString("cpf","");
            editCpf.setText(cpf);
        }else{
            editCpf.setText("");
        }
        //
        if(preferences.contains("celular")){
            String celular = preferences.getString("celular","");
            editCelular.setText(celular);
        }else{
            editCelular.setText("");
        }
        //
        if(preferences.contains("email")){
            String email = preferences.getString("email","");
            editEmail.setText(email);
        }else{
            editEmail.setText("");
        }
        editNome.requestFocus();
    }
}
