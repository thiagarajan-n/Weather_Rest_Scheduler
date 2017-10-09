package exm.weather.api.scheduler;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;

import exm.weather.api.model.City;
import exm.weather.api.model.Temperature;
import exm.weather.api.openweather.model.WeatherResponse;
import exm.weather.api.repo.CityRepo;
import exm.weather.api.repo.TemperatureRepo;
@Controller
public class WeatherUpdateScheduler {
	
	@Autowired
	CityRepo cityRepo;
	
	@Autowired
	TemperatureRepo tempRepo;
	@Value("${MyApiKey}")
	private String apiKey;

	
	@Scheduled(cron = "0 0 4 * * *")
	public void updateTemperature() {
		RestTemplate restTemplate = new RestTemplate();
		List<City> cityList = cityRepo.findAll();
		List<Temperature> tempList = new ArrayList<Temperature>();
		for(City city: cityList) {
			String apiUrl = buildURL(city.getCityId());
			
			ResponseEntity<WeatherResponse> consumeJSONString =
					restTemplate.getForEntity(apiUrl, WeatherResponse.class);
	        System.out.println("JSON String: "+consumeJSONString);
	        System.out.println(consumeJSONString.getBody().getDt());
	        System.out.println(consumeJSONString.getBody().getMainResponse());
	        
	        Temperature temp = new Temperature();
	        temp.setCity_id(city.getCityId());
	        temp.setDate(new Date(Long.parseLong(consumeJSONString.getBody().getDt())*1000));
	        temp.setTemp_max(tempConversion(consumeJSONString.getBody().getMainResponse().getTemp_max()));
	        temp.setTemp_min(tempConversion(consumeJSONString.getBody().getMainResponse().getTemp_min()));
	        tempList.add(temp);
		}
		tempRepo.save(tempList);
		
	}
	
	/*
	 * This method helps to convert temperature 
	 * from Kelvin to farenheit
	 */
	private float tempConversion(String temp) {
		float convertedTemp = (Float.parseFloat(temp)-273);
		return Double.valueOf((1.8*convertedTemp)+32).floatValue();
	}
	
	private String buildURL(int cityId) {
		return 
			new StringBuffer("http://api.openweathermap.org/data/2.5/weather?id=")
			.append(cityId).append("&appId=").append(apiKey).toString();
	}
}
