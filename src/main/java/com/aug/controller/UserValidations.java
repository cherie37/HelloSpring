package com.aug.controller;

import org.hibernate.mapping.Value;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.aug.entities.User;

@Component
public class UserValidations implements Validator {

	@Override
	public boolean supports(Class clazz) {
		return User.class.equals(clazz);
	}

	@Override
	public void validate(Object obj, Errors error) {

		ValidationUtils.rejectIfEmptyOrWhitespace(error, "firstName", "user.required.firstname",
				"firstname is required!");
		ValidationUtils.rejectIfEmptyOrWhitespace(error, "lastName", "user.required.lastname",
				"lastname is required");
		ValidationUtils.rejectIfEmptyOrWhitespace(error, "username", "user.required.username",
				"username is required");
		ValidationUtils.rejectIfEmptyOrWhitespace(error, "password", "user.required.password",
				"password is required");
		User user = (User) obj;
		
		if (("wan").equals(user.getUsername())) {
			error.rejectValue("username", "", "Wan Beware!!");
		}
		if (user!=null && user.getPassword().length() < 6) {
			error.rejectValue("password", "user.required.password.length",new Object[]{6}, "Password more than 6 char");
		}
		if(!user.getRepassword().equals(user.getPassword())){
			error.rejectValue("repassword", "", "Password is not same");
		}
	}

}
