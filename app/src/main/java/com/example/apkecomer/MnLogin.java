package com.example.apkecomer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.controlador.DLogin;

public class MnLogin extends AppCompatActivity {
    private EditText txtusu, txtpas;
    private DLogin dlog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mn_login);

        dlog = new DLogin(this);
        txtusu = (EditText) findViewById(R.id.FrmLog_txtusu);
        txtpas = (EditText) findViewById(R.id.FrmLog_txtpas);

    }

    public void OnClick_BtnAcep(View v){
        String usu=txtusu.getText().toString();
        String pas=txtpas.getText().toString();

        try {
            dlog.getValidar(usu, pas, "valc");
        }catch(Exception ex)
        {getToast(ex.getMessage());}
    }

    public void getToast(String men){
        Toast.makeText(this,"Error Exp:"+men,Toast.LENGTH_LONG).show();
    }
}