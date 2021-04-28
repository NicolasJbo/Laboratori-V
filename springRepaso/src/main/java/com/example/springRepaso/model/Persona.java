package com.example.springRepaso.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Persona {

    @Id
    @GeneratedValue
    private Integer id;

    @NotNull(message ="EL campo nombre es OBLIGATORIO.")
    @Size(min=3, message = "Debe tener mas de 3 caracteres.")
    private String name;

    @NotNull(message = "Apellido debe ser completado")
    private String lastname;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "vehiculo_id")
    List<Vehiculo> vehiculosList;

    //----------OCULATAR INFORMACION----------

    private String direccion;


}