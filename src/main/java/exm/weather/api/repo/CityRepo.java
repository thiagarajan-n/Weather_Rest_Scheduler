package exm.weather.api.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import exm.weather.api.model.City;

public interface CityRepo extends JpaRepository<City, Integer> {

}
