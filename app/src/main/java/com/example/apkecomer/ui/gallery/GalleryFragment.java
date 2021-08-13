package com.example.apkecomer.ui.gallery;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.apkecomer.R;
import com.example.apkecomer.databinding.FragmentGalleryBinding;
import com.example.controlador.DProducto;

public class GalleryFragment extends Fragment {

    private FragmentGalleryBinding binding;
    private GridView GridProd;
    private DProducto dpro;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentGalleryBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        GridProd = (GridView)root.findViewById(R.id.FrmProd_GridProd);
        try {
            dpro=new DProducto(root.getContext());
            dpro.getList("");
        } catch (Exception e)
        {getToast(root.getContext(),"Error Exp"+e.getMessage());}
        return root;
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