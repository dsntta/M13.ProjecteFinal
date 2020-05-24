package com.example.projecteinditex;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;

public class Entrada extends AppCompatActivity {


    Button btnconsultar,btnReset;
    EditText etId,etNomArticle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entrada);

        btnconsultar = (Button)findViewById(R.id.btnEntrada);
        btnReset = (Button)findViewById(R.id.btnReset_Entrada);
        etId = (EditText)findViewById(R.id.et_article_ent);
        etNomArticle = (EditText)findViewById(R.id.nom_article_ent);



        btnconsultar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (etId.getText().toString().isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Indrodueix el codi de l'article", Toast.LENGTH_LONG).show();
                    etId.setText("");

                }else {
                    //new CargarDatos().execute("https://unsectarian-stack.000webhostapp.com/Android/entrada.php?id="+etId.getText().toString());

                    new CargarDatos().execute("https://unsectarian-stack.000webhostapp.com/Android/entrada.php?id="+etId.getText().toString()+"&tel="+etNomArticle.getText().toString());
                }
            }
        });

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                etId.setText("");
                etNomArticle.setText("");

            }
        });

    }


    private class CargarDatos extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... urls) {

            // params comes from the execute() call: params[0] is the url.
            try {
                return downloadUrl(urls[0]);
            } catch (IOException e) {
                return "Unable to retrieve web page. URL may be invalid.";
            }
        }
        // onPostExecute displays the results of the AsyncTask.
        @Override
        protected void onPostExecute(String result) {

            Toast.makeText(getApplicationContext(), "S'han emmagatzemat les dades correctament", Toast.LENGTH_LONG).show();
            etId.setText("");
            etNomArticle.setText("");

        }
    }

    private String downloadUrl(String myurl) throws IOException {
        Log.i("URL",""+myurl);
        myurl = myurl.replace(" ","%20");
        InputStream is = null;
        // Only display the first 500 characters of the retrieved
        // web page content.
        int len = 500;

        try {
            URL url = new URL(myurl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setReadTimeout(10000 /* milliseconds */);
            conn.setConnectTimeout(15000 /* milliseconds */);
            conn.setRequestMethod("GET");
            conn.setDoInput(true);
            // Starts the query
            conn.connect();
            int response = conn.getResponseCode();
            Log.d("respuesta", "The response is: " + response);
            is = conn.getInputStream();

            // Convert the InputStream into a string
            String contentAsString = readIt(is, len);
            return contentAsString;

            // Makes sure that the InputStream is closed after the app is
            // finished using it.
        } finally {
            if (is != null) {
                is.close();
            }
        }
    }

    public String readIt(InputStream stream, int len) throws IOException, UnsupportedEncodingException {
        Reader reader = null;
        reader = new InputStreamReader(stream, "UTF-8");
        char[] buffer = new char[len];
        reader.read(buffer);
        return new String(buffer);
    }

}
