package utn.Parcial.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import utn.Parcial.Model.Persona;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, Integer> {


}
