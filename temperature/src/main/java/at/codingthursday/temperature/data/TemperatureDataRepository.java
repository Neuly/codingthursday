package at.codingthursday.temperature.data;

import org.springframework.data.jpa.repository.JpaRepository;

interface TemperatureDataRepository extends JpaRepository<TemperatureData, Long> {

}