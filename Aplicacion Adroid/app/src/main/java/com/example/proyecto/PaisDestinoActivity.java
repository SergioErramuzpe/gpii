package com.example.proyecto;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.proyecto.Model.Relacion;

public class PaisDestinoActivity extends AppCompatActivity {

    private ListView paisDestinoListView;
    private ArrayAdapter<String> todoItemsAdapter;

    private DBApplication da;
    private String paisOrigen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pais_destino);
        Toolbar toolbar = findViewById(R.id.toolbar);


        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        paisOrigen =  bundle.getString("paisOrigen");

        toolbar.setTitle(paisOrigen.toUpperCase());
        toolbar.setSubtitle("Elige un país Destino");
        setSupportActionBar(toolbar);

        paisDestinoListView = (ListView) findViewById(R.id.paisDestinoListView);
        getApplicationContext();
        da = (DBApplication) getApplicationContext();
        showPaisesDestino();
    }

    public void showPaisesDestino () {
        todoItemsAdapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, da.getPaisesDestino(paisOrigen)){
            @Override
            public View getView(int position,  View convertView,  ViewGroup parent) {
                TextView view = (TextView) super.getView(position, convertView, parent);
                Relacion r = da.getRelacion(paisOrigen,getItem(position));
                view.setBackgroundColor(Color.parseColor(r.getColor()));
                view.setTextColor(Color.WHITE);
                return view;
            }
        };


        paisDestinoListView.setAdapter(todoItemsAdapter);

        paisDestinoListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String paisDestino = (String) paisDestinoListView.getItemAtPosition(position);
                Bundle bundle = new Bundle();
                bundle.putSerializable("relacion", da.getRelacion(paisOrigen,paisDestino));
                Intent intent = new Intent(da, RelacionScrollActivity.class);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }
}