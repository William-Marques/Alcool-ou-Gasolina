package com.example.alcoolougasolina;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    //Criar as variaveis
    private TextInputEditText editPrecoAlcool, editPrecoGasolina;
    private TextView textResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //linkar as variaveis aos itens da tela
        editPrecoAlcool     = findViewById(R.id.editPrecoAlcool);
        editPrecoGasolina   = findViewById(R.id.editPrecoGasolina);
        textResultado       = findViewById(R.id.textResultado);

    }

    //Função para validar os campos, calcular os valores e exibir mensagem na tela
    public void calcularPreco (View view){

        //recuperar valores digitados
        String precoAlcool = editPrecoAlcool.getText().toString();
        String precoGasolina = editPrecoGasolina.getText().toString();

        //Chamar a função de Validar os campos digitados
        Boolean camposValidados = validarCampos(precoAlcool, precoGasolina);

        //Converter as Strings para numero, efetuar o calculo e exibir mensagem
        if (camposValidados) {
            //Convertendo string para números
            Double valorAlcool = Double.parseDouble( precoAlcool );
            Double valorGasolina = Double.parseDouble( precoGasolina );

            /* Fazer cáculo de menor preço
            Se (valorAlcool / valorGasolina >= 0.7 é melhor utilizar gasolina
            senão é melhor utilizar álcool
             */
            Double resultado = valorAlcool / valorGasolina;
            if (resultado >= 0.7 ){
                textResultado.setText("Melhor utilizar Gasolina");
            }else{
                textResultado.setText("Melhor utilizar Álcool");
            }
        }else{
            textResultado.setText("Preencha os preços primeiro!");
        }
    }

    //Função de validar os campos digitados
    public Boolean validarCampos( String pAlcool, String pGasolina){

        Boolean camposValidados = true;

        if( pAlcool == null || pAlcool.equals("")){
            camposValidados = false;
        }else if(pGasolina == null || pGasolina.equals("")){
            camposValidados = false;
        }

        return camposValidados;
    }

}
