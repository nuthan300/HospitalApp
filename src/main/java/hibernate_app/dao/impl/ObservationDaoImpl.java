package hibernate_app.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import hibernate_app.dao.ObservationDao;
import hibernate_app.dto.Branchdto;
import hibernate_app.dto.EncounterDto;

import hibernate_app.dto.ObservationDto;

public class ObservationDaoImpl implements ObservationDao {

	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();

	public boolean saveObservation(int encounter_id, ObservationDto observation) {

		EncounterDto dto = entityManager.find(EncounterDto.class, encounter_id);
		observation.setEncounterDto(dto);
		entityTransaction.begin();
		try {
			entityManager.persist(observation);
			entityTransaction.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public ObservationDto getObservationById(int id) {
	
		return entityManager.find(ObservationDto.class, id);
		
	}

	public boolean removeObservation(int id) {
		
		ObservationDto dto= entityManager.find(ObservationDto.class, id);
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

	public boolean modifyObservation(int id ,ObservationDto observation) {
		
		observation.setId(id);
		entityTransaction.begin();
		try {
			entityManager.merge(observation);
			entityTransaction.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}

	public List<ObservationDto> getAllObservationByEncounter(int encounter_id) {
		
		String sql="select h from ObservationDao h where h.encounterDto.id="+encounter_id;
		Query query = entityManager.createQuery(sql);
		return query.getResultList();
	}

	public List<ObservationDto> getAllObservation() {
		String sql="select h from ObservationDao h " ;
		Query query = entityManager.createQuery(sql);
		return query.getResultList();
	}

}
