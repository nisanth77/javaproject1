package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dao.UserDao;
import com.example.demo.model.Userdetails;

@Controller
public class UserController {
	@Autowired
	UserDao userdao;

	@RequestMapping("index")
	public String user() {
		return "index.jsp";
	}

	@RequestMapping("addUser")
	public String user(Userdetails userdetails) {
		userdao.save(userdetails);
		return "index.jsp";
	}

	@RequestMapping("getUser")
	public ModelAndView getUser(@RequestParam int id) {
		// System.out.println("id: "+id);
		ModelAndView mav = new ModelAndView("showUser.jsp");

		Userdetails user = userdao.findById(id).orElse(new Userdetails());

		mav.addObject(user);
		System.out.println(mav);
		return mav;
	}

	@RequestMapping("deleteUser")
	public ModelAndView deleteUser(@RequestParam int id) {
		ModelAndView mav = new ModelAndView("deleteUser.jsp");
		Userdetails userDetails = userdao.findById(id).orElse(new Userdetails());
		userdao.deleteById(id);
		mav.addObject(userDetails);
		return mav;
	}

	@RequestMapping("updateUser")
	public ModelAndView updateUser(Userdetails user) {
		ModelAndView mav = new ModelAndView("updateUser.jsp");
		userdao.findById(user.getId()).orElse(new Userdetails());
		userdao.deleteById(user.getId());
		mav.addObject(user);
		return mav;
	}
}
