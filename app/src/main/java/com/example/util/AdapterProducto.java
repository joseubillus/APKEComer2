package com.example.util;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.apkecomer.R;
import com.example.controlador.Conexion;
import com.example.modelo.Producto;

import java.util.ArrayList;
import java.util.List;

public class AdapterProducto extends BaseAdapter {
    private List<Producto> array=new ArrayList<>();
    private Context ct;

    public AdapterProducto(Context ct) {
        this.ct = ct;
    }

    public AdapterProducto(Context ct, List<Producto> array) {
        this.array = array;
        this.ct = ct;
    }

    @Override
    public int getCount() {
        return array.size();
    }

    @Override
    public Producto getItem(int position) {
        return array.get(position);
    }

    @Override
    public long getItemId(int position) {
        return array.get(position).hashCode();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View root = convertView;
        if(root==null){
            LayoutInflater inflater=(LayoutInflater)
                    ct.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            root = inflater.inflate(R.layout.conf_fram_gallery,parent,false);
        }
        ImageView img=(ImageView)root.findViewById(R.id.FrmCFProd_Img);
        TextView lblnom=(TextView)root.findViewById(R.id.FrmCFProd_Lblnom);
        TextView lblpre=(TextView)root.findViewById(R.id.FrmCFProd_Lblpre);
        RatingBar rank=(RatingBar) root.findViewById(R.id.FrmCFProd_Rank);

        Producto prod=getItem(position);
        lblnom.setText(""+prod.getNom());
        lblpre.setText("S/."+prod.getPre());

        Glide.with(ct)
                .load(Conexion.getImg(prod.getImg()))
                .error(R.drawable.error404)
                .into(img);
        return root;
    }
}
