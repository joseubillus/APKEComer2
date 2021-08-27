package com.example.controlador;

import android.content.pm.ApplicationInfo;

public class Conexion {
    private static String ip="http://192.168.56.1:8070/";
    private static String serv="PHPEComer/Servicio/";

    public static String geturl(String Api) {
        return ip + serv + Api;
    }

    public static String getImg(String foto){
        return ip + serv + "IMG/IMGProducto/"+foto;
    }
}
