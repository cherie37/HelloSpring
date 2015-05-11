package com.aug.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.aug.entities.Department;


public interface DepartmentService {
	
	public void create(Department department);
	
	public void update(Department department);
	
	public void delete(Integer id);
	
	public Department findById(Integer id);
	
	public List<Department> findAll();
	
	public void deleteAll();

}
