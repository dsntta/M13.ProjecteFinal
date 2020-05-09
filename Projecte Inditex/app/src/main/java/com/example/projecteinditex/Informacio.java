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

    public void Exit(View view) {
        Intent anterior = new Intent(this, Sortides.class);
        startActivity(anterior);
    }

    public void In(View view) {
        Intent anterior;
        anterior = new Intent(this, Entrada.class);
        startActivity(anterior);
    }








}
