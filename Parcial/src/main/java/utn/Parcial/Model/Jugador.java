package utn.Parcial.Model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Data
@NoArgsConstructor
@Entity
public class Jugador extends Persona{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private float peso;
    private float altura;
    private int goles;
    private int minutosJugados;


    private Currency currency;
    private String fechadeNacimiento;

    @Override
    public TypePersona typePersona() {
        return TypePersona.JUGADOR;
    }
}
