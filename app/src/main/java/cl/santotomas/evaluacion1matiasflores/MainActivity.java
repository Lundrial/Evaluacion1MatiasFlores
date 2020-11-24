package cl.santotomas.evaluacion1matiasflores;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private EditText etNombres, etApellidos, etNumtarjeta, etMes, etAño, etCVV, etCalle, etCallenum, etCiudad, etEstado, etPostal;
    private Button btnGuardar, btnVer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNombres = findViewById(R.id.et_nombres); // Verificar el espacio "nombres"
        etApellidos = findViewById(R.id.et_apellidos); // ..
        etNumtarjeta = findViewById(R.id.et_numtarjeta); // ..
        etMes = findViewById(R.id.et_mes);
        etAño = findViewById(R.id.et_año);
        etCVV = findViewById(R.id.et_CVV);
        etCalle = findViewById(R.id.et_calle);
        etCallenum = findViewById(R.id.et_callenum);
        etCiudad = findViewById(R.id.et_ciudad);
        etEstado = findViewById(R.id.et_estado);
        etPostal = findViewById(R.id.et_postal); // ..
        btnGuardar = findViewById(R.id.btn_guardar); // Verificar el boton
        btnVer = findViewById(R.id.btn_ver); // Verificar el boton
        btnGuardar.setEnabled(false); // Deshabilitar el boton hasta que los campos esten llenos

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ModeloTarjeta modeloTarjeta;

                try {
                    modeloTarjeta = new ModeloTarjeta(-1, etNombres.getText().toString() + " " + etApellidos.getText().toString(), etNumtarjeta.getText().toString(), etMes.getText().toString() + "/" + etAño.getText().toString().substring(2));
                    Toast.makeText(MainActivity.this, "Tarjeta agregada correctamente", Toast.LENGTH_SHORT).show();
                } catch(Exception e) {
                    Toast.makeText(MainActivity.this, "Error al crear tarjeta", Toast.LENGTH_SHORT).show();
                    modeloTarjeta = new ModeloTarjeta(-1, "error", "error", "error");
                }

                DatabaseHelper dataBaseHelper = new DatabaseHelper(MainActivity.this);

                boolean success = dataBaseHelper.addTarjeta(modeloTarjeta);
            }
        });

        btnVer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity2();
            }
        });

        etNombres.addTextChangedListener(confirmacionTextWatcher);
        etApellidos.addTextChangedListener(confirmacionTextWatcher);
        etNumtarjeta.addTextChangedListener(confirmacionTextWatcher);
        etMes.addTextChangedListener(confirmacionTextWatcher);
        etAño.addTextChangedListener(confirmacionTextWatcher);
        etCVV.addTextChangedListener(confirmacionTextWatcher);
        etCalle.addTextChangedListener(confirmacionTextWatcher);
        etCallenum.addTextChangedListener(confirmacionTextWatcher);
        etCiudad.addTextChangedListener(confirmacionTextWatcher);
        etEstado.addTextChangedListener(confirmacionTextWatcher);
        etPostal.addTextChangedListener(confirmacionTextWatcher);


    }

    private TextWatcher confirmacionTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            String inputNombres = etNombres.getText().toString().trim();
            String inputApellidos = etApellidos.getText().toString().trim();
            String inputNumTarjeta = etNumtarjeta.getText().toString().trim();
            String inputMes = etMes.getText().toString().trim();
            String inputAño = etAño.getText().toString().trim();
            String inputCVV = etCVV.getText().toString().trim();
            String inputCalle = etCalle.getText().toString().trim();
            String inputCallenum = etCallenum.getText().toString().trim();
            String inputCiudad = etCiudad.getText().toString().trim();
            String inputEstado = etEstado.getText().toString().trim();
            String inputPostal = etPostal.getText().toString().trim();

            btnGuardar.setEnabled(!inputNombres.isEmpty() && !inputApellidos.isEmpty() && !inputNumTarjeta.isEmpty() && !inputMes.isEmpty() && !inputAño.isEmpty() && !inputCVV.isEmpty() && !inputCalle.isEmpty() && !inputCallenum.isEmpty() && !inputCiudad.isEmpty() && !inputEstado.isEmpty() && !inputPostal.isEmpty() && inputNumTarjeta.length() == 16 && inputAño.length() == 4);
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };

    public void openActivity2() {
        Intent intent = new Intent(this, DetailActivity.class);
        startActivity(intent);
    }
}