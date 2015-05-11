package com.aug.controller;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.jws.soap.SOAPBinding.Use;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.aug.entities.Department;
import com.aug.entities.User;
import com.aug.services.DepartmentService;
import com.aug.services.UserService;

@Controller
@SessionAttributes("user")
public class UserController implements Serializable {
	@Autowired
	private UserValidations userValidations;
	
	@Autowired
	private DepartmentService deptService;
	@Autowired
	private UserService userService;
	
	/*
	 * @RequestMapping(value="/user", method = { RequestMethod.GET }) public
	 * String userfirst(HttpServletResponse response){ response.addCookie(new
	 * Cookie("helloCookie", "cookie"));
	 * 
	 * return "/user/register"; }
	 */

	@RequestMapping(value = "/user", method = { RequestMethod.GET })
	public String userCookie(
			@CookieValue(value = "hitCounter", defaultValue = "0") Long hitCounter,
			HttpServletResponse response) {
		hitCounter++;
		Cookie cookie = new Cookie("hitCounter", hitCounter.toString());
		cookie.setMaxAge(10);
		response.addCookie(cookie);
		return "/user/register";
	}

	
	@RequestMapping(value = "/user", method = { RequestMethod.POST })
	public String user(@ModelAttribute("user") User user,BindingResult result) {
		userValidations.validate(user, result);
		if(result.hasErrors()){
			return "/user/register";
		}
		userService.create(user);
		return "redirect:/user";
	}
	
	/*@InitBinder
	public void initBinder(WebDataBinder binder){
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
		
		binder.registerCustomEditor(Department.class, this.departmentEditor);
	}*/
	
	/*@RequestMapping(value = "/user", method = { RequestMethod.POST })
	public String user(@ModelAttribute("user") User user,Error error) {
		ValidationUtils.rejectIfEmptyOrWhitespace(error, "firstName", " ",
				"firstname is required!");
		ValidationUtils.rejectIfEmptyOrWhitespace(error, "lastName", " ",
				"lastname is required");
		ValidationUtils.rejectIfEmptyOrWhitespace(error, "username", " ",
				"username is required");
		ValidationUtils.rejectIfEmptyOrWhitespace(error, "password", " ",
				"password is required");
		User user = (User) obj;
		
		if (("wan").equals(user.getUsername())) {
			error.rejectValue("username", "", "Wan Beware!!");
		}
		if (user.getPassword().length() < 6) {
			error.rejectValue("password", " ", "Password more than 6");
		}
		
		if(result.hasErrors()){
			return "/user/register";
		}
		return "/user/success";
	}
	*/

	@RequestMapping(value = "/usersave", method = { RequestMethod.GET })
	public String usersave(SessionStatus sessionStatus) {
		sessionStatus.setComplete();
		return "redirect:/user";
	}

	@ModelAttribute("user")
	public User newUser() {
		return new User();
	}

	@ModelAttribute("month")
	public Map<Integer, String> getMonths() {
		Map<Integer, String> month = new HashMap<Integer, String>();
		month.put(1, "Jan");
		month.put(2, "Feb");
		month.put(3, "Mar");
		return month;

	}
	
	@ModelAttribute("department")
	public List<Department> getDepartment(){
		return deptService.findAll();
		
	}
	
	@ModelAttribute("allUser")
	public List<User> getUser(){
		return userService.findAll();
	}
	
	@RequestMapping(value = "/userUpdate/{id}", method = { RequestMethod.GET })
	public String userUpdate(@ModelAttribute("userUpdate") User user,@PathVariable Integer id, ModelMap model) {
		user = userService.findById(id);
		model.addAttribute("user", user);
		
		return "/user/register";
	}
	
	@RequestMapping(value = "/userUpdate/{id}", method = { RequestMethod.POST })
	public String userUpdatePost(@ModelAttribute("userUpdate") User user,BindingResult result,@PathVariable Integer id, Model model) {
		userValidations.validate(user, result);
		if(result.hasErrors()){
		//model.addAttribute("user", user);
			return "/user/register";
		}
		userService.update(user);
		return "redirect:/user";
	}

	
	@RequestMapping(value = "/userDelete/{id}", method = { RequestMethod.GET })
	public String userDeletePost(@ModelAttribute("userDelete") User user,BindingResult result,@PathVariable Integer id, Model model) {

		userService.delete(user);
		return "redirect:/user";
	}
	
	
	
	
 

}
