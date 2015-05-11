package com.aug.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.aug.entities.User;

@Repository(value="userDao")
//@Transactional
public class UserDao {

	@Autowired
	private SessionFactory sessionFactory;

	Session session;
	
	public Session getSession() {
		return session = sessionFactory.getCurrentSession();
	}

	public void setSession(Session session) {
		this.session = session;
	}

	public void create(User user) {
		getSession().save(user);
	}

	public void update(User user) {
		getSession().update(user);

	}

	public User readById(Integer id) {
		User user = (User) getSession().get(User.class, id);
		return user;

	}

	@SuppressWarnings("unchecked")
	public List<User> findAllUser() {
		List<User> user = getSession().createQuery("from User").list();
		return user;

	}

	/*
	 * public void findByFirstName(String firstName) { Query query = session
	 * .createQuery("from User u where u.firstName = :FIRST_NAME");
	 * query.setParameter("FIRST_NAME", firstName);
	 * 
	 * List<User> results = query.list(); for (User userList : results) {
	 * System.out.println("Employee Name(readByFirstName) : " +
	 * userList.getFirstName() + " " + userList.getLastName() ); } }
	 */

	public void delete(User user) {
		//User user = readById(id);
		getSession().delete(user);
	}

	public void deleteAll() {
		List<User> userList = findAllUser();
		for (User user : userList) {
			getSession().delete(user);
		}

	}

}
