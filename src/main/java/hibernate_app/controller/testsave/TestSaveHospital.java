package hibernate_app.controller.testsave;

import hibernate_app.dto.HospitalDto;
import hibernate_app.service.impl.HospitalServiceImpl;

public class TestSaveHospital {
	public static void main(String[] args) {
		HospitalDto dto=new HospitalDto();
		dto.setName("appollo");
		dto.setRegistration("BNG78659");
		
		HospitalServiceImpl hospitalServiceImpl = new HospitalServiceImpl() ;
		hospitalServiceImpl.createHospital(dto) ;
	}
}
