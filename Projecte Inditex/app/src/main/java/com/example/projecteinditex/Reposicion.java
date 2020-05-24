package com.example.projecteinditex;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;

public class Reposicion extends AppCompatActivity {


    EditText etId, etDesc,etPreu;
    EditText etTallaS_Magatzem,etTallaS,etTallaM,etTallaL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reposicion);



        etId = (EditText)findViewById(R.id.codi_article_repo);
        etDesc = (EditText)findViewById(R.id.desc_article_repo);
        etTallaS = (EditText)findViewById(R.id.tallaS_article_repo);
        etTallaM = (EditText)findViewById(R.id.tallaM_article_repo);
        etTallaL = (EditText)findViewById(R.id.tallaL_article_repo);

        etId.setEnabled(false);
        etDesc.setEnabled(false);
        etTallaS.setEnabled(false);
        etTallaM.setEnabled(false);
        etTallaL.setEnabled(false);

        new ConsultarDatos().execute("https://unsectarian-stack.000webhostapp.com/Android/consultaRepo.php");




    }

    public class CargarDatos extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... urls) {

            try {
                return downloadUrl(urls[0]);
            } catch (IOException e) {
                return "Unable to retrieve web page. URL may be invalid.";
            }
        }

        @Override
        protected void onPostExecute(String result) {

            Toast.makeText(getApplicationContext(), "Dades guardades correctament", Toast.LENGTH_LONG).show();

        }
    }


    public class ConsultarDatos extends AsyncTask<String, Void, String> {
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

            JSONArray ja = null;
            try {
                ja = new JSONArray(result);


                    etId.setText(ja.getString(0));
                    etDesc.setText(ja.getString(1));
                    etTallaS.setText(ja.getString(2));
                    etTallaM.setText(ja.getString(3));
                    etTallaL.setText(ja.getString(4));


            } catch (JSONException e) {
                e.printStackTrace();
                Toast.makeText(getApplicationContext(), "No Hi ha reposició", Toast.LENGTH_LONG).show();
            }
        }
    }

    public String downloadUrl(String myurl) throws IOException {
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


    // Método para la Activity anterior
    public void Anterior(View view) {
        Intent anterior = new Intent(this, MainActivity.class);
        startActivity(anterior);
    }
}
