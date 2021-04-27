package com.example.springRepaso.model;

public enum TypeVehiculo {
    LANCHA("Lancha"),
    BICICLETA("La cleta"),
    MOTO("Motocicleta"),
    AUTO("Auto");

    private String descripcion;

    TypeVehiculo(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public static TypeVehiculo find(final String value){
        for(TypeVehiculo v: values()){
            if (v.toString().equalsIgnoreCase(value)){
                return v;
            }
        }
        throw new IllegalArgumentException(String.format("Invalid TypeVehiculo: %s", value));
    }
}
