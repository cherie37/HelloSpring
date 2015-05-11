package com.aug.controller;

import java.io.Serializable;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller	
public class HelloController implements Serializable{
	
	/*@RequestMapping(value="/hello" ,method={RequestMethod.GET})
	public String helloPage(String name, Model model){
		return "sample";
	}*/
	
	@RequestMapping(value="/hello/{name}" ,method={RequestMethod.GET})
	public String helloPage(@PathVariable String name, Model model){
		return "sample";
	}
	
	@RequestMapping(value="/hello", method={RequestMethod.POST})
	public String hello(@RequestParam String name, Model model){
		model.addAttribute("name", name);
		return "hello";
	}

	
	
}
