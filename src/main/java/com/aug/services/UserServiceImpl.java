package com.aug.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.aug.dao.DepartmentDao;
import com.aug.dao.UserDao;
import com.aug.entities.User;

@Service(value = "UserService")
@Transactional
public class UserServiceImpl implements UserService{

	@Autowired
	UserDao userdao;
	
	//@Transactional
	//@Rollback
	@Override
	public void create(User user) {
		userdao.create(user);
		
	}

	@Override //@Transactional
	public void update(User user) {
		userdao.update(user);
		
	}

	@Override// @Transactional
	public void delete(User user) {
		userdao.delete(user);
		
	}

	@Override
	public User findById(Integer id) {
		return userdao.readById(id);
	}

	@Override
	public List<User> findAll() {
		
		return userdao.findAllUser();
	}

	@Override //@Transactional
	public void deleteAll() {
		userdao.deleteAll();
		
	}

}
