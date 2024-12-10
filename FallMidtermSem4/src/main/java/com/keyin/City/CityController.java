package com.keyin.City;

import com.keyin.Airport.Airport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
public class CityController {

    @Autowired
    private CityService cityService;

    @GetMapping("/cities")
    public List<City> getAllCities() {
        return cityService.getAllCities();
    }

    @GetMapping("/city/{id}")
    public City getCityById(@PathVariable Long id) {
        return cityService.getCityById(id);
    }

    @PostMapping("/cities")
    public City createCity(@RequestBody City newCity) {
        return cityService.createCity(newCity);
    }

    @PutMapping("/city/{id}")
    public City updateCity(@PathVariable Long id, @RequestBody City updatedCity) {
        return cityService.updateCity(id, updatedCity);
    }

    @DeleteMapping("/city/{id}")
    public void deleteCity(@PathVariable Long id) {
        cityService.deleteCity(id);
    }

    @GetMapping("/cities/airports")
    public Map<City, List<Airport>> getAirportsByCities() {
        return cityService.getAirportsByCities();
    }

    @PutMapping("/cities/{cityId}/airports/{airportId}")
    public City addAirportToCity(@PathVariable Long cityId, @PathVariable Long airportId) {
        return cityService.addAirportToCity(cityId, airportId);
    }

    // Added search method to search cities by name
    @GetMapping("/cities/search")
    public List<City> searchCities(@RequestParam String q) {
        return cityService.searchCitiesByName(q);  // Calls the service method to search by name
    }
}
