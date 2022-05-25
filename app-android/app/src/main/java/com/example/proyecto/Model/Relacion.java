package com.example.proyecto.Model;

import java.io.Serializable;
import java.util.HashMap;

public class Relacion implements Serializable {
    protected Pais pais;
    protected Persona persona;
    private boolean dni, visado, pasaporte;
    private String descripcion;
    private String color;
    HashMap<String, String> embajada;


    public Relacion () {
        embajada = new HashMap<>();
    }

    public Relacion ( boolean dni, boolean visado, boolean pasaporte) {
        this.dni = dni;
        this.pasaporte = pasaporte;
        this.visado = visado;
        this.embajada = new HashMap<>();
        embajada = new HashMap<>();
    }


    public Relacion ( boolean dni, boolean visado, boolean pasaporte, Pais pais, Persona persona) {
        this.pais = pais;
        this.persona = persona;
        this.dni = dni;
        this.pasaporte = pasaporte;
        this.visado = visado;
        this.embajada = new HashMap<>();
        embajada = new HashMap<>();
    }

    public Persona getPaisOrigen () {
        return this.persona;
    }

    public Pais getPaisDestino () {
        return this.pais;
    }

    public void setPaisOrigen (Persona persona) {
        this.persona = persona;
    }

    public void setPaisDestino (Pais pais) {
        this.pais = pais;
    }



    public boolean getDni() {
        return dni;
    }

    public boolean getVisado() {
        return visado;
    }

    public boolean getPasaporte() {
        return pasaporte;
    }

    public String getTel() {
        return embajada.get("telefono");
    }

    public void setTel(String tel) {
        embajada.put("telefono", tel);
    }

    public String getDirec() {
        return embajada.get("direccion");
    }

    public void setDirec(String direc) {
        embajada.put("direccion", direc);
    }

    public String getMail() {
        return embajada.get("email");
    }

    public void setMail(String mail) {
        embajada.put("email", mail);
    }

    public String getHorario() {
        return embajada.get("hor");
    }

    public void setHorario(String horario) {
        embajada.put("hor", horario);
    }

    public String getWeb() {
        return embajada.get("web");
    }

    public void setWeb(String web) {
        embajada.put("web", web);
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public void setColor(String color) {
        this.color = color;
    }

    public String getColor () {
        return this.color;
    }
}
