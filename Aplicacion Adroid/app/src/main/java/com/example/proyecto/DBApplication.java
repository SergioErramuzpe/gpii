package com.example.proyecto;

import android.app.Application;
import android.os.Build;
import android.widget.Toast;

import androidx.annotation.RequiresApi;

import com.example.proyecto.Model.Pais;
import com.example.proyecto.Model.Relacion;
import com.example.proyecto.Model.Persona;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


public class DBApplication extends Application {


    public HashMap <String,String> colores;
    public HashMap <String,HashMap<String,Relacion>> hashPersonas;
    public List <String> personas;
    public List <String> nombresPaises;
    public List <Pais> paises;


    @Override
    public void onCreate() {
        super.onCreate();

        hashPersonas = new HashMap<>();
        colores = new HashMap<>();
        personas = new ArrayList<>();
        paises = new ArrayList<>();
        nombresPaises = new ArrayList<>();
        initializeEjemplo();
    }

    public void initializeEjemplo () {
        /*Introduccion de colores*/
        colores.put("libre albedrio", "#1B5E20");
        colores.put("entrada sin visado", "#4CAF50");
        colores.put("entrada con dificultad", "#4A148C");
        colores.put("entrada con visado", "#9C27B0");


        /*Introduccion de datos de prueba*/

        /*- Introduccion de paises de origen*/
        hashPersonas.put("España", new HashMap<String, Relacion>());
        hashPersonas.put("Andorra", new HashMap<String, Relacion>());
        hashPersonas.put("Portugal", new HashMap<String, Relacion>());
        hashPersonas.put("Turquia", new HashMap<String, Relacion>());
        personas.add("España");
        personas.add("Andorra");
        personas.add("Portugal");
        personas.add("Turquia");

        /*Auxiliares*/
        HashMap<String, Relacion> auxHash = new HashMap<String, Relacion>();
        Pais aux;
        Relacion auxRelacion;
        Persona auxPersona = new Persona("España");

        /*Introducir Relacion España - Francia*/
        aux = new Pais("Francia");

        addNuevoNombrePais(aux);

        aux.setLatitud(48.856613);
        aux.setLongitud(2.352222);

        aux.setOrganizacion("UE");

        aux.setCapital("Paris");
        aux.setCenso("67.028.048 habitantes");
        aux.setHuso("UTC+1");
        aux.setIdiomas("Frances, Occitano, Breton, Euskera");
        aux.setFronteras("España,Suiza,Alemania,Italia,Luxemburgo,Andorra,Belgica");
        aux.setMoneda("Euro (€)");

        aux.setPresidente("Emmanuel Macron");
        aux.setPrimerMinistro("Edouard Philippe");

        aux.setGobierno("Republica semipresidencialista");
        aux.setOrgano("Parlamento frances");

        addNuevoPais(aux);

        auxRelacion = new Relacion(true, false, false, aux, auxPersona);

        auxRelacion.setColor(colores.get("libre albedrio"));
        auxRelacion.setDescripcion("El DNI es un documento  valido de entrada a Francia. Al ser un país miembro del espacio Schengen, se tiene derecho a residir y circular libremente siendo originario de España");
        auxRelacion.setDirec("C/ Salustiano Olózaga, 9, 28001 Madrid");
        auxRelacion.setHorario("De 9:00 a 19:00 de lunes a viernes");
        auxRelacion.setMail("embajadaFranciaEnEspaña@france.mail.com");
        auxRelacion.setTel("+34 91 423 89 00");
        auxRelacion.setWeb("https://es.ambafrance.org/-Espanol-");

        auxRelacion.setPaisOrigen(auxPersona);
        auxRelacion.setPaisDestino(aux);

        auxHash.put((String) aux.getNombre(), auxRelacion);

        /*Introducir Relacion España - Ucrania*/

        aux = new Pais("Ucrania");

        addNuevoNombrePais(aux);

        aux.setLatitud(50.450100);
        aux.setLongitud(30.523399);

        aux.setOrganizacion("Ninguna");

        aux.setCapital("Kiev");
        aux.setCenso("41.940.726 habitantes");
        aux.setHuso("EET (UTC +2)");
        aux.setIdiomas("ucraniano, ruso");
        aux.setFronteras("Rusia, Bielorrusia, Moldavia, Hungría,Polonia, Rumanía, Eslovaquia");
        aux.setMoneda("Grivna (1 ₴ = 0,037 €)");

        aux.setPresidente("Volodímir Zelenski");
        aux.setPrimerMinistro("Oleksiy Honcharuk");

        aux.setGobierno("República semipresidencial");
        aux.setOrgano("Rada Suprema");

        addNuevoPais(aux);

        auxRelacion = new Relacion(false, true, false, aux, auxPersona);

        auxRelacion.setColor(colores.get("entrada con visado"));
        auxRelacion.setDescripcion("No se precisa de visado para estancias inferiores a 90 días durante un periodo de 180 días, sin ejercer actividad lucrativa, la validez del pasaporte deberá ser como mínimo de esos mismos 90 días.");
        auxRelacion.setDirec("c/Ronda de la Abubilla, 52, 28043 Madrid");
        auxRelacion.setHorario("Lunes - Viernes  09:00 - 18:00");
        auxRelacion.setMail("emb_es@mfa.gov.ua");
        auxRelacion.setTel("+34 917 48 93 60");
        auxRelacion.setWeb("https://spain.mfa.gov.ua/es");

        auxRelacion.setPaisOrigen(auxPersona);
        auxRelacion.setPaisDestino(aux);

        auxHash.put((String) aux.getNombre(), auxRelacion);

        hashPersonas.put((String) auxPersona.getPais(), auxHash);

        aux = new Pais("Portugal");

        addNuevoNombrePais(aux);

        aux.setLatitud(38.7077507);
        aux.setLongitud(-9.1365919);

        aux.setOrganizacion("UE");

        aux.setCapital("Lisboa");
        aux.setCenso("10 562 178 habitantes");
        aux.setHuso("UTC");
        aux.setIdiomas("Portugues");
        aux.setFronteras("España");
        aux.setMoneda("Euro (€)");

        aux.setPresidente("Marcelo Rebelo de Sousa");
        aux.setPrimerMinistro("Antonio Costa");

        aux.setGobierno("República unitaria semipresidencialista");
        aux.setOrgano("Asamblea de la República");

        addNuevoPais(aux);

        auxRelacion = new Relacion(true, false, false, aux, auxPersona);

        auxRelacion.setColor(colores.get("libre albedrio"));
        auxRelacion.setDescripcion("El DNI es un documento  valido de entrada a Portugal. Al ser un país miembro del espacio Schengen, se tiene derecho a residir y circular libremente siendo originario de España");
        auxRelacion.setDirec("Calle Lagasca, nº 88 - 4º A, 28001 Madrid");
        auxRelacion.setHorario("Lunes - Viernes  09:30 - 18:00");
        auxRelacion.setMail("madrid@mne.pt");
        auxRelacion.setTel("(0034) 917 824 960");
        auxRelacion.setWeb("https://www.madrid.embaixadaportugal.mne.pt/es/");

        auxRelacion.setPaisOrigen(auxPersona);
        auxRelacion.setPaisDestino(aux);

        auxHash.put((String) aux.getNombre(), auxRelacion);

        hashPersonas.put((String) auxPersona.getPais(), auxHash);

        aux = new Pais("Serbia");

        addNuevoNombrePais(aux);

        aux.setLatitud(44.8153317);
        aux.setLongitud(20.4456631);

        aux.setOrganizacion("Ninguna");

        aux.setCapital("Belgrado");
        aux.setCenso("7 176 794 habitantes");
        aux.setHuso("UTC +1");
        aux.setIdiomas("Serbio");
        aux.setFronteras("Bosnia,Macedonia,Albania,Croacia,Bulgaria,Rumania");
        aux.setMoneda("Dinar (RSD) ");

        aux.setPresidente("Aleksandar Vucic");
        aux.setPrimerMinistro("Ana Brnabic");

        aux.setGobierno("República parlamentaria");
        aux.setOrgano("Asamblea Nacional de Serbia");

        addNuevoPais(aux);

        auxRelacion = new Relacion(true, false, false, aux, auxPersona);

        auxRelacion.setColor(colores.get("entrada sin visado"));
        auxRelacion.setDescripcion("El DNI es un documento  valido de entrada a Serbia. No es un pais miembro de la UE, pero se puede ciruclar libremente y residir durante un periodo maximo de 6 semanas.");
        auxRelacion.setDirec("c/Velazquez 3, Piso 2 ,28001 MADRID");
        auxRelacion.setHorario("Lunes - Viernes  09:30 - 17:00");
        auxRelacion.setMail("ambasada.madrid@mfa.rs");
        auxRelacion.setTel("+3491 / 563-50-45, 563-50-46");
        auxRelacion.setWeb("ambasada.madrid@mfa.rs");

        auxRelacion.setPaisOrigen(auxPersona);
        auxRelacion.setPaisDestino(aux);

        auxHash.put((String) aux.getNombre(), auxRelacion);

        hashPersonas.put((String) auxPersona.getPais(), auxHash);

        aux = new Pais("Corea del Norte");

        addNuevoNombrePais(aux);

        aux.setLatitud(39.0194741);
        aux.setLongitud(125.753388);

        aux.setOrganizacion("Ninguna");

        aux.setCapital("Pionyang");
        aux.setCenso("25 026 772 habitantes");
        aux.setHuso("UTC +9");
        aux.setIdiomas("Coreano");
        aux.setFronteras("China, Rusia, Corea del Sur");
        aux.setMoneda("Won coreano ");

        aux.setPresidente("Kim Jong-un (Lider Supremo)");
        aux.setPrimerMinistro("Kim Jong-un (Lider Supremo)");

        aux.setGobierno("República socialista juche");
        aux.setOrgano("Asamblea Suprema del Pueblo");

        addNuevoPais(aux);

        auxRelacion = new Relacion(false, true, false, aux, auxPersona);

        auxRelacion.setColor(colores.get("entrada con dificultad"));
        auxRelacion.setDescripcion("Es necesario un visado para acceder, que es de dificil obtencion, teniendo que pedirlo en la embajada");
        auxRelacion.setDirec("Calle González Amigó 15, 28033, Madrid");
        auxRelacion.setHorario("Lunes - Viernes  09:00 - 18:00");
        auxRelacion.setMail("hwgo16@mofa.go.kr");
        auxRelacion.setTel("(34) 91-353-2000");
        auxRelacion.setWeb("http://overseas.mofa.go.kr/es-es/index.do");

        auxRelacion.setPaisOrigen(auxPersona);
        auxRelacion.setPaisDestino(aux);

        auxHash.put((String) aux.getNombre(), auxRelacion);

        hashPersonas.put((String) auxPersona.getPais(), auxHash);

        aux = new Pais("Reino Unido");

        addNuevoNombrePais(aux);

        aux.setLatitud(51.5073219);
        aux.setLongitud(-0.1276474);

        aux.setOrganizacion("Ninguna");

        aux.setCapital("Londres");
        aux.setCenso("67 747 826 habitantes");
        aux.setHuso("UTC");
        aux.setIdiomas("Ingles, Gales, Escoces, Irlandes");
        aux.setFronteras("España, Irlanda");
        aux.setMoneda("Libra esterlina (£, GBP)");

        aux.setPresidente("Isabel II (Reina)");
        aux.setPrimerMinistro("Boris Johnson");

        aux.setGobierno("Monarquía constitucional parlamentaria unitaria");
        aux.setOrgano("Parlamento del Reino Unido");

        addNuevoPais(aux);

        auxRelacion = new Relacion(false, false, true, aux, auxPersona);

        auxRelacion.setColor(colores.get("entrada sin visado"));
        auxRelacion.setDescripcion("No es necesario un visado para viajar al Reino Unido. Se precisa de pasaporte y se debe rellenar un formulario");
        auxRelacion.setDirec("Torre Espacio ,Paseo de la Castellana 259D ,28046 Madrid");
        auxRelacion.setHorario("Lunes - Viernes  09:00 - 18:00");
        auxRelacion.setMail("embajada.Reino_Unido@mof.uk");
        auxRelacion.setTel("+34 91 714 6300");
        auxRelacion.setWeb("https://www.gov.uk/world/organisations/british-embassy-madrid.es");

        auxRelacion.setPaisOrigen(auxPersona);
        auxRelacion.setPaisDestino(aux);

        auxHash.put((String) aux.getNombre(), auxRelacion);

        hashPersonas.put((String) auxPersona.getPais(), auxHash);

        //Intro Paises Portugal

        auxPersona = new Persona("Portugal");
        auxHash = hashPersonas.get(auxPersona.getPais());

        auxRelacion = new Relacion(false, false, true, aux, auxPersona);
        auxRelacion.setColor(colores.get("entrada sin visado"));
        auxRelacion.setDescripcion("No es necesario un visado para viajar al Reino Unido. Se precisa de pasaporte y se debe rellenar un formulario");
        auxRelacion.setDirec("Rua de São Bernardo 33,1249-082 Lisboa");
        auxRelacion.setHorario("Lunes - Viernes  09:00 - 18:00");
        auxRelacion.setMail("ppa.lisbon@fco.gov.uk");
        auxRelacion.setTel("(+351) 213 924 000");
        auxRelacion.setWeb("www.gov.uk/government/world/portugal");

        auxRelacion.setPaisOrigen(new Persona("Portugal"));
        auxRelacion.setPaisDestino(aux);

        auxHash.put((String) aux.getNombre(), auxRelacion);

        hashPersonas.put((String) auxPersona.getPais(), auxHash);

        aux = getPaisDestino("Corea del Norte");

        auxRelacion = new Relacion(false, true, false, aux, auxPersona);

        auxRelacion.setColor(colores.get("entrada con dificultad"));
        auxRelacion.setDescripcion("Es necesario un visado para acceder, que es de dificil obtencion, teniendo que pedirlo en la embajada de Corea en Madrid");
        auxRelacion.setDirec("NULL");
        auxRelacion.setHorario("NULL");
        auxRelacion.setMail("NULL");
        auxRelacion.setTel("NULL");
        auxRelacion.setWeb("NULL");

        auxRelacion.setPaisOrigen(auxPersona);
        auxRelacion.setPaisDestino(aux);

        auxHash.put((String) aux.getNombre(), auxRelacion);

        hashPersonas.put((String) auxPersona.getPais(), auxHash);


        //Intro Paises Turquia


        auxPersona = new Persona("Turquia");
        aux = getPaisDestino("Reino Unido");
        auxHash = hashPersonas.get(auxPersona.getPais());

        auxRelacion = new Relacion(false, false, true, aux, auxPersona);
        auxRelacion.setColor(colores.get("entrada sin visado"));
        auxRelacion.setDescripcion("No es necesario un visado para viajar al Reino Unido. Se precisa de pasaporte y se debe rellenar un formulario");
        auxRelacion.setDirec("Mesrutiyet Caddesi No 34,Tepebasi, Beyoglu,PK 33 ,Istanbul 80050");
        auxRelacion.setHorario("Lunes - Viernes  09:00 - 18:00");
        auxRelacion.setMail("britembcon@fco.gov.uk");
        auxRelacion.setTel("(+90) (212) 334 6400");
        auxRelacion.setWeb("www.gov.uk/government/world/turkey");

        auxRelacion.setPaisOrigen(auxPersona);
        auxRelacion.setPaisDestino(aux);

        auxHash.put((String) aux.getNombre(), auxRelacion);

        hashPersonas.put((String) auxPersona.getPais(), auxHash);


        //Intro Paises Andorra

        auxPersona = new Persona("Andorra");
        auxHash = hashPersonas.get(auxPersona.getPais());

        auxRelacion = new Relacion(false, false, true, aux, auxPersona);
        auxRelacion.setColor(colores.get("entrada sin visado"));
        auxRelacion.setDescripcion("No es necesario un visado para viajar al Reino Unido. Se precisa de pasaporte y se debe rellenar un formulario");
        auxRelacion.setDirec("Prat de la Creu 22, Bloc D, Alt. 2, P O Box 1041, Andorra La Vella");
        auxRelacion.setHorario("Lunes - Viernes  09:00 - 18:00");
        auxRelacion.setMail("embajada.Reino_Unido@mof.uk");
        auxRelacion.setTel("+ 376 867731");
        auxRelacion.setWeb("https://www.gov.uk/world/organisations/british-embassy-madrid.es");

        auxRelacion.setPaisOrigen(auxPersona);
        auxRelacion.setPaisDestino(aux);

        auxHash.put((String) aux.getNombre(), auxRelacion);

        hashPersonas.put((String) auxPersona.getPais(), auxHash);

        aux = getPaisDestino("Corea del Norte");

        auxRelacion = new Relacion(false, true, false, aux, auxPersona);

        auxRelacion.setColor(colores.get("entrada con dificultad"));
        auxRelacion.setDescripcion("Es necesario un visado para acceder, que es de dificil obtencion, teniendo que pedirlo en la embajada de Corea en Madrid o en Paris");
        auxRelacion.setDirec("NULL");
        auxRelacion.setHorario("NULL");
        auxRelacion.setMail("NULL");
        auxRelacion.setTel("NULL");
        auxRelacion.setWeb("NULL");

        auxRelacion.setPaisOrigen(auxPersona);
        auxRelacion.setPaisDestino(aux);

        auxHash.put((String) aux.getNombre(), auxRelacion);

        hashPersonas.put((String) auxPersona.getPais(), auxHash);

    }

