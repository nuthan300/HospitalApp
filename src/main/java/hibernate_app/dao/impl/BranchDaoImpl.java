package hibernate_app.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import hibernate_app.dao.BranchDao;
import hibernate_app.dto.Branchdto;
import hibernate_app.dto.HospitalDto;

public class BranchDaoImpl implements BranchDao {
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();

	
	public boolean saveBranch(int hospital_id, Branchdto branch) {
		HospitalDto dto= entityManager.find(HospitalDto.class, hospital_id);
		branch.setHospitalDto(dto);
		entityTransaction.begin();
		try {
			entityManager.persist(branch);
			entityTransaction.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public Branchdto getBranchById(int id) {
		return entityManager.find(Branchdto.class, id);
	}

	public boolean removeBranch(int id) {
		Branchdto dto= entityManager.find(Branchdto.class, id);
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

	public boolean updateBranch(int id, Branchdto branch) {
		branch.setId(id);
		entityTransaction.begin();
		try {
			entityManager.merge(branch);
			entityTransaction.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public List<Branchdto> getAllBranchByHospitalId(int hospital_id) {
        String sql="select h from BranchDto h where h.hospitalDto.id="+hospital_id;
		Query query = entityManager.createQuery(sql);
		return query.getResultList();
	}

	public List<Branchdto> getAllBranch() {
		 String sql="select h from BranchDto h";
			Query query = entityManager.createQuery(sql);
			return query.getResultList();
	}
	
}
