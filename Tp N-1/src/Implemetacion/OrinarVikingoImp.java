package Implemetacion;

import Interfaces.IOrinar;

public class OrinarVikingoImp implements IOrinar {
    @Override
    public void orinar() {
        System.out.println( " \033[33m Soy un Vikingo y tengo que orinar \u001B[0m");

    }
}
