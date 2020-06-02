package com.example.projecteinditex;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Titol: Opcions
 * Desc: Classe que ens permet fer una correció del nostre Stock
 * @author Marcos Di Santacroce
 * @version versió 1.0
 */


public class Opcions extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opcions);
    }


    // Mètode que ens porta al Activity per fer la correció
    public void Update(View view) {
        Intent anterior;
        anterior = new Intent(this, Actualitza.class);
        startActivity(anterior);
    }

    // Mètode per tornar al Menu principal
    public void Main(View view) {
        Intent anterior;
        anterior = new Intent(this, MainActivity.class);
        startActivity(anterior);
    }
}
