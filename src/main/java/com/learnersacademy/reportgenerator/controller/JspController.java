package com.learnersacademy.reportgenerator.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.learnersacademy.reportgenerator.dao.JdbcConnector;
import com.learnersacademy.reportgenerator.entity.User;

@Controller
public class JspController {

	@Autowired
	private JdbcConnector jdbcConnector;

	@GetMapping(value = "/login")
	public ModelAndView showForm() {
		return new ModelAndView("login", "user", new User());
	}

	@GetMapping("/reports/{id}")
	public String viewReport(Model model, @PathVariable(value = "id") String classId, HttpSession session) {
		if (session.getAttribute("username") != null) {
			model.addAttribute("reports", jdbcConnector.reportGeneration(classId));
			return "report";
		}
		return "redirect:/login";

	}

	@PostMapping("/classes")
	public String viewClasses(@ModelAttribute("user") User user, Model model, HttpSession session) {
		if (jdbcConnector.loginCredentials(user)) {
			session.setAttribute("username", user.getUsername());
			model.addAttribute("classes", jdbcConnector.getAllClasses());
			return "class-report";
		}
		return "error";
	}

	@GetMapping("/logout")
	public String viewClasses(HttpSession session) {
		session.removeAttribute("username");
		return "redirect:/login";
	}

}
