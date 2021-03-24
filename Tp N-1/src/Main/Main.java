package Main;

import Implemetacion.BeberEspartanoImp;
import Implemetacion.BeberVikingoImp;
import Implemetacion.OrinarEspartanoImp;
import Implemetacion.OrinarVikingoImp;
import clases.Espartano;
import clases.Humano;
import clases.Vikingo;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Vikingo vik1 =new Vikingo("Thorfin",30,90,new BeberVikingoImp(),new OrinarVikingoImp(),3);
        Espartano esp1 =new Espartano("Carlos",37,100,new BeberEspartanoImp(),new OrinarEspartanoImp(),4);


       Humano ganador = competir(vik1,esp1);
       

    }
    public static Humano competir(Vikingo vik,Espartano esp){
        Humano ganador =vik;
        //Habilidades especiales
        System.out.println("El combate esta por empezar \nActivando  Habilidades especiales ");
         vik.activarHabilidadEspecial();
         esp.activarHabilidadEspecial();

         int limiteV = vik.getLimiteV();
         int limiteE = esp.getLimiteE();
        int rondas = limiteV + limiteE;

        System.out.println("\n\n\n-----------Empieza el Combate de " + rondas +" -----------");
        for (int i =0 ; i <  rondas; i++){

            vik.beber();
            limiteV--;

            esp.beber();
            limiteE--;

            // Cuando llegan al limite van a Orinar
            if(limiteV == 0){
                vik.orinar();
            }
            if(limiteE == 0){
                esp.orinar();
            }
            //verifico quien gano
            if (limiteV == 0 && limiteE >0){
                System.out.println("\033[32mGanador " +esp.getNombre() + " el Espartano \u001B[0m");
                ganador = esp;
                break;
            }
            if(limiteE == 0 && limiteV >0){
                System.out.println("\033[32m Ganador "+ vik.getNombre() + " el Vikingo \u001B[0m");
                ganador= vik;
                break;
            }
            if(limiteE ==0 && limiteV==0 ){
                System.out.println("\033[32m EMPATE ,por llevar sangre Vikinga y porque la taberna esta en un pueblo Vikingo  "+ vik.getNombre() + " GANA este combate \u001B[0m");
                ganador= vik;
                break;
            }
        }
        System.out.println("-----------Termina el  Combate -----------");


        return ganador;

    }
}
