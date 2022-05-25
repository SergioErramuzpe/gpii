package com.example.proyecto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ModifyRemovePaisOrigenActivity extends AppCompatActivity {

    private final static int BORRAR = 27;
    private EditText etPaisOrigenExistente;
    private String personaAnt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify_remove_pais_origen);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        personaAnt = bundle.getString("borrarPersona");

        etPaisOrigenExistente = (EditText) findViewById(R.id.etExistentePaisOrigen);
        etPaisOrigenExistente.setText(personaAnt);

    }

    public void saveLocation(View view) {
        Bundle bundle = new Bundle();
        bundle.putString("personaAnt", (String) personaAnt);
        bundle.putString("personaPost", (String) etPaisOrigenExistente.getText().toString());
        Intent intent = new Intent();
        intent.putExtras(bundle);
        setResult(RESULT_OK, intent);
        finish();
    }

    public void borrarPersona (View view) {
        Bundle bundle = new Bundle();
        bundle.putString("borrarPersona", (String) personaAnt);
        Intent intent = new Intent();
        intent.putExtras(bundle);
        setResult(BORRAR, intent);
        finish();
    }
}