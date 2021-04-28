package com.example.springRepaso.model.dto;

import com.example.springRepaso.model.Vehiculo;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@NoArgsConstructor

public class PersonaDto {

    private Integer id;


    private String name;


    private String lastname;


    List<Vehiculo> vehiculosList;
}
