package com.example.projecteinditex;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ITXStock extends AppCompatActivity {


    Button btnSortida;
    EditText codi_sortida;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_itxstock);

        btnSortida = (Button)findViewById(R.id.BtnSortida);
        codi_sortida = (EditText)findViewById(R.id.et_codi_sortida);



        class ProvaDades extends Dades {

            public void EsborrarDades() {

                new ConsultarDatos().execute("https://unsectarian-stack.000webhostapp.com/Android/sortida.php?id="+etId.getText().toString());

            }
        }


        btnSortida.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (codi_sortida.getText().toString().isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Indrodueix el codi de l'article", Toast.LENGTH_LONG).show();
                    codi_sortida.setText("");

                }else {

                    ProvaDades P = new ProvaDades();
                    P.EsborrarDades();


                }
            }
        });





    }
}
