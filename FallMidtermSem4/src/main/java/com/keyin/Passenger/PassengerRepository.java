package com.keyin.Passenger;

import com.keyin.Aircraft.Aircraft;
import com.keyin.Airport.Airport;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PassengerRepository extends CrudRepository<Passenger, Long> {

    @Query("SELECT a FROM Aircraft a JOIN a.passengers p WHERE p.id = :passengerId")
    List<Aircraft> findAircraftByPassengerId(@Param("passengerId") Long passengerId);

    @Query("SELECT DISTINCT a FROM Airport a JOIN a.aircraft ac JOIN ac.passengers p")
    List<Airport> findAirportsUsedByPassengers();


    List<Passenger> findByfirstNameContainingIgnoreCase(String name);

}
