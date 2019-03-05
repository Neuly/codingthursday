package at.codingthursday.temperature.data;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

import com.opencsv.CSVReader;

@Configuration
class LoadDatabase {

	private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(LoadDatabase.class);
	@Autowired
	private ResourceLoader resourceLoader;

	@Bean
	CommandLineRunner initDatabase(TemperatureDataRepository repository) {
		Resource csvFile = resourceLoader.getResource("classpath:zipCodes/AT.txt");

		CSVReader reader = null;
		HashMap<Integer, String[]> beispielDaten = new HashMap();

		List<String[]> beispieldaten = new ArrayList<>();
		try {
			reader = new CSVReader(new FileReader(csvFile.getFile()), '\t');
			String[] line;
			while ((line = reader.readNext()) != null) {
				beispieldaten.add(line);
				beispielDaten.put(Integer.parseInt(line[1]), line);
			}
		} catch (IOException e) {
			log.error("During initDatabase", e);
		}

		beispielDaten.keySet().stream().distinct().filter(p -> p > 5000 && p < 6000).sorted().forEach(value -> {
			double temperature = Math.random() * 5 + 17.5; // Temperaturen zwischen 17.5 und 22.5 erzeugen
			String[] line = beispielDaten.get(value);
			log.info("Preloading " + line[1] + " " + repository.save(new TemperatureData(Long.parseLong(line[1]), temperature, TemperatureScale.CELSIUS,
					Double.valueOf(line[10]), Double.valueOf(line[9]))));
		});
		return args -> {
		};
	}

}