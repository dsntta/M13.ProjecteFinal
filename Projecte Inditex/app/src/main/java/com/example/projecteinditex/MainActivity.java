package com.example.projecteinditex;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // Método per accedir a l'opció de resposició (.25)
    public void Reposicio(View view) {

        Intent repo = new  Intent(this, Seccio.class);
        startActivity(repo);
    }


    // Método per accedir a l'opció de consulta de Stock
    public void ConsultaStock(View view) {

        Intent repo = new  Intent(this, Dades.class);
        startActivity(repo);
    }

    // Método per accedir a l'opció de consulta de Stock
    public void ActualitzarStock(View view) {

        Intent repo = new  Intent(this, Informacio.class);
        startActivity(repo);
    }




}
