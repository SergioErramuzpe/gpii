package com.example.proyecto.Model;

import java.io.Serializable;

public class Persona implements Serializable {

    private String nombre;

    public Persona (String nombre) {
        this.nombre = nombre;
    }

    public String getPais () {
        return this.nombre;
    }
}
