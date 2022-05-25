package com.example.proyecto;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class AdminActivity extends AppCompatActivity {

    //Protocolos
    private static final int SHOW_MODIFYACTIVITY = 1;
    private static final int SHOW_ADDACTIVITY = 2;
    private static final int BORRAR = 27;

    // Var context y layout
    private DBApplication da;
    private ListView listPersonas;
    private Button addPaisDestino, addPersona,addRelacion;
    private ArrayAdapter <String> todoItemsAdapter;



    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        listPersonas = (ListView) findViewById(R.id.listPersona);
        addPaisDestino = (Button) findViewById(R.id.addPaisDestino);
        addPersona = (Button) findViewById(R.id.addPersona);
        addRelacion = (Button) findViewById(R.id.addRelacion);

        getApplicationContext();
        da = (DBApplication) getApplication();

        cargarPersonas();

        addPersona.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(da, NewPaisOrigenActivity.class);
                startActivityForResult(intent, SHOW_ADDACTIVITY);
            }
        });


        addRelacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(da,AddRelacionActivity.class);
                startActivity(intent);
            }
        });

        addPaisDestino.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(da,AddPaisDestinoActivity.class);
                startActivity(intent);
            }
        });

    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == Activity.RESULT_OK) {

            Bundle bundle = data.getExtras();

            if (requestCode == SHOW_MODIFYACTIVITY) {
                String ant,post;
                ant = bundle.getString("personaAnt");
                post = bundle.getString("personaPost");
                da.modifyPersona(ant, post);
                showToast("Se ha modificado "+ant+" ahora es, "+post);
            } else if (requestCode == SHOW_ADDACTIVITY) {
                String nuevaPersona = bundle.getString("nuevaPersona");
                da.addNuevaPersona(nuevaPersona);
                showToast("Se ha introducido "+nuevaPersona);
            }
            cargarPersonas();

        } else if(resultCode == BORRAR && requestCode == SHOW_MODIFYACTIVITY) {

            Bundle bundle = data.getExtras();
            String borrarPersona = bundle.getString("borrarPersona");
            da.borrarPersona(borrarPersona);
            showToast("Se ha borrado "+borrarPersona);
            cargarPersonas();

        }

    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK)) {
            refresh();
            Intent intent = new Intent(da,MainActivity.class);
            startActivity(intent);
            finish();
        }
        return super.onKeyDown(keyCode, event);
    }

    public void showToast(String string) {
        Toast.makeText(this,string,Toast.LENGTH_SHORT).show();
    }

    public void cargarPersonas() {
        todoItemsAdapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, da.getPersonas());
        listPersonas.setAdapter(todoItemsAdapter);
        listPersonas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String paisOrigen = (String) listPersonas.getItemAtPosition(position);
                Bundle bundle = new Bundle();
                bundle.putString("borrarPersona",paisOrigen);
                Intent intent = new Intent(da,ModifyRemovePaisOrigenActivity.class);
                intent.putExtras(bundle);
                startActivityForResult(intent,SHOW_MODIFYACTIVITY);
            }
        });

    }

    public void refresh () {
        da.refresBack();
    }


}