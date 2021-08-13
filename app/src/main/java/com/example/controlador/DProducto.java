package com.example.controlador;

import android.content.Context;
import android.widget.GridView;
import android.widget.Toast;

import com.example.modelo.Producto;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import java.util.ArrayList;
import java.util.List;

import cz.msebera.android.httpclient.Header;

public class DProducto implements IDao<Producto> {
    private String url=Conexion.geturl("SProducto.php");
    private AsyncHttpClient asyn=new AsyncHttpClient();
    private static List<Producto> array=new ArrayList<>();
    private GridView GridList;
    private Context ct;

    public DProducto(Context c){
        this.ct = c;
    }

    @Override
    public void getList(Object bus) throws Exception {
        RequestParams params=new RequestParams();
        params.add("frm","list");
        params.add("txtbus",bus.toString());
        asyn.get(url, params, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                String resp=new String(responseBody);
                getToast(resp);
            }
            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                getToast("Error Failure:"+error);
            }
        });
    }
    private void getToast(String men){
        Toast.makeText(ct,men,Toast.LENGTH_LONG).show();
    }

    @Override
    public void getAdd(Producto obj) throws Exception {

    }

    @Override
    public void getUp(Producto obj) throws Exception {

    }

    @Override
    public void getDel(Object cod) throws Exception {

    }

    @Override
    public Producto getItem(int f) {
        return null;
    }

    @Override
    public int getsize() {
        return 0;
    }
}
