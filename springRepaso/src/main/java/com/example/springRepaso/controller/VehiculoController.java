package com.example.springRepaso.controller;

import com.example.springRepaso.model.Vehiculo;
import com.example.springRepaso.service.VehiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehiculos")
public class VehiculoController {

    @Autowired
    private VehiculoService vehiculosService;

    @PostMapping
    public void addVehiculo(@RequestBody Vehiculo vehiculo){
        vehiculosService.addVehiculo(vehiculo);
    }

    @GetMapping
    public List<Vehiculo> getAll(){
        return vehiculosService.getAll();
    }
}
