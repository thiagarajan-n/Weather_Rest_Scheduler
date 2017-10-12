package exm.weather.api.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import exm.weather.api.model.Temperature;

public interface TemperatureRepo extends JpaRepository<Temperature, Integer> {

	@Query("select T from Temperature T where T.city_id = :id")
	List<Temperature> findAll(@Param("id")int id, Pageable pageable);
	
	@Query("select T from Temperature T where T.date = CURRENT_DATE and T.city_id = :id")
	Temperature findByCity(@Param("id")int id);
}
