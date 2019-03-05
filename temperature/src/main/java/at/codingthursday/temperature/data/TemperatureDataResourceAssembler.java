package at.codingthursday.temperature.data;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceAssembler;
import org.springframework.stereotype.Component;

@Component
class TemperatureDataResourceAssembler implements ResourceAssembler<TemperatureData, Resource<TemperatureData>> {

	@Override
	public Resource<TemperatureData> toResource(TemperatureData temperatureData) {
		return new Resource<>(temperatureData,
				linkTo(methodOn(TemperatureDataController.class).one(temperatureData.getId())).withSelfRel(),
				linkTo(methodOn(TemperatureDataController.class).all()).withRel("temperature"));
	}
}