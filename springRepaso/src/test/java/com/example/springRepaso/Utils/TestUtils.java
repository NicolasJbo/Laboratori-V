package com.example.springRepaso.Utils;

import com.example.springRepaso.model.Persona;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.time.LocalDate;
import java.util.ArrayList;

public class TestUtils {

    public static  String aPersonJSON(){
    final Gson gson = new  GsonBuilder().setPrettyPrinting().create();
    return gson.toJson(aPersona());
    }
    public  static  Persona aPersona(){
        Persona p = new Persona();
        p.setDireccion("dire");
        p.setId(1);
        p.setLastname("apellido");
        p.setName("nombre");
        p.setVehiculosList(new ArrayList<>());
        return  p;
    }

    //Objeto con fecha
    public static  String aPersonJSON2(){
    final Gson gson2  = new  GsonBuilder()
            .registerTypeAdapter(LocalDate.class ,new LocalDateSerializer())
            .registerTypeAdapter(LocalDate.class , new LocalDateDeserializaer())
            .setPrettyPrinting()
            .create();
    return gson2.toJson(aPersona());
    }


}
