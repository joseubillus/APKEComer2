package com.example.controlador;

public class Conexion {
    private static String ip="http://192.168.0.11:8070/";
    private static String serv="PHPEComer/Servicio/";

    public static String geturl(String Api) {
        return ip + serv + Api;
    }
}
