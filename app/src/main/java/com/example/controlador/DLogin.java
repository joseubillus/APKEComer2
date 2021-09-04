package com.example.controlador;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.example.apkecomer.MnMenu;
import com.example.modelo.Login;
import com.example.util.Mensaje;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import cz.msebera.android.httpclient.Header;

public class DLogin implements IDao<Login> {
    private String url=Conexion.geturl("SLogin.php");
    private static List<Login> array=new ArrayList<>();
    private AsyncHttpClient asyn=new AsyncHttpClient();
    private Context ct;
    private Mensaje ms;

    public DLogin(Context c){
        this.ct = c;
        this.ms = new Mensaje(c);
    }

    public void getValidar(String cor, String pas, String tipo)throws Exception{
        RequestParams params=new RequestParams();
        params.add("frm",tipo);
        params.add("txtcor",cor);
        params.add("txtpas",pas);
        asyn.get(url, params, new AsyncHttpResponseHandler() {
            @Override
            public void onStart() {
                super.onStart();
                ms.MProgressBarDato();
            }
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                String resp=new String(responseBody);
                try {
                    JSONObject json=new JSONObject(resp);
                    String r=json.get("Success").toString();
                    if(r.equals("Carrito.php"))
                        ct.startActivity(new Intent(ct, MnMenu.class));
                } catch (JSONException e)
                {new Mensaje(ct).FMensajeDialog("Error", "Error Validación:"+resp+" "+e.getMessage(),0).show();}
                ms.MCloseProgBar(true);
            }
            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                ms.MCloseProgBar(true);
                String resp=error.getMessage();
                new Mensaje(ct).FMensajeDialog("Error","Error Failt:"+resp,0).show();
            }
        });
    }

    public void getToast(String men){
        Toast.makeText(ct,men,Toast.LENGTH_LONG).show();
    }

    @Override
    public void getList(Object bus) throws Exception {

    }

    @Override
    public void getAdd(Login obj) throws Exception {

    }

    @Override
    public void getUp(Login obj) throws Exception {

    }

    @Override
    public void getDel(Object cod) throws Exception {

    }

    @Override
    public Login getItem(int f) {
        return null;
    }

    @Override
    public int getsize() {
        return 0;
    }
}
