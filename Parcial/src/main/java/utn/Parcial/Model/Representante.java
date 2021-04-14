package utn.Parcial.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Representante extends Persona{


    private  float pesoDeLaBoveda;
    private  float montoTotal;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "jugadors_id")
    List<Jugador> jugadorList;

    @Override
    public TypePersona typePersona() {
        return TypePersona.REPRESENTANTE;
    }
}
