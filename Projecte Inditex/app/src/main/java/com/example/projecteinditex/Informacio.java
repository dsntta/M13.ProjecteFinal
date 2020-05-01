package com.example.projecteinditex;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Informacio extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informacio);
    }

    // Mètode per tornar al principi (MainActivity)

    public void Anterior(View view) {
        Intent anterior = new Intent(this, MainActivity.class);
        startActivity(anterior);
    }


    // Mètode per accedir a la finestra de Login per afegir stock
    public void LoginEntradaStock(View view) {
        Intent anterior = new Intent(this, LoginEntradaStock.class);
        startActivity(anterior);
    }



}
