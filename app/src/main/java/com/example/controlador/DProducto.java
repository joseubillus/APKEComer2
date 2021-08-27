package com.example.controlador;

import android.content.Context;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.Toast;

import com.example.modelo.Producto;
import com.example.util.AdapterProducto;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

import cz.msebera.android.httpclient.Header;

public class DProducto implements IDao<Producto> {
    private String url=Conexion.geturl("SProducto.php");
    private AsyncHttpClient asyn=new AsyncHttpClient();
    private static List<Producto> array=new ArrayList<>();
    private AdapterProducto adp;
    public GridView GridList;
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
                try {
                    array.clear();
                    getJSON(resp);
                    adp=new AdapterProducto(ct,array);
                    GridList.setAdapter(adp);
                } catch (JSONException e)
                {getToast("Error JSON:"+e.getMessage()); }
            }
            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                getToast("Error Failure:"+error);
            }
        });
    }

    public void getJSON(String valor)throws JSONException {
        JSONArray json=new JSONArray(valor);
        for (int i = 0; i < json.length(); i++) {
            Producto pro=new Producto();
            pro.setCod(new Integer(json.getJSONObject(i).getString("cod")));
            pro.setNom(json.getJSONObject(i).getString("nom"));
            pro.setPre(new Double(json.getJSONObject(i).getString("pre")));
            pro.setStock(new Integer(json.getJSONObject(i).getString("stock")));
            pro.setMar(json.getJSONObject(i).getString("mar"));
            pro.setCat(json.getJSONObject(i).getString("cat"));
            pro.setRank(new Integer(json.getJSONObject(i).getString("rank")));
            pro.setCarac(json.getJSONObject(i).getString("carac"));
            pro.setImg(json.getJSONObject(i).getString("img"));
            array.add(pro);
        }
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
