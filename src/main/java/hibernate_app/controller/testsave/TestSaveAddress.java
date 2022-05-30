package hibernate_app.controller.testsave;

import hibernate_app.dto.AddressDto;
import hibernate_app.service.AddressService;
import hibernate_app.service.impl.AddressServiceImpl;

public class TestSaveAddress {
	public static void main(String[] args) {
		AddressDto dto=new AddressDto();
		dto.setCity("banglore");
		dto.setLocation("btm");
		dto.setPincode(560032);
		dto.setState("karnataka");
		
		AddressServiceImpl addressServiceImpl=new AddressServiceImpl();
		addressServiceImpl.saveAddresss(1, dto);
	}
}
