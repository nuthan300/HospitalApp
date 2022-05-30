package hibernate_app.controller.testsave;

import java.time.LocalDate;

import hibernate_app.dto.PersonDto;
import hibernate_app.service.impl.PersonServiceImpl;

public class TestSavePerson {
	public static void main(String[] args) {
		PersonDto dto=new  PersonDto();
		dto.setAge(20);
		dto.setDob(LocalDate.of(1999, 05, 30));
		dto.setEmail("balajitirupathi@gmail.com");
		dto.setGender("male");
		dto.setName("balaji devasety");
		dto.setPhone(7894561230l);
		
		PersonServiceImpl impl=new PersonServiceImpl();
		impl.savePerson(dto);
	}
}
