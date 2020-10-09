package cl.santotomas.evaluacion1matiasflores;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Intent intent = getIntent();
        String nombre = intent.getStringExtra(MainActivity.EXTRA_NOMBRE);
        String numtarjeta = intent.getStringExtra(MainActivity.EXTRA_NUMTARJETA);
        String fecha = intent.getStringExtra(MainActivity.EXTRA_FECHA);

        TextView Nombre = (TextView) findViewById(R.id.et_nombre);
        TextView NumTarjeta = (TextView) findViewById(R.id.et_numtarjeta);
        TextView Fecha = (TextView) findViewById(R.id.et_fecha);

        Nombre.setText(nombre);
        NumTarjeta.setText(numtarjeta);
        Fecha.setText(fecha);
    }
}