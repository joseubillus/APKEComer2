package com.example.modelo;

public class Producto {
    private int cod;
    private String nom;
    private double pre;
    private int stock;
    private String mar;
    private String cat;
    private int rank;
    private String carac;
    private String img;

    public Producto() {}

    public Producto(int cod, String nom, double pre, int stock, String mar, String cat, int rank, String carac, String img) {
        this.cod = cod;
        this.nom = nom;
        this.pre = pre;
        this.stock = stock;
        this.mar = mar;
        this.cat = cat;
        this.rank = rank;
        this.carac = carac;
        this.img = img;
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public double getPre() {
        return pre;
    }

    public void setPre(double pre) {
        this.pre = pre;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getMar() {
        return mar;
    }

    public void setMar(String mar) {
        this.mar = mar;
    }

    public String getCat() {
        return cat;
    }

    public void setCat(String cat) {
        this.cat = cat;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public String getCarac() {
        return carac;
    }

    public void setCarac(String carac) {
        this.carac = carac;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
