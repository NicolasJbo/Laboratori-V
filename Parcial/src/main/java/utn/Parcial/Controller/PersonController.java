package utn.Parcial.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import utn.Parcial.Model.Persona;
import utn.Parcial.Model.Representante;
import utn.Parcial.Service.PersonaService;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    PersonaService personaService;

    //POST /person
    @PostMapping
    public void addPerson(@RequestBody Persona Person){
        personaService.addPerson(Person);
    }

    //GET /person
    @GetMapping
    public List<Persona> getAllPerson(){
       return personaService.getAll();
    }
    //GET /person/{id}
    @GetMapping("/{id}")
    public Persona getPersonById (@PathVariable Integer id){
        return personaService.getPersonById(id);
    }
    //DEL /person
    @GetMapping("/remove/{id}")
    public void removePersonById (@PathVariable Integer id){
        personaService.removePersonById(id);
    }
    //PUT /person/{id}/jugadores/{idJugador}
    @PutMapping("/person/{id}/jugador/{id_jugador}")
    public void addJugadoresRepresentantes(@PathVariable Integer id, @PathVariable Integer id_jugador){
        personaService.addJugadoresRepresentantes(id,id_jugador);
    }
    @GetMapping("/representante/{id}")
    public Representante getRepresentanteByiD(@PathVariable Integer id){
        return personaService.getRepresentanteByiD(id);
    }
}
