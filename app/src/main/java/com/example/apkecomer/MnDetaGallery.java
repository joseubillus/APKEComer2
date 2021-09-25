package com.example.apkecomer;

import android.os.Bundle;

import com.bumptech.glide.Glide;
import com.example.controlador.Conexion;
import com.example.controlador.DProducto;
import com.example.util.Mensaje;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.apkecomer.databinding.ActivityMnDetaGalleryBinding;

public class MnDetaGallery extends AppCompatActivity {
    private TextView Lblnom,Lblpre, Lbldesc;
    private ImageView foto;
    private RatingBar rting;
    private DProducto dpro;

    private ActivityMnDetaGalleryBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMnDetaGalleryBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Toolbar toolbar = binding.toolbar;
        setSupportActionBar(toolbar);
        CollapsingToolbarLayout toolBarLayout = binding.toolbarLayout;
        toolBarLayout.setTitle(getTitle());

        FloatingActionButton fab = binding.fab;
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        try {

            Lblnom = (TextView) findViewById(R.id.FrmContDeGa_Lblnom);
            Lblpre = (TextView) findViewById(R.id.FrmContDeGa_Lblpre);
            rting = (RatingBar) findViewById(R.id.FrmContDeGa_Rting);
            foto = (ImageView) findViewById(R.id.FrmContDeGa_FotoImg);
            Lbldesc = (TextView) findViewById(R.id.FrmContDeGa_Lblcarac);

            if(getIntent().getStringExtra("cod")!=null) {
                Bundle dato = getIntent().getExtras();
                Lblnom.setText("" + dato.getString("nom"));
                Lblpre.setText("S/." + dato.getString("pre"));
                rting.setRating(new Float(dato.getString("ran")));
                Glide.with(this)
                        .load(Conexion.getImg(dato.getString("img")))
                        .error(R.drawable.error404)
                        .into(foto);
                Lbldesc.setText(dato.getString("desc"));

            }
        } catch(Exception e)
        {new Mensaje(this).FMensajeDialog("Error","Error Excep:"+e.getMessage(),0).show();}
    }
}