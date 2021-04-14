package utn.Parcial.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import utn.Parcial.Model.Jugador;
import utn.Parcial.Model.Persona;
import utn.Parcial.Model.Representante;
import utn.Parcial.Repository.PersonaRepository;

import java.util.List;

@Service
public class PersonaService {

    @Autowired
    PersonaRepository personaRepository;



    public void addPerson(Persona Person) {
        personaRepository.save(Person);
    }

    public List<Persona> getAll() {
        return personaRepository.findAll();
    }

    public Persona getPersonById(Integer id) {
        return personaRepository.findById(id).orElseThrow(()->new HttpClientErrorException(HttpStatus.NOT_FOUND));
    }

    public void removePersonById(Integer id) {
        personaRepository.deleteById(id);
    }

    public void addJugadoresRepresentantes(Integer id, Integer id_jugador)  {

        Persona persona= personaRepository.findById(id).orElseThrow(()->new HttpClientErrorException(HttpStatus.NOT_FOUND));
        Representante representante = (Representante) personaRepository.findById(id_jugador).orElseThrow(()->new HttpClientErrorException(HttpStatus.NOT_FOUND));
       //Agrego el jugador
        representante.getJugadorList().add((Jugador) persona);
        personaRepository.save(representante);
    }

    public Representante getRepresentanteByiD(Integer id) {

        Representante representante= (Representante) getPersonById(id);

        List<Jugador>jList = representante.getJugadorList();

        float acumD=0;
        float acumE=0;
        for(Jugador j : jList){
            if(j.getCurrency().getCurrency().equalsIgnoreCase("dolar")){
                acumD =+ j.getCurrency().getMonto();
            }
            if(j.getCurrency().getCurrency().equalsIgnoreCase("euro")){
                acumE =+ j.getCurrency().getMonto();
            }
        }
        //el doldar esta 10 pesos y 1 euro =20pesos
        float total= (acumD*10)+(acumE*20);
        representante.setMontoTotal(total);
        
        float peso= total/1000;
        //toda la bobeda esta compuesta por billetes de 1000pesos
        representante.setPesoDeLaBoveda(peso);


        return representante;
    }
}