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


public class Seccio extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seccio);
    }

    // Mètode que en porta a l'Activity de Reposició
    public void Reposicio(View view) {

        Intent repo = new  Intent(this, Reposicion.class);
        startActivity(repo);
    }

    // Mètode que ens torna al principi (Menu Principal)
    public void Prinipi(View view) {

        Intent repo = new  Intent(this, MainActivity.class);
        startActivity(repo);
    }
}
