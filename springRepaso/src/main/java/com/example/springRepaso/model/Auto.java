package com.example.springRepaso.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Auto extends Vehiculo{

    private int puertas;

    @Override
    public TypeVehiculo typeVehiculo() {
        return TypeVehiculo.AUTO;
    }
}
