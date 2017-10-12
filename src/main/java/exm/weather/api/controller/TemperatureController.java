package exm.weather.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import exm.weather.api.model.Temperature;
import exm.weather.api.repo.TemperatureRepo;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/temperature")
public class TemperatureController {
	
	@Autowired
	TemperatureRepo temp;
	
	@ResponseBody
	@RequestMapping("/getAll")
	public List<Temperature> getTemperature(@RequestParam("id")int cityId) {
		return temp.findAll(cityId, new PageRequest(0, 5));
	}
	
	@ResponseBody
	@RequestMapping("/get")
	public Temperature getTemperatureForToday(@RequestParam("id")int cityId) {
		return temp.findByCity(cityId);
	}
}
