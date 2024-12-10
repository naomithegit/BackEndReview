package com.keyin.Passenger;

import com.keyin.Aircraft.Aircraft;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import com.keyin.Aircraft.AircraftRepository;


@Service
public class PassengerService {

    @Autowired
    private PassengerRepository passengerRepository;

    @Autowired
    private AircraftRepository aircraftRepository;

    public List<Passenger> getAllPassengers() {
        return(List<Passenger>) passengerRepository.findAll();
    }

    public Passenger getPassengerById(Long id) {
        return passengerRepository.findById(id).orElse(null);
    }

    public Passenger createPassenger(Passenger passenger) {
        return passengerRepository.save(passenger);
    }

    public Passenger updatePassenger(Long id, Passenger passenger) {
        Passenger existingPassenger = getPassengerById(id);
        if (existingPassenger != null) {
            existingPassenger.setFirstName(passenger.getFirstName());
            existingPassenger.setLastName(passenger.getLastName());
            existingPassenger.setPhoneNumber(passenger.getPhoneNumber());
            existingPassenger.setAircraft(passenger.getAircraft());
            return passengerRepository.save(existingPassenger);
        } else {
            return null;
        }
    }



    public void deletePassenger(Long id) {
        passengerRepository.deleteById(id);
    }

    public Passenger addAircraftToPassenger(Long passengerId, Long aircraftId) {
        Passenger passenger = passengerRepository.findById(passengerId)
                .orElseThrow(() -> new RuntimeException("Passenger not found"));
        Aircraft aircraft = aircraftRepository.findById(aircraftId)
                .orElseThrow(() -> new RuntimeException("Aircraft not found"));

        passenger.getAircraft().add(aircraft);
        return passengerRepository.save(passenger);
    }

    public List<Aircraft> getAircraftForPassenger(Long id) {
        Optional<Passenger> passengerOptional = passengerRepository.findById(id);
        passengerOptional.ifPresent(value -> value.getAircraft());
        return passengerOptional.get().getAircraft();

    }

}
