package com.aug.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController implements Serializable {

	@RequestMapping(value = "/login", method = { RequestMethod.GET })
	public String login() {
		return "login";
	}

	@RequestMapping(value = "/login", method = { RequestMethod.POST })
	public String login(@RequestParam String username, String password, @DateTimeFormat(pattern="dd/MM/yyyy")Date date,
			Model model) {
		List<String> msg = new ArrayList<String>();
		int check = 0;

		if (username.trim().isEmpty()) {
			msg.add("*Username Required");
			check++;

		}

		if (password.trim().isEmpty()) {
			msg.add("*Password Required");
			check++;
		}else if (password.length() < 6) {
			msg.add("*Password must more than 6 charactor");
			check++;
		}

		if (check > 0) {
			System.out.println(msg);
			model.addAttribute("msg", msg);
			return "login";
		} else {
			model.addAttribute("username", username);
			model.addAttribute("password", password);
			model.addAttribute("date", date);
			return "welcome";
		}

	}
}
