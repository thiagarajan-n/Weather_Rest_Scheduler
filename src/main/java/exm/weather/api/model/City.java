package exm.weather.api.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class City {

	@Id
	private int city_id;
	private String city_name;
	private String country;

	public City(){}

	public City(String name, int city_id, String country){
		this.city_name = name;
		this.country = country;
		this.city_id = city_id;
	}

	public int getCityId() {
		return city_id;
	}
	public void setCityId(int id) {
		this.city_id = id;
	}
	public String getCityName() {
		return city_name;
	}
	public void setCityName(String name) {
		this.city_name = name;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String isbn) {
		this.country = isbn;
	}
}
