package hibernate_app.dao;

import java.util.List;

import hibernate_app.dto.HospitalDto;

public interface HospitalDao {
	boolean createHospital(HospitalDto hospital);
	HospitalDto getHospitalById(int id);
	boolean removeHospital(int id);
	boolean updateHospital(int id,HospitalDto hospital);
	List<HospitalDto> getAllHospital();
}
