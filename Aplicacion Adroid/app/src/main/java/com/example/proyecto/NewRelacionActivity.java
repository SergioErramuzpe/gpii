package com.example.proyecto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.example.proyecto.Model.Pais;
import com.example.proyecto.Model.Persona;
import com.example.proyecto.Model.Relacion;

public class NewRelacionActivity extends AppCompatActivity {


    TextView tvO,tvD;
    EditText etDescripcion, etTelefono, etDireccion, etWeb, etHorario,etMail;
    CheckBox chVisado,chPasaporte,chDNI;
    Pais pais;
    Persona persona;
    String color;
    Relacion relacion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_relacion);

        tvD = findViewById(R.id.tvDe);
        tvO = findViewById(R.id.tvOr);
        etDescripcion = findViewById(R.id.etDescripcion);
        etTelefono = findViewById(R.id.etTelefono);
        etDireccion = findViewById(R.id.etDireccion);
        etWeb = findViewById(R.id.etWeb);
        etHorario = findViewById(R.id.etHorario);
        etMail = findViewById(R.id.etMail);
        chVisado = findViewById(R.id.cbV);
        chDNI = findViewById(R.id.cbD);
        chPasaporte = findViewById(R.id.cbP);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        persona = (Persona)bundle.getSerializable("persona");
        pais = (Pais)bundle.getSerializable("destino");
        color = (String) bundle.getString("color");

        tvD.setText(pais.getNombre());
        tvO.setText(persona.getPais());
    }

    public void guardarNuevaRelacion (View view) {
        relacion = new Relacion(chDNI.isChecked(),chVisado.isChecked(),chPasaporte.isChecked(),pais,persona);
        relacion.setColor(color);
        relacion.setPaisDestino(pais);
        relacion.setPaisOrigen(persona);
        relacion.setDescripcion(etDescripcion.getText().toString());
        relacion.setDirec(etDireccion.getText().toString());
        relacion.setHorario(etHorario.getText().toString());
        relacion.setMail(etMail.getText().toString());
        relacion.setTel(etTelefono.getText().toString());
        relacion.setWeb(etWeb.getText().toString());
        Bundle bun = new Bundle();
        bun.putSerializable("relacion",relacion);
        Intent intent = new Intent();
        intent.putExtras(bun);
        setResult(1,intent);
        finish();
    }
}