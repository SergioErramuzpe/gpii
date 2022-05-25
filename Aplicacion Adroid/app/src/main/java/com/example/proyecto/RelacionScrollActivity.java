package com.example.proyecto;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import com.example.proyecto.Model.Relacion;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

public class RelacionScrollActivity extends AppCompatActivity {

    private DBApplication da;
    private Relacion relacion;
    TextView tvDescripcion,tvCapital,
            tvCenso,tvHuso,tvIdiomas,tvFrontera,tvMoneda,
            tvPresidente,tvPrimerMinistro,tvGobierno,tvOrgano,
            tvDireccion, tvTelefono, tvHorario, tvMail, tvWeb;
    CheckBox chVisado,chPasaporte,chDNI;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_relacion_scroll);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        getApplicationContext();
        da = (DBApplication) getApplication();

        tvDireccion = (TextView) findViewById(R.id.tvDireccion1);
        tvTelefono = (TextView) findViewById(R.id.tvTelefono);
        tvMail = (TextView) findViewById(R.id.tvMail);
        tvWeb = (TextView) findViewById(R.id.tvWeb1);
        tvHorario = (TextView) findViewById(R.id.tvHorario1);
        tvDescripcion = (TextView) findViewById(R.id.tvDescripcion);
        tvCapital = (TextView) findViewById(R.id.tvCapital1);
        tvCenso = (TextView) findViewById(R.id.tvCenso1);
        tvHuso = (TextView) findViewById(R.id.tvHuso1);
        tvMoneda = (TextView) findViewById(R.id.tvMoneda1);
        tvIdiomas = (TextView) findViewById(R.id.tvIdiomas1);
        tvFrontera = (TextView) findViewById(R.id.tvFrontera1);
        tvPresidente = (TextView) findViewById(R.id.tvPresidente1);
        tvPrimerMinistro = (TextView) findViewById(R.id.tvPrimerMinistro1);
        tvGobierno = (TextView) findViewById(R.id.tvGobierno1);
        tvOrgano = (TextView) findViewById(R.id.tvOrgano1);


        chVisado = (CheckBox) findViewById(R.id.chVisado);
        chPasaporte = (CheckBox) findViewById(R.id.chPasaporte);
        chDNI = (CheckBox) findViewById(R.id.chDNI);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        relacion = (Relacion) bundle.getSerializable("relacion");
        tvDescripcion.setText(relacion.getDescripcion());

        initializeInfo();

        toolbar.setBackgroundColor(Color.parseColor(relacion.getColor()));
        setSupportActionBar(toolbar);

        CollapsingToolbarLayout toolBarLayout = (CollapsingToolbarLayout) findViewById(R.id.toolbar_layout);
        toolBarLayout.setBackgroundColor(Color.parseColor(relacion.getColor()));
        toolBarLayout.setTitle(relacion.getPaisDestino().getNombre());

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putSerializable("pais",relacion.getPaisDestino());
                Intent intent = new Intent(da,MapPaisActivity.class);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }


    public void initializeInfo () {
        tvDireccion.setText(relacion.getDirec());
        tvTelefono.setText(relacion.getTel());
        tvMail.setText(relacion.getMail());
        tvWeb.setText(relacion.getWeb());
        tvHorario.setText(relacion.getHorario());
        tvDescripcion.setText(relacion.getDescripcion());
        tvCapital.setText(relacion.getPaisDestino().getCapital());
        tvCenso.setText(relacion.getPaisDestino().getCenso());
        tvHuso.setText(relacion.getPaisDestino().getHuso());
        tvMoneda.setText(relacion.getPaisDestino().getMoneda());
        tvIdiomas.setText(relacion.getPaisDestino().getIdiomas());
        tvFrontera.setText(relacion.getPaisDestino().getFronteras());
        tvPresidente.setText(relacion.getPaisDestino().getPresidente());
        tvPrimerMinistro.setText(relacion.getPaisDestino().getPrimerMinistro());
        tvGobierno.setText(relacion.getPaisDestino().getGobierno());
        tvOrgano.setText(relacion.getPaisDestino().getOrgano());
        chVisado.setChecked(relacion.getVisado());
        chPasaporte.setChecked(relacion.getPasaporte());
        chDNI.setChecked(relacion.getDni());

    }
}