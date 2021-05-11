package com.example.springRepaso.model.projection;


import org.springframework.beans.factory.annotation.Value;

public interface PersonProjection {

    String getName();

    String getLastName();

    @Value("#{target.name + '' + target.lastName}")
    String getFullName();

}
