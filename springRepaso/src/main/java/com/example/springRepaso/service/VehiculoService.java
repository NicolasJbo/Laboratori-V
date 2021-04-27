package com.example.springRepaso.service;

import com.example.springRepaso.model.Persona;
import com.example.springRepaso.model.Vehiculo;
import com.example.springRepaso.repository.VehiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

@Service
public class VehiculoService {

    @Autowired
    VehiculoRepository vehiculoRepository;

    public void addVehiculo(Vehiculo vehiculo) {
        vehiculoRepository.save(vehiculo);
    }

    public List<Vehiculo> getAll() {
        return vehiculoRepository.findAll();
    }

    public Vehiculo getVehiculoById (Integer id){
        return vehiculoRepository.findByid(id);
    }
}