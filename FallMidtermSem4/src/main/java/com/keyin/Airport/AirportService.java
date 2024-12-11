package com.keyin.Airport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AirportService {

    @Autowired
    private AirportRepository airportRepository;

    public List<Airport> getAllAirports() {
        return (List<Airport>) airportRepository.findAll();
    }

    public Airport getAirportById(Long id) {
        return airportRepository.findById(id).orElse(null);
    }

    public Airport createAirport(Airport airport) {
        return airportRepository.save(airport);
    }

    public Airport updateAirport(Long id, Airport airport) {
        Airport existingAirport = getAirportById(id);
        if (existingAirport != null) {
            existingAirport.setName(airport.getName());
            return airportRepository.save(existingAirport);
        } else {
            return null;
        }
    }

    public void deleteAirport(Long id) {
        airportRepository.deleteById(id);
    }


    public List<Airport> searchAirportsByName(String name) {
        return airportRepository.findBynameContainingIgnoreCase(name);
    }
}
