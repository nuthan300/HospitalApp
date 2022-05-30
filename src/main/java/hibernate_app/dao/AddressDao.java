package hibernate_app.dao;

import hibernate_app.dto.AddressDto;

public interface AddressDao {
	boolean saveAddresss(int branch_id,AddressDto address);
	AddressDto getAddressById(int id);
	boolean removeAddress(int id);
	boolean modifyAddress(int id);
}
