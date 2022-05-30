package hibernate_app.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import hibernate_app.dao.PersonDao;
import hibernate_app.dto.PersonDto;

public class PersonDaoImpl implements PersonDao {

	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();

	public boolean savePerson(PersonDto person) {

		entityTransaction.begin();
		try {
			entityManager.persist(person);
			entityTransaction.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	public PersonDto getPersonById(int id) {

		return entityManager.find(PersonDto.class, id);

	}

	public boolean removePerson(int id) {

		PersonDto dto = entityManager.find(PersonDto.class, id);

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

	public boolean modifyPerson(int id, PersonDto person) {

		person.setId(id);
		entityTransaction.begin();
		try {
			entityManager.merge(person);
			entityTransaction.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public List<PersonDto> getAllPerson() {
		String sql="select p from PersonDto p";
		Query query = entityManager.createQuery(sql);
		return query.getResultList();
	}

}