    public List <String> getPaisesDestino (String paisOrigen) {
        return (new ArrayList<>(this.hashPersonas.get(paisOrigen).keySet()));
    }

    public List <String> getPaisesOrigen () {
        return (new ArrayList<>(this.hashPersonas.keySet()));
    }

    public Relacion getRelacion (String paisOrigen, String paisDestino) {
        return this.hashPersonas.get(paisOrigen).get(paisDestino);
    }

    public ArrayList<String> getPersonas () {
        return (ArrayList<String>) this.personas;
    }

    public void addNuevaPersona (String nombre) {
        this.personas.add(nombre);
    }

    public void borrarPersona (String nombre) {
        this.personas.remove(nombre);
    }

    public void modifyPersona (String ant, String post) {
        HashMap<String,Relacion> aux = this.hashPersonas.get(ant);
        this.hashPersonas.remove(ant);
        this.hashPersonas.put(post,aux);
        this.personas.remove(ant);
        this.personas.add(post);
    }

    public void addNuevoNombrePais (Pais pais) {
        if (!this.nombresPaises.contains(pais.getNombre()))
            this.nombresPaises.add(pais.getNombre());
    }

    public void addNuevoPais (Pais pais) {
        if (nombresPaises.contains(pais.getNombre()))
            this.paises.add(pais);
    }

