package com.example.projecteinditex;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Seccio extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seccio);
    }

    public void Reposicio(View view) {

        Intent repo = new  Intent(this, Reposicion.class);
        startActivity(repo);
    }
}
