package com.example.apkecomer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.util.PreCarga;

public class MainActivity extends AppCompatActivity {
    private TextView Lblpor;
    private ImageView Imgpre;
    private PreCarga pre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Lblpor = (TextView) findViewById(R.id.FrmPre_Lblpor);
        Imgpre = (ImageView) findViewById(R.id.FrmPre_ImgPre);

        pre = new PreCarga(this,Lblpor);
        pre.execute();

    }
}