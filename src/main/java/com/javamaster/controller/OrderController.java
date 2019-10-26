package com.javamaster.controller;

import java.util.List;

import com.javamaster.dao.DAOUser;
import com.javamaster.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class OrderController {
	@Autowired
	private DAOUser db;

	@RequestMapping(value = {"viewUser","/"}, method=RequestMethod.GET)
	public ModelAndView viewUser() {
		List<User> users = db.readAll();
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("db");
		modelAndView.addObject("usersList", users);
		return modelAndView;
	}
	
	@RequestMapping(value="addUser", method=RequestMethod.POST)
	public String addUser(@RequestParam(value="name") String name, @RequestParam(value="age") Integer age,@RequestParam(value="phone") String phone,@RequestParam(value="address") String address) {
		User user = new User(name,age,phone,address);
		db.save(user);
		return "db";
	}
}
