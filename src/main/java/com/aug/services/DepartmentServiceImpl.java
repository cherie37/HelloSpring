package com.aug.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.aug.dao.DepartmentDao;
import com.aug.entities.Department;

@Service(value = "departmentService")
public class DepartmentServiceImpl implements DepartmentService {
	
	@Autowired
	DepartmentDao departmentDao;

	@Transactional
	@Rollback
	public void create(Department department) {
		departmentDao.create(department);

	}

	@Transactional
	public void update(Department department) {
		departmentDao.update(department);

	}

	@Transactional
	public void delete(Integer id) {
		Department department = findById(id);
		departmentDao.delete(department);

	}
	
	@Transactional(readOnly = true)
	public Department findById(Integer id) {
		return departmentDao.findById(id);
	}

	@Transactional(readOnly = true)
	public List<Department> findAll() {
		return departmentDao.findAllUser();
	}

	@Transactional
	public void deleteAll() {
		List<Department> departments = departmentDao.findAllUser();
		for(Department dept : departments){
			departmentDao.delete(dept);
		}
	}



	

}
