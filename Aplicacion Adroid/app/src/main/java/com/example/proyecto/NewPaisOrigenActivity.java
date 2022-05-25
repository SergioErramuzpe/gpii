package com.example.proyecto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class NewPaisOrigenActivity extends AppCompatActivity {

    private Button anadeNuevoPaisOrigen;
    private EditText etPaisOrigen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_pais_origen);

        anadeNuevoPaisOrigen = (Button) findViewById(R.id.anadirNuevoPaisOrigen);
        etPaisOrigen = (EditText) findViewById(R.id.etNuevoPaisOrigen);
    }

    public void saveLocation(View view) {
        Bundle bundle = new Bundle();
        bundle.putString("nuevaPersona", (String) etPaisOrigen.getText().toString());
        Intent intent = new Intent();
        intent.putExtras(bundle);
        setResult(RESULT_OK, intent);
        finish();
    }
}