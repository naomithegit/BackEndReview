package com.keyin.Airport;

import com.keyin.Aircraft.Aircraft;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AirportRepository extends CrudRepository<Airport, Long> {

    List<Airport> findByCityId(Integer cityId);

    List<Airport> findByAircraftId(Integer aircraftId);

    @Query("SELECT a.airports FROM Aircraft a WHERE a.id = :aircraftId")
    List<Airport> findAirportsByAircraftId(@Param("aircraftId") Integer aircraftId);

    @Query("SELECT a FROM Airport a WHERE a.cityId = :cityId")
    List<Airport> findAirportsByCityId(@Param("cityId") Integer cityId);

    @Query("SELECT a FROM Aircraft a JOIN a.passengers p WHERE p.id = :passengerId")
    List<Aircraft> findByPassengerId(@Param("passengerId") long passengerId);


    List<Airport> findByNameContainingIgnoreCase(String name);
}
