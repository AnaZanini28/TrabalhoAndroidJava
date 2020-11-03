package com.example.perfil;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class SaudeActivity extends AppCompatActivity {

    private Button btnSalvar;
    private Button btnLimpar;
    private TextInputEditText editAltura;
    private TextInputEditText editPeso;
    private TextInputEditText editExercicio;
    private TextInputEditText editMedicamentos;
    private TextView texIMC;
    private TextView textSituacao;

    private static final String ARQUIVO_PREFERENCIA = "Arquivo_preferencia";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saude);

        btnSalvar = findViewById(R.id.btnSalvar);
        btnLimpar = findViewById(R.id.btnLimpar);
        editAltura = findViewById(R.id.editAltura);
        editPeso = findViewById(R.id.editPeso);
        editExercicio = findViewById(R.id.editExercicio);
        editMedicamentos = findViewById(R.id.editMedicamentos);
        texIMC = findViewById(R.id.texIMC);
        textSituacao = findViewById(R.id.textSituacao);

        btnLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences preferences = getSharedPreferences(ARQUIVO_PREFERENCIA,0);
                SharedPreferences.Editor editor = preferences.edit();

                editor.putString("altura","");
                editor.putString("peso","");
                editor.putString("exercicio","");
                editor.putString("medicamentos","");
                editor.putString("situacao","");
                editor.putString("imc","");
                editor.commit();

                editAltura.setText("");
                editPeso.setText("");
                editExercicio.setText("");
                editMedicamentos.setText("");
                texIMC.setText("");
                textSituacao.setText("");
                editAltura.requestFocus();

                Toast.makeText(getApplicationContext(),"Os dados foram apagados.",Toast.LENGTH_LONG).show();
            }
        });

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences preferences = getSharedPreferences(ARQUIVO_PREFERENCIA,0);
                SharedPreferences.Editor editor = preferences.edit();

                //
                if(editAltura.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(),"Preencha a altura",Toast.LENGTH_LONG).show();
                    return;
                }else{
                    String altura = editAltura.getText().toString();
                    editor.putString("altura",altura);
                }
                //
                if(editPeso.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(),"Preencha o peso",Toast.LENGTH_LONG).show();
                    return;
                }else{
                    String peso = editPeso.getText().toString();
                    editor.putString("peso",peso);
                }
                //
                if(editExercicio.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(),"Preencha o campo de exercício",Toast.LENGTH_LONG).show();
                    return;
                }else{
                    String exercicio = editExercicio.getText().toString();
                    editor.putString("exercicio",exercicio);
                }
                //
                if(editMedicamentos.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(),"Preencha o campo de medicamentos",Toast.LENGTH_LONG).show();
                    return;
                }else{
                    String medicamentos = editMedicamentos.getText().toString();
                    editor.putString("medicamentos",medicamentos);
                }
                //
                String imc = "";
                String situacao = "";

                if(texIMC.getText().toString().equals("")){
                    editor.putString("imc","");
                }else{
                    imc = texIMC.getText().toString();
                    editor.putString("imc",imc);
                }
                //
                if(textSituacao.getText().toString().equals("")){
                    editor.putString("situacao","");
                }else{
                    situacao = textSituacao.getText().toString();
                    editor.putString("situacao",situacao);
                }

                editor.commit();

                editAltura.setText("");
                editPeso.setText("");
                editExercicio.setText("");
                editMedicamentos.setText("");
                texIMC.setText("");
                textSituacao.setText("");
                editAltura.requestFocus();
                Toast.makeText(getApplicationContext(),"Salvo",Toast.LENGTH_LONG).show();

            }
        });

            editAltura.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                @Override
                public void onFocusChange(View v, boolean hasFocus) {
                    if(editAltura.equals("")){
                        return;
                    }
                    if(editPeso.equals("")){
                        return;
                    }
                    try {
                        Double.parseDouble(editPeso.getText().toString());
                    }catch (NumberFormatException ex){
                        Toast.makeText(getApplicationContext(),"Peso inválido",Toast.LENGTH_LONG).show();
                        return;
                    }
                    try {
                        Double.parseDouble(editAltura.getText().toString());
                    }catch (NumberFormatException ex){
                        Toast.makeText(getApplicationContext(),"Altura inválida",Toast.LENGTH_LONG).show();
                        return;
                    }

                    calculaIMC();

                }
            });

            editPeso.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                @Override
                public void onFocusChange(View v, boolean hasFocus) {
                    if(editAltura.equals("")){
                        return;
                    }
                    if(editPeso.equals("")){
                        return;
                    }
                    try {
                        Double.parseDouble(editPeso.getText().toString());
                    }catch (NumberFormatException ex){
                        Toast.makeText(getApplicationContext(),"Peso inválido",Toast.LENGTH_LONG).show();
                        return;
                    }
                    try {
                        Double.parseDouble(editAltura.getText().toString());
                    }catch (NumberFormatException ex){
                        Toast.makeText(getApplicationContext(),"Altura inválida",Toast.LENGTH_LONG).show();
                        return;
                    }

                    calculaIMC();

                }
            });

        SharedPreferences preferences = getSharedPreferences(ARQUIVO_PREFERENCIA, 0);
        //
        if(preferences.contains("altura")){
            String altura = preferences.getString("altura","");
            editAltura.setText(altura);
        }else{
            editAltura.setText("");
        }
        //
        if(preferences.contains("peso")){
            String peso = preferences.getString("peso","");
            editPeso.setText(peso);
        }else{
            editPeso.setText("");
        }
        //
        if(preferences.contains("exercicio")){
            String exercicio = preferences.getString("exercicio","");
            editExercicio.setText(exercicio);
        }else{
            editExercicio.setText("");
        }
        //
        if(preferences.contains("medicamentos")){
            String medicamentos = preferences.getString("medicamentos","");
            editMedicamentos.setText(medicamentos);
        }else{
            editMedicamentos.setText("");
        }

        //
        if(preferences.contains("imc")){
            String imc = preferences.getString("imc","");
            texIMC.setText(imc);
        }else{
            texIMC.setText("");
        }
        //
        if(preferences.contains("situacao")){
            String situacao = preferences.getString("situacao","");
            textSituacao.setText(situacao);
        }else{
            textSituacao.setText("");
        }
        editAltura.requestFocus();

    }

    public void calculaIMC(){

        double peso = Double.parseDouble(editPeso.getText().toString());
        double altura = Double.parseDouble(editAltura.getText().toString());

        double resultado = Math.round(peso/(altura*altura));

        texIMC.setText(resultado+"");

        if(resultado < 18.5){
           textSituacao.setText("Magreza.");
        }else if( resultado > 18.6 && resultado < 24.9 ){
            textSituacao.setText("Peso Normal.");
        }else if(resultado > 25 && resultado < 29.9){
            textSituacao.setText("Sobrepeso.");
        }else if(resultado > 30 && resultado < 34.9){
            textSituacao.setText("Obesidade grau I ");
        }else if(resultado > 35 && resultado < 39.9){
            textSituacao.setText("Obesidade grau II ");
        } else if(resultado > 40 ){
            textSituacao.setText("Obesidade grau III ");
        }


    }
}
