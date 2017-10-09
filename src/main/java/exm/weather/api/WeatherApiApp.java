package exm.weather.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

import exm.weather.api.controller.TemperatureController;

@SpringBootApplication
@EnableScheduling
@ComponentScan
public class WeatherApiApp {
	
	public static void main(String[] args) {
		SpringApplication.run(WeatherApiApp.class, args);
	}
	
}
