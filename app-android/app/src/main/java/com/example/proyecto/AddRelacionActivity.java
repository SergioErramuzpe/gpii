package com.example.proyecto;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

import com.example.proyecto.Model.Pais;
import com.example.proyecto.Model.Persona;
import com.example.proyecto.Model.Relacion;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.List;

public class AddRelacionActivity extends AppCompatActivity {

    DBApplication da;
    Spinner spOrigen, spDestino, spColor;
    ArrayAdapter <String> origenAdapter, destinoAdapter, colorAdapter, relacionesAdapter;
    ListView relacionesList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_relacion);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        spOrigen = (Spinner) findViewById(R.id.spOrigen);
        spDestino = (Spinner) findViewById(R.id.spDestino);
        spColor = (Spinner) findViewById(R.id.spColor);

        getApplicationContext();
        da = (DBApplication) getApplication();

        origenAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, da.getPersonas());
        spOrigen.setAdapter(origenAdapter);
        destinoAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, da.getNombresPaises());
        spDestino.setAdapter(destinoAdapter);
        colorAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, da.getColors());
        spColor.setAdapter(colorAdapter);

    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == 1) {
            Bundle bundle = data.getExtras();

            Relacion relacion;
            relacion = (Relacion) bundle.getSerializable("relacion");
            da.addRelacion(relacion);
        }
    }

    public void siguiente (View view) {
        Bundle bundle = new Bundle();
        if (spOrigen.getSelectedItem().toString().equals(spDestino.getSelectedItem().toString()))
            showToast("¡El pais de origen y de destino, no pueden ser el mismo!");
        else {
            bundle.putSerializable("persona", new Persona(spOrigen.getSelectedItem().toString()));
            bundle.putSerializable("destino", da.getPaisDestino(spDestino.getSelectedItem().toString()));
            bundle.putString("color", da.colores.get(spColor.getSelectedItem().toString()));
            Intent intent = new Intent(da, NewRelacionActivity.class);
            intent.putExtras(bundle);
            startActivityForResult(intent, 1);
        }
    }

    public void showToast(String string) {
        Toast.makeText(this,string,Toast.LENGTH_SHORT).show();
    }

}