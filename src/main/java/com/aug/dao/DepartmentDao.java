package com.aug.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.aug.entities.Department;
@Repository("departmentDao")
@Transactional
public class DepartmentDao {

	@Autowired
	private SessionFactory sessionFactory;

	Session session;
	
	public Session getSession() {
		return session = sessionFactory.getCurrentSession();
	}

	public void setSession(Session session) {
		this.session = session;
	}

	public void create(Department department) {
		getSession().save(department);
	}

	public void update(Department department) {
		getSession().update(department);

	}

	public Department findById(Integer id) {
		Department department = (Department) getSession().get(Department.class, id);
		return department;

	}
	
	public List<Department> findAllUser() {
		List<Department> department = getSession().createQuery("from Department").list();
		return department;


	}
	
	public void delete(Department dapartment) {
		getSession().delete(dapartment);
	}

	
}
