package com.example.proyecto;

import org.junit.Test;

import static org.junit.Assert.*;

import com.example.proyecto.Model.Pais;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class UnitTestsPais {
    @Test
    public void name_is_correct () {
        String nombrePais = "pais";
        Pais pais = new Pais("pais");
        assertEquals(nombrePais, pais.getNombre());
    }


}