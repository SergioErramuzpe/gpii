package com.example.proyecto.Model;

import com.google.android.gms.maps.model.LatLng;

import java.io.Serializable;
import java.util.HashMap;

public class Pais implements Serializable {
    private Double longitud, latitud;
    private String nombre;
    private String organizacion;
    private HashMap<String,String> info ;

    public Pais() {
        info = new HashMap<>();
    }

    public Pais(String nombre) {
        info = new HashMap<>();
        this.nombre = nombre;
        this.info = new HashMap<>();
    }

    public String getOrganizacion() {
        return organizacion;
    }

    public void setOrganizacion(String organizacion) {
        this.organizacion = organizacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre (String nombre) {
        this.nombre = nombre;
    }


    //Info general
    public String getCapital() {
        return info.get("capital");
    }

    public void setCapital(String capital) {
        assert capital != null;
        info.put("capital",capital);
    }

    public String getCenso() {
        return info.get("censo");
    }

    public void setCenso(String censo) {
        assert censo != null;
        info.put("censo",censo);
    }

    public String getHuso() {
        return info.get("huso");
    }

    public void setHuso(String huso) {
        assert huso != null;
        info.put("huso",huso);
    }

    public String getIdiomas() {
        return info.get("idiomas");
    }

    public void setIdiomas(String idiomas) {
        assert idiomas != null;
        info.put("idiomas",idiomas);
    }

    public String getFronteras() {
        return info.get("fronteras");
    }

    public void setFronteras(String fronteras) {
        assert fronteras != null;
        info.put("fronteras",fronteras);
    }

    public String getMoneda() {
        return info.get("moneda");
    }

    public void setMoneda(String moneda) {
        assert moneda != null;
        info.put("moneda",moneda);
    }


    // Info Politica
    public String getPresidente() {
        return info.get("presidente");
    }

    public void setPresidente(String presidente) {
        assert presidente != null;
        info.put("presidente",presidente);
    }

    public String getPrimerMinistro() {
        return info.get("primerMinistro");
    }

    public void setPrimerMinistro(String primerMinistro) {
        assert primerMinistro != null;
        info.put("primerMinistro",primerMinistro);
    }

    public String getGobierno() {
        return info.get("gobierno");
    }

    public void setGobierno(String gobierno) {
        assert gobierno != null;
        info.put("gobierno",gobierno);
    }

    public String getOrgano() {
        return info.get("organo");
    }

    public void setOrgano(String organo) {
        assert organo != null;
        info.put("organo",organo);
    }



    //Info Economica
    public String getPibTotal() {
        return info.get("pibTotal");
    }

    public void setPibTotal(String pibTotal) {
        info.put("pibTotal",pibTotal);
    }

    public String getPibCapita() {
        return info.get("pibCapita");
    }

    public void setPibCapita(String pibCapita) {
        info.put("pibCapita",pibCapita);
    }

    public String getPuesto() {
        return info.get("puesto");
    }

    public void setPuesto(String puesto) {
        info.put("puesto",puesto);
    }

    public String getSector() {
        return info.get("sector");
    }

    public void setSector(String sector) {
        info.put("sector",sector);
    }


    //Info laboral

    public String getpActiva() {
        return info.get("pActiva");
    }

    public void setpActiva(String pActiva) {
        info.put("pActiva",pActiva);
    }

    public String getParo() {
        return info.get("paro");
    }

    public void setParo(String paro) {
        info.put("paro",paro);
    }


    //Info infraestructural
    public String getEducacion() {
        return info.get("educacion");
    }

    public void setEducacion(String educacion) {
        info.put("educacion",educacion);
    }

    public String getSanidad() {
        return info.get("sanidad");
    }

    public void setSanidad(String sanidad) {
        info.put("sanidad",sanidad);
    }

    //Coordenadas en mapa
    public Double getLongitud() {
        return this.longitud;
    }

    public void setLongitud(Double longitud) {
        this.longitud = longitud;
    }

    public Double getLatitud() {
        return this.latitud;
    }

    public void setLatitud(Double latitud) {
        this.latitud = latitud;
    }

}