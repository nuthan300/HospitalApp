package hibernate_app.dao;

import java.util.List;

import hibernate_app.dto.EncounterDto;

public interface EncounterDao {
	boolean saveEncounter(int person_id,int branch_id,EncounterDto encounter);;
	EncounterDto getEncounterById(int id);
	boolean removeEncounter(int id);
	boolean modifyEncounter(int id);
	List<EncounterDto> getAllEncounterByPerson(int person_id);
	List<EncounterDto> getAllEncounterByBranch(int branch_id);
	List<EncounterDto> getAllEncounterByStatus();
}
