package com.example.apkecomer.ui.gallery;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.apkecomer.MnDetaGallery;
import com.example.apkecomer.R;
import com.example.apkecomer.databinding.FragmentGalleryBinding;
import com.example.controlador.DProducto;

public class GalleryFragment extends Fragment {

    private FragmentGalleryBinding binding;
    private GridView GridProd;
    private SearchView schbus;
    private DProducto dpro;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentGalleryBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        GridProd = (GridView)root.findViewById(R.id.FrmProd_GridProd);
        schbus = (SearchView)root.findViewById(R.id.FrmProd_SchBus);
        schbus.setOnQueryTextListener(getSearchBuscar(root));
        getList(root,"");

        GridProd.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent inte=new Intent(root.getContext(), MnDetaGallery.class);
                inte.putExtra("cod",""+dpro.getItem(position).getCod());
                inte.putExtra("nom",""+dpro.getItem(position).getNom());
                inte.putExtra("pre",""+dpro.getItem(position).getPre());
                inte.putExtra("ran",""+dpro.getItem(position).getRank());
                startActivity(inte);
            }
        });

        return root;
    }

    public SearchView.OnQueryTextListener getSearchBuscar(View root){
        return new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {return false;}
            @Override
            public boolean onQueryTextChange(String newText) {
                getList(root,newText);
                return false;
            }
        };
    }

    public void getList(View root, String bus){
        try {
            dpro=new DProducto(root.getContext());
            dpro.GridList = GridProd;
            dpro.getList(bus);
        } catch (Exception e)
        {getToast(root.getContext(),"Error Exp"+e.getMessage());}
    }

    public void getToast(Context ct,String men){
        Toast.makeText(ct,men,Toast.LENGTH_LONG).show();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}