    public void modifyPais (Pais ant, Pais post) {
        this.nombresPaises.remove(ant.getNombre());
        this.nombresPaises.add(post.getNombre());
        this.paises.remove(ant);
        this.paises.add(post);
        HashMap<String, Relacion> auxHash;
        Relacion auxRel;
        Map.Entry<String, HashMap<String, Relacion>> entry;
        String key;
        Iterator<Map.Entry<String, HashMap<String, Relacion>>> entries = hashPersonas.entrySet().iterator();
        while (entries.hasNext()) {
            entry = entries.next();
            key = entry.getKey();
            if ((entry.getValue()).containsKey(ant.getNombre())) {
                auxRel = (entry.getValue()).get(ant.getNombre());
                assert auxRel != null;
                auxRel.setPaisDestino(post);
                hashPersonas.get(key).remove(ant.getNombre());
                hashPersonas.get(key).put(post.getNombre(), auxRel);
            }
        }

    }

    public void showToast(String string) {
        Toast.makeText(this,string,Toast.LENGTH_SHORT).show();
    }


    @RequiresApi(api = Build.VERSION_CODES.N)
    public void borrarPais (Pais pais) {
        HashMap<String,Relacion> aux;
        this.nombresPaises.remove(pais.getNombre());
        for (String e : this.personas) {
            aux= hashPersonas.get(e);
            assert aux != null;
            if (aux.containsKey(pais.getNombre()))
                aux.remove(pais.getNombre());
        }
    }

    public Pais getPaisDestino (String nombre) {
        for (Pais p : paises) {
            if (p.getNombre().equals(nombre))
                return p;
        }
        return null;
    }

    public boolean contienePaisDestino (String string) {
        if (this.nombresPaises.contains(string))
            return true;
        else
            return false;
    }

    public void borrarPais (String string) {
        nombresPaises.remove(string);
    }

    public ArrayList<String> getNombresPaises () {
        return (ArrayList<String>) this.nombresPaises;
    }

    public void refresBack () {
        Toast.makeText(getApplicationContext(),"La BBDD se ha actualizado con exito",Toast.LENGTH_LONG).show();
    }

    public List<String> getColors () {
        return new ArrayList<>(this.colores.keySet());
    }

    public void addRelacion (Relacion relacion) {
        String persona = relacion.getPaisOrigen().getPais();
        String pais = relacion.getPaisDestino().getNombre();
        HashMap<String,Relacion> aux = new HashMap<>();
        if (hashPersonas.containsKey(persona))
            aux = this.hashPersonas.get(persona);
        aux.put(pais,relacion);
        this.hashPersonas.put(persona,aux);
    }

}
