package hibernate_app.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import hibernate_app.dao.MedOrderDao;
import hibernate_app.dto.EncounterDto;
import hibernate_app.dto.ItemDto;
import hibernate_app.dto.MedOrderDto;


public class MedOrderDaoImpl implements MedOrderDao{
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();
	
	
	public boolean saveOrder(int encounter_id, MedOrderDto order) {
		int sum = 0 ;
		for (ItemDto item : order.getItems()) {
			
			sum += item.getCost() ;
		}
		order.setTotal(sum);
		EncounterDto encounter=entityManager.find(EncounterDto.class, encounter_id);
		order.setEncounterDto(encounter);
		entityTransaction.begin();
		try {
			entityManager.persist(order);
			entityTransaction.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public MedOrderDto getOrderById(int id) {
		return entityManager.find(MedOrderDto.class, id);
	}

	public boolean removeOrder(int id) {
		MedOrderDto dto= entityManager.find(MedOrderDto.class, id);
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

	public boolean modifyOrder(int id,MedOrderDto med_order) {
		med_order.setId(id);
		entityTransaction.begin();
		try {
			entityManager.merge(med_order);
			entityTransaction.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public List<MedOrderDto> getAllOrderByEncounter(int encounter_id) {
		String sql="select h from MedOrderDto h where h.encounterDto.id="+encounter_id;
		Query query = entityManager.createQuery(sql);
		return query.getResultList();
	}

	public List<MedOrderDto> getAllOrder() {
		String sql="select h from MedOrderDto h ";
		Query query = entityManager.createQuery(sql);
		return query.getResultList();
	}

}
