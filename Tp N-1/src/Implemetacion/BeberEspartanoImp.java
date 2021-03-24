package Implemetacion;

import Interfaces.IBeber;

public class BeberEspartanoImp implements IBeber {

    @Override
    public void beber() {
        System.out.println(" \033[35mSoy un Espartano tomando \u001B[0m");

    }
}
