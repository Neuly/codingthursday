package at.codingthursday.temperature.data;


import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class LoadDatabase {

	private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(LoadDatabase.class);

	@Bean
	CommandLineRunner initDatabase(TemperatureDataRepository repository) {
		return args -> {
			log.info("Preloading " + repository.save(new TemperatureData(5.0, TemperatureScale.CELSIUS)));
			log.info("Preloading " + repository.save(new TemperatureData(20.0, TemperatureScale.FAHRENHEIT)));
		};
	}
}