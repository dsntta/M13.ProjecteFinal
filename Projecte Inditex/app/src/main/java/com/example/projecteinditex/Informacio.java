package com.example.projecteinditex;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Titol: Informacio
 * Desc: Classe amb mètodes per passar d'un Activity a un altre
 * @author Marcos Di Santacroce
 * @version versió 1.0
 */



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

    public void Update(View view) {
        Intent anterior;
        anterior = new Intent(this, Opcions.class);
        startActivity(anterior);
    }








}
