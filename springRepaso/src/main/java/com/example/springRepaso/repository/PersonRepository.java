package com.example.springRepaso.repository;

import com.example.springRepaso.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Persona, Integer> {

    @Query(value = "select * from person where name = ?1", nativeQuery = true)
    List<Persona> findByName(String filtro);  //select * from personas where nombre= filtro
}
