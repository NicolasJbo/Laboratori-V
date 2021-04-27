package com.example.springRepaso.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Data
@NoArgsConstructor
@Entity
public class Moto extends Vehiculo{

    private String cilindrada;

    @Override
    public TypeVehiculo typeVehiculo() {
        return TypeVehiculo.MOTO;
    }
}
