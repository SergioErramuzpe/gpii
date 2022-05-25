package com.example.proyecto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.proyecto.Model.Pais;

public class ModifyRemovePaisDestinoActivity extends AppCompatActivity {

    private static final int BORRAR = 27;

    Pais paisAnt,paisPost;
    EditText etNombre, etLatitud, etLongitud, etCapital, etCenso,etHuso,
            etIdiomas,etFrontera,etMoneda, etPresidente, etPrimerMinistro,
            etGobierno, etOrgano;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify_remove_pais_destino);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        paisAnt = (Pais) bundle.getSerializable("paisDestino");
        paisPost = new Pais();
        getApplicationContext();

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

        etNombre.setText(paisAnt.getNombre());
        etLatitud.setText(paisAnt.getLatitud().toString());
        etLongitud.setText(paisAnt.getLongitud().toString());
        etCapital.setText(paisAnt.getCapital());
        etCenso.setText(paisAnt.getCenso());
        etHuso.setText(paisAnt.getHuso());
        etIdiomas.setText(paisAnt.getIdiomas());
        etFrontera.setText(paisAnt.getFronteras());
        etMoneda.setText(paisAnt.getMoneda());
        etPresidente.setText(paisAnt.getPresidente());
        etPrimerMinistro.setText(paisAnt.getPrimerMinistro());
        etGobierno.setText(paisAnt.getGobierno());
        etOrgano.setText(paisAnt.getOrgano());
    }

    public void showToast(String string) {
        Toast.makeText(this,string,Toast.LENGTH_SHORT).show();
    }

    public void borrarPaisExistente (View view) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("borrarPaisDestino", paisAnt);
        Intent intent = new Intent();
        intent.putExtras(bundle);
        setResult(BORRAR, intent);
        finish();
    }

    public void guardarNuevoPaisDestino (View view) {
        paisPost.setNombre(paisAnt.getNombre());
        paisPost.setLongitud(paisAnt.getLongitud());
        paisPost.setLatitud(paisAnt.getLatitud());
        paisPost.setCapital(paisAnt.getCapital());
        paisPost.setCenso(paisAnt.getCenso());
        paisPost.setHuso(paisAnt.getHuso());
        paisPost.setIdiomas(paisAnt.getIdiomas());
        paisPost.setFronteras(paisAnt.getFronteras());
        paisPost.setMoneda(paisAnt.getMoneda());
        paisPost.setPresidente(paisAnt.getPresidente());
        paisPost.setPrimerMinistro(paisAnt.getPrimerMinistro());
        paisPost.setGobierno(paisAnt.getGobierno());
        paisPost.setOrgano(paisAnt.getOrgano());

        paisPost.setNombre(etNombre.getText().toString());
        paisPost.setLongitud(Double.parseDouble(etLongitud.getText().toString()));
        paisPost.setLatitud(Double.parseDouble(etLatitud.getText().toString()));
        paisPost.setCapital(etCapital.getText().toString());
        paisPost.setCenso(etCenso.getText().toString());
        paisPost.setHuso(etHuso.getText().toString());
        paisPost.setIdiomas(etIdiomas.getText().toString());
        paisPost.setFronteras(etFrontera.getText().toString());
        paisPost.setMoneda(etMoneda.getText().toString());
        paisPost.setPresidente(etPresidente.getText().toString());
        paisPost.setPrimerMinistro(etPrimerMinistro.getText().toString());
        paisPost.setGobierno(etGobierno.getText().toString());
        paisPost.setOrgano(etOrgano.getText().toString());

        Bundle bundle = new Bundle();
        bundle.putSerializable("paisAnt", paisAnt);
        bundle.putSerializable("paisPost",paisPost);
        Intent intent = new Intent();
        intent.putExtras(bundle);
        setResult(RESULT_OK, intent);
        finish();
    }
}