package at.codingthursday.temperature.data;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import jdk.internal.jline.internal.Log;

@RestController
class TemperatureDataController {

	private final TemperatureDataRepository repository;

	private final TemperatureDataResourceAssembler assembler;

	private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(TemperatureDataController.class);

	TemperatureDataController(TemperatureDataRepository repository, TemperatureDataResourceAssembler assembler) {
		this.repository = repository;
		this.assembler = assembler;
	}

	@GetMapping("/temperature")
	Resources<Resource<TemperatureData>> all() {

		List<Resource<TemperatureData>> temperatureDatas = repository.findAll().stream()
				.map(temperatureData -> new Resource<>(temperatureData,
						linkTo(methodOn(TemperatureDataController.class).one(temperatureData.getId())).withSelfRel(),
						linkTo(methodOn(TemperatureDataController.class).all()).withRel("temperature")))
				.collect(Collectors.toList());

		return new Resources<>(temperatureDatas, linkTo(methodOn(TemperatureDataController.class).all()).withSelfRel());
	}

	@PostMapping("/temperature")
	ResponseEntity<?> newTemperatureData(@RequestBody TemperatureData temperatureData) throws URISyntaxException {

		Resource<TemperatureData> resource = assembler.toResource(repository.save(temperatureData));

		return ResponseEntity.created(new URI(resource.getId().expand().getHref())).body(resource);
	}

	@GetMapping("/temperature/{id}")
	Resource<TemperatureData> one(@PathVariable Long id) {

		TemperatureData temperatureData = repository.findById(id)
				.orElseThrow(() -> new TemperatureDataNotFoundException(id));

		return assembler.toResource(temperatureData);
	}

	@GetMapping("/temperature/getByPostalCode/{postalCode}")
	Resource<TemperatureData> getByPostalCode(@PathVariable Long postalCode) {
		try {
			log.info("Looking for postalCode; " + postalCode);
			TemperatureData temperatureData = repository.findAll().stream()
					.filter(p -> postalCode.compareTo(p.getPostalCode()) == 0)
					.findAny().get();
			return assembler.toResource(temperatureData);
		} catch (Exception e) {
			throw new TemperatureDataNotFoundException(postalCode);
		}
	}

	@DeleteMapping("/temperature/{id}")
	ResponseEntity<?> deleteTemperature(@PathVariable Long id) {
		repository.deleteById(id);
		return ResponseEntity.noContent().build();
	}
}
