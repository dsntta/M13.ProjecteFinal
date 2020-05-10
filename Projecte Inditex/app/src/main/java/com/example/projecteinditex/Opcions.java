package com.example.projecteinditex;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Opcions extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opcions);
    }


    public void Update(View view) {
        Intent anterior;
        anterior = new Intent(this, Actualitza.class);
        startActivity(anterior);
    }

    public void Main(View view) {
        Intent anterior;
        anterior = new Intent(this, MainActivity.class);
        startActivity(anterior);
    }

}
