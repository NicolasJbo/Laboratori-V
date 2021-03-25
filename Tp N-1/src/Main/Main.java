package Main;

import Implemetacion.BeberEspartanoImp;
import Implemetacion.BeberVikingoImp;
import Implemetacion.OrinarEspartanoImp;
import Implemetacion.OrinarVikingoImp;
import clases.Espartano;
import clases.Humano;
import clases.Vikingo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        List<Humano> lVikingo= new ArrayList<Humano>();
        List<Humano> lEspartano= new ArrayList<Humano>();


        Vikingo vik1 =new Vikingo("Thorfin",30,90,new BeberVikingoImp(),new OrinarVikingoImp(),3);
        Vikingo vik2 =new Vikingo("Aren",34,98,new BeberVikingoImp(),new OrinarVikingoImp(),4);
        Vikingo vik3 =new Vikingo("Bjorn",29,80,new BeberVikingoImp(),new OrinarVikingoImp(),2);
        Vikingo vik4 =new Vikingo("Egil",31,84,new BeberVikingoImp(),new OrinarVikingoImp(),1);
        lVikingo.add(vik1);
        lVikingo.add(vik2);
        lVikingo.add(vik3);
        lVikingo.add(vik4);

        Espartano esp1 =new Espartano("Leónidas ",37,88,new BeberEspartanoImp(),new OrinarEspartanoImp(),2);
        Espartano esp2 =new Espartano("Plistarco ",25,79,new BeberEspartanoImp(),new OrinarEspartanoImp(),1);
        Espartano esp3 =new Espartano("Angus",47,110,new BeberEspartanoImp(),new OrinarEspartanoImp(),6);
        Espartano esp4 =new Espartano("Colin",30,98,new BeberEspartanoImp(),new OrinarEspartanoImp(),3);
        lEspartano.add(esp1);
        lEspartano.add(esp2);
        lEspartano.add(esp3);
        lEspartano.add(esp4);


        System.out.println(lVikingo);

       Humano ganador = competir(vik1,esp1);


    }
    public static Humano competir(Humano vik,Humano esp){
        Humano ganador=null ;

        Vikingo v = new Vikingo();
        Espartano e =new Espartano();

        if ( vik instanceof  Vikingo){
            v = (Vikingo)vik;
        }
        if (esp instanceof Espartano){
            e=(Espartano)esp;
        }


        //Habilidades especiales
        System.out.println("El combate esta por empezar \nActivando  Habilidades especiales ");

        v.activarHabilidadEspecial();
        e.activarHabilidadEspecial();

         int limiteV = v.getLimiteV();
         int limiteE = e.getLimiteE();
        int rondas = limiteV + limiteE;

        System.out.println("\n\n\n-----------Empieza el Combate de " + rondas +" rondas -----------");
        for (int i =0 ; i <  rondas; i++){


            System.out.println("--> RONDA "+(i+1)+" <--");
            vik.beber();
            limiteV--;

            esp.beber();
            limiteE--;

            // Cuando llegan al limite van a Orinar
            if(limiteV == 0){
                v.orinar();
            }
            if(limiteE == 0){
                e.orinar();
            }
            //verifico quien gano
            if (limiteV == 0 && limiteE >0){
                rondas = i+1;
                ganador = e;
                break;
            }
            if(limiteE == 0 && limiteV >0){
                rondas = i+1;
                ganador= v;
                break;
            }
            if(limiteE ==0 && limiteV==0 ){
                System.out.println("\033[32m EMPATE ,por llevar sangre Vikinga y porque la taberna fue construida por Vikingos ...  ");
                rondas = i+1;
                ganador= v;
                break;
            }
        }
        System.out.println("\033[32m Ganador "+ ganador.getNombre() + " el "+  ganador.getClass().getSimpleName() + " \u001B[0m");
        System.out.println("Total de rondas -> "+rondas);
        System.out.println("-----------Termina el  Combate -----------");


        return ganador;

    }
}
