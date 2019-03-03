package at.codingthursday.temperature.data;

import java.util.Date;

class TemperatureDataNotFoundException extends RuntimeException {

	TemperatureDataNotFoundException(Long id) {
		super("Could not find temperature Data for " + id);
	}
}