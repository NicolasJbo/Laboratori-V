package com.example.springRepaso.service;

import com.example.springRepaso.Utils.EntityURLBuilder;
import com.example.springRepaso.model.PaginationResponse;
import com.example.springRepaso.model.Persona;
import com.example.springRepaso.model.PostResponse;
import com.example.springRepaso.model.Vehiculo;
import com.example.springRepaso.model.projection.PersonProjection;
import com.example.springRepaso.repository.PersonRepository;
import com.example.springRepaso.repository.VehiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

import static java.util.Objects.isNull;


@Service
public class PersonService {
    private  static  final  String PERSONA_PATH="persona";
     PersonRepository personRepository;
     VehiculoService vehiculoService;

    @Autowired
    public PersonService(PersonRepository personRepository, VehiculoService vehiculoService) {
        this.personRepository = personRepository;
        this.vehiculoService = vehiculoService;
    }

    public PostResponse addPerson(Persona newPersona) {
         Persona personita= personRepository.save(newPersona);
         return PostResponse
                 .builder()
                 .status(HttpStatus.CREATED)
                 .url(EntityURLBuilder.buildUrl(PERSONA_PATH, personita.getId()))
                 .build();
    }
    //-------------------------------Pagination------------------------------------
    public PaginationResponse<Persona> getAllAb(Integer page, Integer size){ //parametro opcional
        Pageable pageable = PageRequest.of(page,size);
        Page<Persona> personaPage=personRepository.findAll(pageable);

        return new PaginationResponse<>(personaPage.getContent(),personaPage.getTotalPages(),personaPage.getTotalElements());

    }
    //------------------------------------------------------------------------------

    public List<Persona> getAll(String filtro) {
        if(isNull(filtro)) {
            return personRepository.findAll();
        }
        return personRepository.findByName(filtro);
    }

    public Persona getById (Integer id){
        return personRepository.findById(id).orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND));
    }

    public void addVehiculoToPersona(Integer id, Integer idVehiculo) {
        Persona persona = getById(id);
        Vehiculo vehiculo = vehiculoService.getVehiculoById(idVehiculo);
        persona.getVehiculosList().add(vehiculo);
        personRepository.save(persona);
    }

    public List<Vehiculo> getVehivulosByPersonId(Integer personId) {
        Persona user = this.getById(personId);
        return  user.getVehiculosList();
    }

    public PersonProjection getByIdProjection(String name) {
        return personRepository.findByName2(name);


    }
}
