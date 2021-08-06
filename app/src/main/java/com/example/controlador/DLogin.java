package com.example.controlador;

import android.content.Context;
import android.widget.Toast;

import com.example.modelo.Login;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import java.util.ArrayList;
import java.util.List;

import cz.msebera.android.httpclient.Header;

public class DLogin implements IDao<Login> {
    private String url="http://192.168.0.11:8070/PHPEComer/Servicio/SLogin.php";
    private static List<Login> array=new ArrayList<>();
    private AsyncHttpClient asyn=new AsyncHttpClient();
    private Context ct;

    public DLogin(Context c){
        this.ct = c;
    }

    public void getValidar(String cor, String pas, String tipo)throws Exception{
        RequestParams params=new RequestParams();
        params.add("frm",tipo);
        params.add("txtcor",cor);
        params.add("txtpas",pas);
        asyn.get(url, params, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                String resp=new String(responseBody);
                getToast(resp);
            }
            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                String resp=error.getMessage();
                getToast("Error Failt:"+resp);
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
