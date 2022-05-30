package hibernate_app.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import hibernate_app.dao.UserDao;
import hibernate_app.dto.UserDto;

public class UserDaoImpl implements UserDao {

	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();

	public boolean saveUser(UserDto user) {

		entityTransaction.begin();
		try {
			entityManager.persist(user);
			entityTransaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		return true;

	}

	public UserDto getUserById(int id) {

		return entityManager.find(UserDto.class, id);
	}

	public boolean removeUser(int id) {
		UserDto dto = entityManager.find(UserDto.class, id);

		entityTransaction.begin();
		try {
			entityManager.remove(dto);
			entityTransaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}

	public boolean updateUser(int id, UserDto user) {

		user.setId(id);
		entityTransaction.begin();
		try {
			entityManager.merge(user);
			entityTransaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public UserDto validateUser(String email, String password) {
		String sql = "SELECT u FROM UserDto u WHERE u.email = ?1 AND u.password = ?2";
		Query query = entityManager.createQuery(sql);
		query.setParameter(1, email);
		query.setParameter(2, password);

		List<UserDto> users = query.getResultList();

		return users.get(0);
	}

	public List<UserDto> getAllUser() {
		String sql = "SELECT u FROM UserDto u";
		Query query = entityManager.createQuery(sql);
		return query.getResultList();
	}

}
