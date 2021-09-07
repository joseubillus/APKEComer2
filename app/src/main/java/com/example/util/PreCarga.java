package com.example.util;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.widget.TextView;

import com.example.apkecomer.MnLogin;

public class PreCarga extends AsyncTask<Void, Integer, Void> {
    private Activity at;
    private TextView lblpor;

    public PreCarga(Activity at, TextView lblpor) {
        this.at = at;
        this.lblpor = lblpor;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected Void doInBackground(Void... voids) {
        publishProgress(0);
        for (int i = 0; i <= 100; i++) {
            try {
                Thread.sleep(50);
                publishProgress(i);
            }catch (InterruptedException e)
            {e.printStackTrace();}
        }
        return null;
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
        lblpor.setText(values[0]+"%");
    }

    @Override
    protected void onPostExecute(Void unused) {
        super.onPostExecute(unused);
        at.startActivity(new Intent(at, MnLogin.class));
    }
}
