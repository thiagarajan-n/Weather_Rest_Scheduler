package exm.weather.api.openweather.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class WeatherResponse {
	
	@JsonProperty
	private Main main;
	private String dt;
	private String base;
	
	public Main getMainResponse() {
		return main;
	}
	public void setMainResponse(Main mainResponse) {
		this.main = mainResponse;
	}
	public String getDt() {
		return dt;
	}
	public void setDt(String date) {
		this.dt = date;
	}
	public String getBase() {
		return base;
	}
	public void setBase(String base) {
		this.base = base;
	}
}
