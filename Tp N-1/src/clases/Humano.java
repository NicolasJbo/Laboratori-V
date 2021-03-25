package clases;

import Interfaces.IBeber;
import Interfaces.IOrinar;

public abstract class Humano  {
    private String nombre;
    private  Integer edad;
    private  Integer peso;
    IBeber beber;
    IOrinar orinar;

    public Humano(String nombre, Integer edad, Integer peso, IBeber beber, IOrinar orinar) {
        this.nombre = nombre;
        this.edad = edad;
        this.peso = peso;
        this.beber = beber;
        this.orinar = orinar;
    }

    public Humano( ) {

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public Integer getPeso() {
        return peso;
    }

    public void setPeso(Integer peso) {
        this.peso = peso;
    }
    public void beber(){
        beber.beber();

    }
    public void orinar(){
         orinar.orinar();
    }


}
