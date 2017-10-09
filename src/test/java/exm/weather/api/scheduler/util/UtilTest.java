package exm.weather.api.scheduler.util;

import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.beans.factory.annotation.Autowired;

import exm.weather.api.scheduler.WeatherUpdateScheduler;

public class UtilTest {
	
	@Autowired
	private WeatherUpdateScheduler scheduler;
	
	@Test
	public void testTempConversion() {
		assertEquals(scheduler.tempConversion("298.02"),"76.766");
	}	

}
