package com.example.springRepaso.controller;

import com.example.springRepaso.model.PaginationResponse;
import com.example.springRepaso.model.Persona;
import com.example.springRepaso.model.PostResponse;
import com.example.springRepaso.model.Vehiculo;
import com.example.springRepaso.model.dto.PersonaDto;
import com.example.springRepaso.model.projection.PersonProjection;
import com.example.springRepaso.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/persona")
public class PersonController {


    @Autowired
    private final PersonService personService;
    @Autowired
    private ConversionService conversionService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/{personId}")
    public PersonaDto getPersonById(@PathVariable Integer personId){

        return  conversionService.convert(personService.getById(personId), PersonaDto.class);
    }
    @GetMapping("/{personId}/projection}")
    public PersonProjection getPersonByIdProjection(@PathVariable String personId){

        return  personService.getByIdProjection(personId);
    }

    @PostMapping
    public PostResponse addPerson(@RequestBody  Persona newPerson){
         return personService.addPerson(newPerson);
    }


    //-------------------------------Pagination------------------------------------
    @GetMapping("/pagination")
    public PaginationResponse<Persona> getAllAb(@RequestParam(value = "size" ,defaultValue = "20") Integer size,
                                              @RequestParam (value = "page",defaultValue = "0") Integer page){
        return personService.getAllAb(page,size);
    }
    //------------------------------------------------------------------------------


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