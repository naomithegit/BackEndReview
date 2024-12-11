package com.keyin.Aircraft;

import com.keyin.Airport.Airport;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AircraftRepository extends CrudRepository<Aircraft, Long> {

    @Query("SELECT DISTINCT a FROM Aircraft a JOIN a.passengers p WHERE p.id = :passengerId")
    List<Aircraft> findAircraftByPassengerId(@Param("passengerId") long passengerId);

    @Query("SELECT a.airports FROM Aircraft a WHERE a.id = :aircraftId")
    List<Airport> findAirportsByAircraftId(@Param("aircraftId") Long aircraftId);

    List<Aircraft> findByPassengerId(Integer passengerId);


    List<Aircraft> findByairLineNameContainingIgnoreCase(String airLineName);
}
