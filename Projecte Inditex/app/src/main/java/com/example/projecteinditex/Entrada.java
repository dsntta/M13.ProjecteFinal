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

/**
 * Titol: Entrada
 * Desc: Classe que ens guardará contingut a la nostra base de dades el Stock que entra a magatzem
 * @author Marcos Di Santacroce
 * @version versió 1.0
 */


public class Entrada extends AppCompatActivity {


    // Declaració dels components

    Button btnconsultar,btnReset;
    EditText etId,etNomArticle,etTallaS,etTallaM,etTallaL,etTallaXL,etTallaXXL;


    // Instancia principal (Quan carrega l'Activity)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entrada);

        btnconsultar = (Button)findViewById(R.id.btnEntrada);
        btnReset = (Button)findViewById(R.id.btnReset_Entrada);
        etId = (EditText)findViewById(R.id.et_article_ent);
        etNomArticle = (EditText)findViewById(R.id.nom_article_ent);
        etTallaS = (EditText)findViewById(R.id.talla_s_ent);
        etTallaM = (EditText)findViewById(R.id.talla_m_ent);
        etTallaL = (EditText)findViewById(R.id.talla_l_ent);
        etTallaXL = (EditText)findViewById(R.id.talla_xl_ent);
        etTallaXXL = (EditText)findViewById(R.id.talla_xxl_ent);


        // Botó Consultar, fa la consulta a la base de dades amb el codi que li enviem a través de mètode GET
        btnconsultar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (etId.getText().toString().isEmpty() && etNomArticle.getText().toString().isEmpty() ) {
                    Toast.makeText(getApplicationContext(), "Heu d'emplenar tots els camps", Toast.LENGTH_LONG).show();


                }else {
                    new CargarDatos().execute("https://unsectarian-stack.000webhostapp.com/Android/entrada.php?id="+etId.getText().toString()
                            +"&tel="+etNomArticle.getText().toString() +"&s="+etTallaS.getText().toString() +"&m="+etTallaM.getText().toString()
                            +"&l="+etTallaL.getText().toString() +"&xl="+etTallaXL.getText().toString() +"&xxl="+etTallaXXL.getText().toString());
                }
            }
        });

        // Botó que deixa tots els EditText en blanc, per un altre cerca
        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                etId.setText("");
                etNomArticle.setText("");
                etTallaS.setText("");
                etTallaM.setText("");
                etTallaL.setText("");
                etTallaXL.setText("");
                etTallaXXL.setText("");

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

        // Si s'executa amb èxit, s'executa aquest mètode
        @Override
        protected void onPostExecute(String result) {
            Toast.makeText(getApplicationContext(), "S'han emmagatzemat les dades correctament", Toast.LENGTH_LONG).show();
            etId.setText("");
            etNomArticle.setText("");
            etTallaS.setText("");
            etTallaM.setText("");
            etTallaL.setText("");
            etTallaXL.setText("");
            etTallaXXL.setText("");
        }
    }


    // Mètode a on connectem amb la base de dades
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


    // Mètode que llegeix el contingut
    public String readIt(InputStream stream, int len) throws IOException, UnsupportedEncodingException {
        Reader reader = null;
        reader = new InputStreamReader(stream, "UTF-8");
        char[] buffer = new char[len];
        reader.read(buffer);
        return new String(buffer);
    }
}
