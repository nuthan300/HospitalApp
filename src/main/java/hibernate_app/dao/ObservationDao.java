package hibernate_app.dao;

import java.util.List;

import hibernate_app.dto.ObservationDto;


public interface ObservationDao {
	boolean saveObservation(int encounter_id,ObservationDto observation);
	ObservationDto getObservationById(int id);
	boolean removeObservation(int id);
	boolean modifyObservation(int id);
	List<ObservationDto> getAllObservationByEncounter(int encounter_id);
	List<ObservationDto> getAllObservation();
}
