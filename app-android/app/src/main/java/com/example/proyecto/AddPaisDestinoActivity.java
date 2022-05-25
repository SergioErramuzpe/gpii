package com.example.proyecto;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

import com.example.proyecto.Model.Pais;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.List;

public class AddPaisDestinoActivity extends AppCompatActivity {

    //Protocolos
    private static final int SHOW_MODIFYACTIVITY = 1;
    private static final int SHOW_ADDACTIVITY = 2;
    private static final int BORRAR = 27;

    private DBApplication da;
    private Intent intent;
    ListView listPaisDestino;
    EditText etPaisDestino;
    Button addNuevoPaisDestino;
    ArrayAdapter <String> todoItemsAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_pais_destino);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        listPaisDestino = (ListView) findViewById(R.id.listPaisDestino);
        etPaisDestino = (EditText) findViewById(R.id.etPaisDestino);
        addNuevoPaisDestino = (Button) findViewById(R.id.addNuevoPaisDestino);

        getApplicationContext();
        da = (DBApplication) getApplication();
        intent= new Intent(da,NewPaisDestinoActivity.class);

        cargarPaisesDestino();

    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == Activity.RESULT_OK) {
            Bundle bundle = data.getExtras();

            if (requestCode == SHOW_MODIFYACTIVITY) {
                Pais ant,post;
                ant = (Pais)bundle.getSerializable("paisAnt");
                post = (Pais) bundle.getSerializable("paisPost");
                da.modifyPais(ant, post);
                showToast("Se ha modificado "+ant.getNombre()+" ahora es, "+post.getNombre());
            } else if (requestCode == SHOW_ADDACTIVITY) {
                Pais nuevoPais = (Pais) bundle.getSerializable("nuevoPaisDestino");
                da.addNuevoNombrePais(nuevoPais);
                da.addNuevoPais(nuevoPais);
                showToast("Se ha introducido "+nuevoPais.getNombre());
            }
            cargarPaisesDestino();

        } else if(resultCode == BORRAR && requestCode == SHOW_MODIFYACTIVITY) {
            Bundle bundle = data.getExtras();
            Pais borrarPais = (Pais)bundle.getSerializable("borrarPaisDestino");
            da.borrarPais(borrarPais);
            showToast("Se ha borrado "+borrarPais.getNombre());
            cargarPaisesDestino();
        }

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK)) {
            Intent intent = new Intent(da,AdminActivity.class);
            startActivity(intent);
            finish();
        }
        return super.onKeyDown(keyCode, event);
    }

    public void showToast(String string) {
        Toast.makeText(this,string,Toast.LENGTH_SHORT).show();
    }


    public void anadirNuevoPaisDestino (View view) {
        String paisDestino = etPaisDestino.getText().toString();
        if (da.contienePaisDestino(paisDestino))
            showToast("No se puede introducir un país ya existente");
        else {
            Bundle bundle = new Bundle ();
            bundle.putString("nombrePaisDestino",paisDestino);
            Intent intent = new Intent(da,NewPaisDestinoActivity.class);
            intent.putExtras(bundle);
            startActivityForResult(intent,SHOW_ADDACTIVITY);
            cargarPaisesDestino();
        }

    }

    public void cargarPaisesDestino() {
        todoItemsAdapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, da.getNombresPaises());
        listPaisDestino.setAdapter(todoItemsAdapter);
        listPaisDestino.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String paisDestino = (String) listPaisDestino.getItemAtPosition(position);
                Pais paisAux = da.getPaisDestino(paisDestino);
                Bundle bundle = new Bundle ();
                bundle.putSerializable("paisDestino",paisAux);
                //showToast("Se ha elegido el pais "+da.getPaisDestino(paisDestino).getNombre());
                Intent intent = new Intent(da,ModifyRemovePaisDestinoActivity.class);
                intent.putExtras(bundle);
                startActivityForResult(intent,SHOW_MODIFYACTIVITY);
            }
        });
    }


}