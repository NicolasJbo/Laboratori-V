package com.example.springRepaso.controller;

import com.example.springRepaso.model.Persona;
import com.example.springRepaso.model.PostResponse;
import com.example.springRepaso.model.Vehiculo;
import com.example.springRepaso.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/persona")
public class PersonController {

    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/{personId}")
    public Persona getPersonById(@PathVariable Integer personId){
         return  personService.getById(personId);
    }

    @PostMapping
    public PostResponse addPerson(@RequestBody  Persona newPerson){
         return personService.addPerson(newPerson);
    }

    @GetMapping
    public List<Persona> getAll(@RequestParam(required = false) String filtro){ //parametro opcional
        return personService.getAll(filtro);
    }

    @PutMapping("/{id}/vehiculos/{idVehiculo}")
    public void addVehiculoToPerson(@PathVariable Integer id, @PathVariable Integer idVehiculo){
        personService.addVehiculoToPersona(id,idVehiculo);
    }
    @GetMapping("/{id}/vehiculos")
    public List<Vehiculo> getVehivulosByPersonId(Integer personId){
        return personService.getVehivulosByPersonId(personId);
    }
}