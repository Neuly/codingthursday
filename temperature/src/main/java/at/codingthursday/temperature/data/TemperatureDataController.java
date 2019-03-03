package at.codingthursday.temperature.data;

import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
class TemperatureDataController {

	private final TemperatureDataRepository repository;

	TemperatureDataController(TemperatureDataRepository repository) {
		this.repository = repository;
	}

	// Aggregate root

	@GetMapping("/temperature")
	List<TemperatureData> all() {
		return repository.findAll();
	}

	@PostMapping("/temperature")
	TemperatureData newTemperatureData(@RequestBody TemperatureData temperatureData) {
		return repository.save(temperatureData);
	}

	// Single item

	@GetMapping("/temperature/{id}")
	TemperatureData one(@PathVariable Long id) throws TemperatureDataNotFoundException {
		TemperatureData temperatureData = repository.findById(id).get();
		if (temperatureData == null)
			throw new TemperatureDataNotFoundException(id);
		return temperatureData;
	}

	@DeleteMapping("/temperature/{id}")
	void deleteEmployee(@PathVariable Long id) {
		repository.deleteById(id);
	}
}
