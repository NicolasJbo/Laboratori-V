package com.example.springRepaso.repository;


import com.example.springRepaso.model.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface VehiculoRepository extends JpaRepository<Vehiculo,String > {
    @Query(value = "select * from vehiculo where id = ?1", nativeQuery = true)
   Vehiculo findByid(Integer id);
}
