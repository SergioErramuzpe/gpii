package com.example.proyecto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    private String pass = "admin";
    private String name = "admin";
    private EditText etUsername, etPass;
    private Button signIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Intent intent = getIntent();
        etUsername = (EditText) findViewById(R.id.etUsername);
        etPass = (EditText) findViewById(R.id.etPass);
        signIn = (Button) findViewById(R.id.signIn);

        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sign(v);
            }
        });


    }

    public void sign (View view) {
        Intent intent = new Intent();
        if (etUsername.getText().toString().equals("admin") && etPass.getText().toString().equals("admin")) {
            setResult(RESULT_OK,intent);
        } else {
            setResult(RESULT_CANCELED,intent);
        }
        finish();
    }
}