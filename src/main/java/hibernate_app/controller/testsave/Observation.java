package hibernate_app.controller.testsave;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import hibernate_app.dto.ObservationDto;
import hibernate_app.service.impl.ObservationServiceImpl;

public class Observation {
	public static void main(String[] args) {
		ObservationDto dto=new ObservationDto();
		dto.setDescription("he is normal but needs some more medication");
		dto.setObservationTime(LocalDateTime.of(LocalDate.of(2022, 05, 28), LocalTime.now()));
		dto.setDoctorNamme("kumara");
		dto.setRemarks("severe");
		
		ObservationServiceImpl impl=new ObservationServiceImpl();
		impl.saveObservation(1, dto);
	}
}
