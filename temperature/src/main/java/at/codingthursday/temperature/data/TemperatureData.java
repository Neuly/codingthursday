package at.codingthursday.temperature.data;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
class TemperatureData {

	private @Id @GeneratedValue Long id;

	private Double temperature;

	@Enumerated(EnumType.STRING)
	private TemperatureScale temperatureScale;

	TemperatureData() {

	}

	TemperatureData(Double temperature, TemperatureScale temperatureScale) {
		this.temperature = temperature;
		this.temperatureScale = temperatureScale;
	}

}
