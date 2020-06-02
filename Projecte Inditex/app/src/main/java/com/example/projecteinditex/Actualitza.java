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
 * Titol: Actualitza
 * Desc: Classe que ens permet fer canvi d'ubicació
 * @author Marcos Di Santacroce
 * @version versió 1.0
 */


public class Actualitza extends AppCompatActivity {

    // Declaració dels components
    Button btnconsultar;
    EditText etId,talla,ubicacio;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actualitza);

        btnconsultar = (Button)findViewById(R.id.btnCorrecio);
        etId = (EditText)findViewById(R.id.et_article_corr);
        ubicacio = (EditText)findViewById(R.id.et_ubicacio_corr);
        talla = (EditText)findViewById(R.id.et_talla_corr);


        btnconsultar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Condició que comprova si tots els camps están plens, si hi ha un buit et demanará que els emplenis
                if (etId.getText().toString().isEmpty() || ubicacio.getText().toString().isEmpty() || talla.getText().toString().isEmpty()  ) {
                    Toast.makeText(getApplicationContext(), "Has d'emplenar tot els camps", Toast.LENGTH_LONG).show();
                    etId.setText("");

                // Condició que comprova l'ubicació, és a dir, si es 0 es magatzem i si es 1 es botiga
                }else {

                    // Correcció a Magatzem
                    if ( ubicacio.getText().toString().equals("0")) {

                        // Talla S Magatzem
                        if (talla.getText().toString().equals("1")) {
                            new CargarDatos().execute("https://unsectarian-stack.000webhostapp.com/Android/updateS_magatzem.php?id="+etId.getText().toString());
                        }

                        // Talla M Magatzem
                        else if (talla.getText().toString().equals("2")) {
                            new CargarDatos().execute("https://unsectarian-stack.000webhostapp.com/Android/updateM_magatzem.php?id="+etId.getText().toString());
                        }

                        // Talla L Magatzem
                        else if (talla.getText().toString().equals("3")) {
                            new CargarDatos().execute("https://unsectarian-stack.000webhostapp.com/Android/updateL_magatzem.php?id="+etId.getText().toString());
                        }

                        // Talla XL Magatzem
                        else if (talla.getText().toString().equals("4")) {
                            new CargarDatos().execute("https://unsectarian-stack.000webhostapp.com/Android/updateXL_magatzem.php?id="+etId.getText().toString());
                        }
                        // Talla XXL Magatzem
                        else if (talla.getText().toString().equals("5")) {
                            new CargarDatos().execute("https://unsectarian-stack.000webhostapp.com/Android/updateXXL_magatzem.php?id="+etId.getText().toString());
                        }

                        else {
                            Toast.makeText(getApplicationContext(), "Tala no vàlida, introdueix una talla de 1 a 5", Toast.LENGTH_LONG).show();
                        }

                    // Correcció a Botiga
                    }else if ( ubicacio.getText().toString().equals("1")) {

                        // Talla S Botiga
                        if (talla.getText().toString().equals("1")) {
                            new CargarDatos().execute("https://unsectarian-stack.000webhostapp.com/Android/updateS_botiga.php?id="+etId.getText().toString());
                        }

                        // Talla M Botiga
                        if (talla.getText().toString().equals("2")) {
                            new CargarDatos().execute("https://unsectarian-stack.000webhostapp.com/Android/updateM_botiga.php?id="+etId.getText().toString());
                        }

                        // Talla L Botiga
                        if (talla.getText().toString().equals("3")) {
                            new CargarDatos().execute("https://unsectarian-stack.000webhostapp.com/Android/updateL_botiga.php?id="+etId.getText().toString());
                        }

                        // Talla XL Botiga
                        if (talla.getText().toString().equals("1")) {
                            new CargarDatos().execute("https://unsectarian-stack.000webhostapp.com/Android/updateXL_botiga.php?id="+etId.getText().toString());
                        }

                        // Talla XXL Botiga
                        if (talla.getText().toString().equals("1")) {
                            new CargarDatos().execute("https://unsectarian-stack.000webhostapp.com/Android/updateXXL_botiga.php?id="+etId.getText().toString());
                        }

                    }else {
                        Toast.makeText(getApplicationContext(), "Ubicació no vàlida, sisplau introdueix una ubicació vàlida", Toast.LENGTH_LONG).show();
                    }
                }
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

            Toast.makeText(getApplicationContext(), "correcció feta amb èxit", Toast.LENGTH_LONG).show();
            etId.setText("");

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
