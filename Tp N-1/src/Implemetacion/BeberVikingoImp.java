package Implemetacion;

import Interfaces.IBeber;

public class BeberVikingoImp implements IBeber {

    @Override
    public void beber() {
        System.out.println("\033[34m Soy un vikingo tomando \u001B[0m");

    }
}
