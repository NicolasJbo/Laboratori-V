package com.example.springRepaso.converter;

import com.example.springRepaso.model.Persona;
import com.example.springRepaso.model.dto.PersonaDto;
import org.modelmapper.ModelMapper;
import org.modelmapper.spi.MappingContext;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class PersonToPersonDtoConvertor  implements Converter<Persona ,PersonaDto> {

    private final ModelMapper modelMapper;

    public PersonToPersonDtoConvertor( final ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }


    @Override
    public PersonaDto convert(Persona persona) {
            return modelMapper.map(persona, PersonaDto.class);
    }
}
