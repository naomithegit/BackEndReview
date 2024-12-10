package com.keyin.Aircraft;

import com.keyin.Airport.Airport;
import com.keyin.Airport.AirportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class AircraftController {

    @Autowired
    private AircraftService aircraftService;

    @Autowired
    private AirportRepository airportRepository;

    // Endpoint to get airports by aircraft
    @GetMapping("/aircraft/{aircraftId}/airports")
    public List<Airport> getAirportsByAircraft(@PathVariable Integer aircraftId) {
        return airportRepository.findByAircraftId(aircraftId);
    }

    @GetMapping("/aircraft")
    public List<Aircraft> getAllAircraft() {
        return aircraftService.findAllAircraft();
    }

    @GetMapping("/aircraft/{id}")
    public Aircraft getAircraftById(@PathVariable long id) {
        return aircraftService.findAircraftById(id);
    }

    @PostMapping("/aircraft")
    public Aircraft createAircraft(@RequestBody Aircraft newAircraft){
        return aircraftService.createAircraft(newAircraft);
    }

    @PutMapping("/aircraft/{id}")
    public Aircraft updateAircraft(@PathVariable Long id, @RequestBody Aircraft aircraft) {
        return aircraftService.updateAircraft(id, aircraft);
    }

    @DeleteMapping("/aircraft/{id}")
    public void deleteAircraft(@PathVariable long id) {
        aircraftService.deleteAircraft(id);
    }


    @GetMapping("/aircraft/search")
    public List<Aircraft> searchAircraft(@RequestParam String q) {
        return aircraftService.searchAircraftByName(q); // This searches aircraft by name
    }
}



