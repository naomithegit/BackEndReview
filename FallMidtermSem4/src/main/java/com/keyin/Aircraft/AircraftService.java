package com.keyin.Aircraft;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AircraftService {

    @Autowired
    private AircraftRepository aircraftRepository;

    public Aircraft createAircraft(Aircraft newAircraft){
        return aircraftRepository.save(newAircraft);
    }

    public List<Aircraft> findAllAircraft() {
        return (List<Aircraft>)aircraftRepository.findAll();
    }

    public Aircraft findAircraftById(long id) {
        Optional<Aircraft> aircraftOptional = aircraftRepository.findById(id);
        return aircraftOptional.orElse(null);
    }

    public Aircraft getAircraftById(long id) {
        return aircraftRepository.findById(id).orElse(null);
    }

    public Aircraft updateAircraft(Long id, Aircraft aircraft) {
        Aircraft existingAircraft = getAircraftById(id);
        if (existingAircraft != null) {
            existingAircraft.setType(aircraft.getType());
            existingAircraft.setType(aircraft.getType());
            // Update other fields as necessary
            return aircraftRepository.save(existingAircraft);
        } else {
            return null;
        }
    }

    public void deleteAircraft(Long id) {
        aircraftRepository.deleteById(id);
    }


    public List<Aircraft> searchAircraftByName(String name) {
        return aircraftRepository.findByairLineNameContainingIgnoreCase(name);
    }
}
