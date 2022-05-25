package com.example.proyecto;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final int SIGN_IN = 1;
    private ListView paisOrigenListView;
    DBApplication da;
    private ArrayAdapter<String> todoItemsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Bienvenido");
        toolbar.setSubtitle("Elige tu país de Origen");
        setSupportActionBar(toolbar);

        paisOrigenListView = (ListView) findViewById(R.id.listaPaisesOrigen);
        getApplicationContext();
        da = (DBApplication) getApplication();
        showPaisesOrigen();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //Entrada en modo administrador
        if (id == R.id.action_admin) {
            Intent intent = new Intent(this,LoginActivity.class);
            startActivityForResult(intent,SIGN_IN);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == Activity.RESULT_OK) {
            if (requestCode == SIGN_IN) {
                Toast.makeText(this, "Entrando en la Administración de datos", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(da, AdminActivity.class);
                startActivity(intent);
                finish();
            }
        } else {
            Toast.makeText(this, "SIGN IN FAILED: La contraseña o el nombre de usuario no coinciden", Toast.LENGTH_SHORT).show();
        }
    }

    public void showPaisesOrigen () {
        //Borrar el primer paso, dado que se va a pasar por el Bundle del 1. activity
        todoItemsAdapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, da.getPaisesOrigen());
        paisOrigenListView.setAdapter(todoItemsAdapter);
        paisOrigenListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String paisOrigen = (String) paisOrigenListView.getItemAtPosition(position);
                Bundle bundle = new Bundle();
                bundle.putString("paisOrigen", paisOrigen);
                Intent intent = new Intent(da, PaisDestinoActivity.class);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }
}