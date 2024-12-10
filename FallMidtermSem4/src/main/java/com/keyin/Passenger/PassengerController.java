package com.keyin.Passenger;

import com.keyin.Aircraft.Aircraft;
import com.keyin.Aircraft.AircraftRepository;
import com.keyin.Aircraft.AircraftService;
import com.keyin.Airport.Airport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
public class PassengerController {

    @Autowired
    private PassengerService passengerService;

    @Autowired
    private AircraftService aircraftService;

    @Autowired
    private PassengerRepository passengerRepository;

    @Autowired
    private AircraftRepository aircraftRepository;

    // Get all airports used by passengers
    @GetMapping("/airports/used")
    public List<Airport> getAirportsUsedByPassengers() {
        return passengerRepository.findAirportsUsedByPassengers();
    }

    @PostMapping("/passengers")
    public Passenger createPassenger(@RequestBody Passenger passenger) {
        return passengerService.createPassenger(passenger);
    }

    // Endpoint to get aircraft by passenger
    @GetMapping("/passengers/{passengerId}/aircraft")
    public List<Aircraft> getAircraftByPassenger(@PathVariable Integer passengerId) {
        return aircraftRepository.findByPassengerId(passengerId);
    }

    @GetMapping("/passengers")
    public List<Passenger> getAllPassengers() {
        return passengerService.getAllPassengers();
    }

    @GetMapping("/passenger/{id}")
    public Passenger getPassengerById(@PathVariable Long id) {
        return passengerService.getPassengerById(id);
    }

    @PutMapping("/passenger/{id}")
    public Passenger updatePassenger(@PathVariable Long id, @RequestBody Passenger updatedPassenger) {
        return passengerService.updatePassenger(id, updatedPassenger);
    }

    @DeleteMapping("/passenger/{id}")
    public void deletePassenger(@PathVariable Long id) {
        passengerService.deletePassenger(id);
    }

    @PutMapping("/{passengerId}/aircraft/{aircraftId}")
    public Passenger addAircraftToPassenger(@PathVariable Long passengerId, @PathVariable Long aircraftId) {
        return passengerService.addAircraftToPassenger(passengerId, aircraftId);
    }

    @GetMapping("/getAircraftForPassenger")
    public List<Aircraft> getAircraftForPassenger(@PathVariable Long id) {
        return passengerService.getAircraftForPassenger(id);
    }


    @GetMapping("/passengers/search")
    public List<Passenger> searchPassengers(@RequestParam String q) {
        return passengerService.searchPassengersByName(q);
    }
}
