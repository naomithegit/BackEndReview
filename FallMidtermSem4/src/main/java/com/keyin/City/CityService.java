package com.keyin.City;

import com.keyin.Airport.Airport;
import com.keyin.Airport.AirportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class CityService {

    @Autowired
    private CityRepository cityRepository;

    @Autowired
    private AirportRepository airportRepository;

    public List<City> getAllCities() {
        return (List<City>) cityRepository.findAll();
    }

    public City getCityById(Long id) {
        return cityRepository.findById(id).orElse(null);
    }

    public City createCity(City city) {
        return cityRepository.save(city);
    }

    public City updateCity(Long id, City city) {
        City existingCity = getCityById(id);
        if (existingCity != null) {
            existingCity.setName(city.getName());
            existingCity.setState(city.getState());
            existingCity.setPopulation(city.getPopulation());
            existingCity.setAirports(city.getAirports());
            return cityRepository.save(existingCity);
        } else {
            return null;
        }
    }

    public City addAirportToCity(Long cityId, Long airportId) {
        City city = cityRepository.findById(cityId).orElseThrow(() -> new RuntimeException("City not found"));
        Airport airport = airportRepository.findById(airportId).orElseThrow(() -> new RuntimeException("Airport not found"));
        city.getAirports().add(airport);
        return cityRepository.save(city);
    }

    public void deleteCity(Long id) {
        cityRepository.deleteById(id);
    }

    public Map<City, List<Airport>> getAirportsByCities() {
        List<City> cities = getAllCities();
        return cities.stream()
                .collect(Collectors.toMap(city -> city, City::getAirports));
    }


    public List<City> searchCitiesByName(String name) {
        return cityRepository.findBynameContainingIgnoreCase(name);
    }
}
