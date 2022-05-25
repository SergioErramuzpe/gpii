package com.example.proyecto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.proyecto.Model.Pais;

public class NewPaisDestinoActivity extends AppCompatActivity {

    DBApplication da;
    Pais pais;
    EditText etNombre, etLatitud, etLongitud, etCapital, etCenso,etHuso,
    etIdiomas,etFrontera,etMoneda, etPresidente, etPrimerMinistro,
    etGobierno, etOrgano;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_pais_destino);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        pais = new Pais();
        pais.setNombre((String)bundle.getString("nombrePaisDestino"));
        getApplicationContext();
        da = (DBApplication) getApplication();

        etNombre = (EditText) findViewById(R.id.etNombre);
        etLatitud = (EditText) findViewById(R.id.etLatitud);
        etLongitud = (EditText) findViewById(R.id.etDescripcion);
        etCapital = (EditText) findViewById(R.id.etCapital);
        etCenso = (EditText) findViewById(R.id.etCenso);
        etHuso = (EditText) findViewById(R.id.etHuso);
        etIdiomas = (EditText) findViewById(R.id.etIdiomas);
        etFrontera = (EditText) findViewById(R.id.etFrontera);
        etMoneda = (EditText) findViewById(R.id.etMoneda);
        etPresidente = (EditText) findViewById(R.id.etPresidente);
        etPrimerMinistro = (EditText) findViewById(R.id.etPrimerMinistro);
        etGobierno = (EditText) findViewById(R.id.etGobierno);
        etOrgano = (EditText) findViewById(R.id.etOrgano);
        etNombre.setText(pais.getNombre());

    }

    public void showToast(String string) {
        Toast.makeText(this,string,Toast.LENGTH_SHORT).show();
    }

    public void guardarNuevoPaisDestino (View view) {
        pais.setNombre(etNombre.getText().toString());
        pais.setLongitud(Double.parseDouble(etLongitud.getText().toString()));
        pais.setLatitud(Double.parseDouble(etLatitud.getText().toString()));
        pais.setCapital(etCapital.getText().toString());
        pais.setCenso(etCenso.getText().toString());
        pais.setHuso(etHuso.getText().toString());
        pais.setIdiomas(etIdiomas.getText().toString());
        pais.setFronteras(etFrontera.getText().toString());
        pais.setMoneda(etMoneda.getText().toString());
        pais.setPresidente(etPresidente.getText().toString());
        pais.setPrimerMinistro(etPrimerMinistro.getText().toString());
        pais.setGobierno(etGobierno.getText().toString());
        pais.setOrgano(etOrgano.getText().toString());

        Bundle bundle = new Bundle();
        bundle.putSerializable("nuevoPaisDestino", pais);
        Intent intent = new Intent(da,AddPaisDestinoActivity.class);
        intent.putExtras(bundle);
        setResult(RESULT_OK, intent);
        finish();
    }
}