package clases;

import Interfaces.IBeber;
import Interfaces.IHabilidadEspecial;
import Interfaces.IOrinar;

import java.util.Random;

public class Espartano extends Humano implements IHabilidadEspecial {
    private Integer bebedorProfesional;
    private Integer limiteE;

    public Espartano(String nombre, Integer edad, Integer peso, IBeber beber, IOrinar orinar, Integer bebedorProfesional) {
        super(nombre, edad, peso, beber, orinar);
        this.bebedorProfesional = bebedorProfesional;
        this.limiteE = new Random().nextInt(15 - 1)+1; //genero el limite de bebida del Espartano

    }

    public void activarHabilidadEspecial() {

        int limiteViejo = this.limiteE;
        if(this.bebedorProfesional >= 5){
            this.limiteE = this.limiteE + this.bebedorProfesional;
        }else if(this.bebedorProfesional <= 0) {
            this.limiteE = this.limiteE + 1;
        }else {
            this.limiteE = this.limiteE * this.bebedorProfesional;

        }
        System.out.println("Bebedor profesional limite \033[34m"+this.getNombre() +"\u001B[0m aumenta "+limiteViejo + " --> \033[31m " + this.limiteE +"\u001B[0m");
    }

    public Integer getBebedorProfesional() {
        return bebedorProfesional;
    }
    public int getLimiteE(){return  this.limiteE;}

}
