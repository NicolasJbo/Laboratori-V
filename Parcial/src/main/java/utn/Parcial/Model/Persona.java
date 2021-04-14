package utn.Parcial.Model;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME,property = "TypePersona",visible = true)
@JsonSubTypes({
        @JsonSubTypes.Type(value = Jugador.class , name = "JUGADOR"),
        @JsonSubTypes.Type(value = Representante.class , name = "REPRESENTANTE")
})
@Entity
public abstract class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id ;
    private  String name;
    private  String lastName;

    public abstract TypePersona typePersona();



}
