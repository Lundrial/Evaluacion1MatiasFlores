package cl.santotomas.evaluacion1matiasflores;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class DetailActivity extends AppCompatActivity {
        private ListView listView;
        private TarjetaAdapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        DatabaseHelper dataBaseHelper = new DatabaseHelper(DetailActivity.this);
        List<ModeloTarjeta> todos = dataBaseHelper.getTodas();

        listView = (ListView) findViewById(R.id.lvContact);

        Toast.makeText(DetailActivity.this, "Mostrando Tarjetas Guardadas en BD", Toast.LENGTH_SHORT).show();
        mAdapter = new TarjetaAdapter(this, todos);
        listView.setAdapter(mAdapter);
    }
}