package Implemetacion;

import Interfaces.IOrinar;

public class OrinarEspartanoImp implements IOrinar {
    @Override
    public void orinar() {
        System.out.println( " \033[33m Soy un Espartano y tengo que orinar \u001B[0m");

    }
}
