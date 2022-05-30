package hibernate_app.controller.testsave;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import hibernate_app.dto.EncounterDto;
import hibernate_app.service.impl.EncounterServiceImpl;

public class Encounter {
	public static void main(String[] args) {
		EncounterDto dto=new EncounterDto();
		dto.setAdmittedDate(LocalDate.of(2022, 05, 27));
		dto.setDischargedDate(LocalDate.now());
		dto.setReason("accident");
		dto.setStatus("normal");
		
		EncounterServiceImpl encounterServiceImpl=new EncounterServiceImpl();
		encounterServiceImpl.saveEncounter(1, 1, dto);
	}
}
