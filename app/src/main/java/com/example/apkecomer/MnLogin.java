package com.example.apkecomer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MnLogin extends AppCompatActivity {
    private EditText txtusu, txtpas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mn_login);

        txtusu = (EditText) findViewById(R.id.FrmLog_txtusu);
        txtpas = (EditText) findViewById(R.id.FrmLog_txtpas);
    }

    public void OnClick_BtnAcep(View v){
        String usu=txtusu.getText().toString();
        String pas=txtpas.getText().toString();

        if(usu.equals("jose") && pas.equals("123"))
            startActivity(new Intent(MnLogin.this, MnMenu.class));
        else
            Toast.makeText(this,
                    "Error usuario o password",
                    Toast.LENGTH_LONG)
                    .show();
    }
}