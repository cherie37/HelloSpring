package com.aug.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.aug.entities.Department;
import com.aug.entities.User;


public interface UserService {
		
		public void create(User user);
		
		public void update(User user);
		
		public void delete(User user);
		
		public User findById(Integer id);
		
		public List<User> findAll();
		
		public void deleteAll();

}
