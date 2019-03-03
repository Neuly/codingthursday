package at.codingthursday.temperature.data;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
class TemperatureDataNotFoundAdvice {

	@ResponseBody
	@ExceptionHandler(TemperatureDataNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	String employeeNotFoundHandler(TemperatureDataNotFoundException ex) {
		return ex.getMessage();
	}
}