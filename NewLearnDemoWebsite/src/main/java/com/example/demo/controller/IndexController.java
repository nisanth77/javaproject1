package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.UserDetails;

@Controller
public class IndexController {
	@RequestMapping("index")
	public ModelAndView index(UserDetails ud) {
		/*
		 * HttpSession session = request.getSession(); String s =
		 * request.getParameter("name");
		 */
		ModelAndView mav = new ModelAndView();
		mav.addObject("details", ud);
		mav.setViewName("index");
		//session.setAttribute("username", uName);
		// session.setAttribute("pwd", password);
		// return "index";
		return mav;
	}
}
