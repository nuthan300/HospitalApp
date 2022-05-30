package hibernate_app.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import hibernate_app.dao.AddressDao;
import hibernate_app.dto.AddressDto;
import hibernate_app.dto.Branchdto;

public class AddressDaoImpl implements AddressDao {

	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();

	@Override
	public boolean saveAddresss(int branch_id, AddressDto address) {

		Branchdto dto = entityManager.find(Branchdto.class, branch_id);
		address.setBranchdto(dto);
		
		entityTransaction.begin();
		try {
			entityManager.persist(address);
			entityTransaction.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public AddressDto getAddressById(int id) {
		return entityManager.find(AddressDto.class, id);
	}

	public boolean removeAddress(int id) {
		AddressDto dto = entityManager.find(AddressDto.class, id);
		entityTransaction.begin();
		try {
			entityManager.remove(dto);
			entityTransaction.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean modifyAddress(int id, AddressDto address) {
		address.setId(id);
		entityTransaction.begin();
		try {
			entityManager.merge(address);
			entityTransaction.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
