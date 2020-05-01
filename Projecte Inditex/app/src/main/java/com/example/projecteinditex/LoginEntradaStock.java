package com.example.projecteinditex;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginEntradaStock extends AppCompatActivity {

    Button botoAccedir;
    EditText codiEmpleat;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_entrada_stock);

        botoAccedir = (Button)findViewById(R.id.btnConsultar);
        codiEmpleat = (EditText)findViewById(R.id.etId);

        botoAccedir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (codiEmpleat.getText().toString().isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Indrodueix el codi de l'article", Toast.LENGTH_LONG).show();
                    codiEmpleat.setText("");

                }else if (codiEmpleat.getText().toString().equals("357269")) {



                }
            }
        });







    }

    public void EntradaStock(View view) {
        Intent anterior = new Intent(this, MainActivity.class);
        startActivity(anterior);
    }

}
