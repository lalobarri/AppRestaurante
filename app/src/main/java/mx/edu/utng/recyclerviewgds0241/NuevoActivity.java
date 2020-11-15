package mx.edu.utng.recyclerviewgds0241;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Toast;

public class NuevoActivity extends AppCompatActivity {
    private Button btnAgregar;
    private WebView wbNavega;
    private MyRestauranteRecyclerViewAdapter adapterRestaurantes;
    private RestauranteLab mRestaurante;

    @Override
    public void onBackPressed() {
        Intent intNuevo = new Intent(NuevoActivity.this, MainActivity.class);
        startActivity(intNuevo);
        finish();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuevo);

        btnAgregar = (Button)findViewById(R.id.btnAgregar);
        wbNavega = (WebView)findViewById(R.id.wbNavegador);
        EditText etNombre=findViewById(R.id.etNombre);
        EditText etImagen=findViewById(R.id.etImagen);
        EditText etDir=findViewById(R.id.etDir);
        RatingBar rbVal = findViewById(R.id.ratingBar);

        wbNavega.getSettings().setJavaScriptEnabled(true);

        wbNavega.loadUrl("https://www.google.com/");
        btnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    RestauranteLab mRestaurante = RestauranteLab.get(getApplicationContext());
                    Restaurante r = new Restaurante();
                    r.setNombre(etNombre.getText().toString());
                    r.setUrlPhoto(etImagen.getText().toString());
                    r.setValoracion(rbVal.getRating());
                    r.setDireccion(etDir.getText().toString());
                    mRestaurante.addRestaurante(r);
                    //RestauranteFragment rf = new RestauranteFragment();
                    //rf.getAdapterRestaurantes();
                    Toast.makeText(NuevoActivity.this, "Se han agregaron los datos de: " + r.getNombre() ,Toast.LENGTH_LONG).show();

                }catch (Exception e){
                    Toast.makeText(NuevoActivity.this, "Hay un error con los datos por favor intenta nuevamente, Error"+e.getMessage(),Toast.LENGTH_LONG).show();
                }

            }
        });
    }
}