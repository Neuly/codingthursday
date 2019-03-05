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

	private Double latitude;

	private Double longitude;

	TemperatureData() {

	}

	TemperatureData(Double temperature, TemperatureScale temperatureScale, Double latitude, Double longitude) {
		this.temperature = temperature;
		this.temperatureScale = temperatureScale;
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getTemperature() {
		return temperature;
	}

	public void setTemperature(Double temperature) {
		this.temperature = temperature;
	}

	public TemperatureScale getTemperatureScale() {
		return temperatureScale;
	}

	public void setTemperatureScale(TemperatureScale temperatureScale) {
		this.temperatureScale = temperatureScale;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

}
