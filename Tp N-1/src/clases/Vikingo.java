package clases;

import Interfaces.IBeber;
import Interfaces.IHabilidadEspecial;
import Interfaces.IOrinar;

import java.util.Random;

public class Vikingo extends Humano implements IHabilidadEspecial {

    private Integer toleranciaExtra;
    private Integer limiteV;

    public Vikingo() {
    }

    public Vikingo(String nombre, Integer edad, Integer peso, IBeber beber, IOrinar orinar, Integer toleranciaExtra) {
        super(nombre, edad, peso, beber, orinar);
        this.toleranciaExtra = toleranciaExtra;
        this.limiteV = new Random().nextInt(15 - 1)+1; //genero el limite de bebida del Vikingo

    }

    @Override
    public String toString() {
        return "Vikingo{" +
                "toleranciaExtra=" + toleranciaExtra +
                ", limiteV=" + limiteV +
                '}';
    }

    public void activarHabilidadEspecial() {

        int limiteviejo = this.limiteV;
        if (this.toleranciaExtra <= 0 || this.limiteV < 5){
            this.limiteV = this.limiteV + (this.toleranciaExtra + 8)*3 ;
        }else {
            this.limiteV = this.limiteV * 2 ;
        }

        System.out.println("Tolerancia extra  limite  de \033[34m"+this.getNombre() +"\u001B[0m aumenta "+ limiteviejo +" --> \033[31m " + this.limiteV +"\u001B[0m");
    }
    public int getLimiteV(){
        return this.limiteV;
    }

    public Integer getToleranciaExtra() {
        return toleranciaExtra;
    }

}
