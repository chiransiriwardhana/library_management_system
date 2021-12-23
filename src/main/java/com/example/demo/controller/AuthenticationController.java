package com.example.demo.controller;


import java.security.Principal;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.Book;
import com.example.demo.model.Student;
import com.example.demo.model.User;
import com.example.demo.model.UserPrincipal;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.StudentService;
import com.example.demo.service.UserService;

@Controller
public class AuthenticationController {

	@Autowired
	UserRepository userRepository;

	@Autowired
	UserService userService;

	public String username="chiran" ;

	@Autowired
	StudentService studentService;

	@RequestMapping(value = { "/addStudent"}, method=RequestMethod.GET)
	public ModelAndView addStudentPage(Principal principal) {
		ModelAndView model = new ModelAndView();
		model.addObject("student", new Student());
		model.addObject("username", principal.getName());
		model.setViewName("Student");
		return model;
	}

	@RequestMapping(value = { "/addStudent"}, method=RequestMethod.POST)
	public ModelAndView saveStudent(@ModelAttribute("student") Student student) {
		studentService.saveStudent(student);

		ModelAndView model = new ModelAndView();
		model.addObject("student", new Student());
		model.setViewName("Student");

		return model;
	}


	@RequestMapping(value = { "/login" }, method = RequestMethod.GET)
	public ModelAndView login() {
		ModelAndView modelAndView = new ModelAndView();

		User user = new User();
		modelAndView.addObject("user", user); 
		modelAndView.setViewName("login"); // resources/template/login.html
		return modelAndView;
	}

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public ModelAndView register() {
		ModelAndView modelAndView = new ModelAndView();
		User user = new User();
		modelAndView.addObject("user", user); 
		modelAndView.setViewName("register"); // resources/template/register.html
		return modelAndView;
	}

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public ModelAndView home(Principal principal) {
		ModelAndView modelAndView = new ModelAndView();

		modelAndView.addObject("username", principal.getName());

		modelAndView.setViewName("home"); 
		return modelAndView;
	}

	@RequestMapping(value = "/newBook", method = RequestMethod.GET)
	public ModelAndView newBook(Principal principal) {
		ModelAndView modelAndView = new ModelAndView();

		modelAndView.addObject("username", principal.getName());
		modelAndView.addObject("book", new Book());

		modelAndView.setViewName("newBook"); 
		return modelAndView;
	}
	
	// need to change ============================================================================================
	
	@RequestMapping(value = "/newBook", method = RequestMethod.POST)
	public ModelAndView addBook(Principal principal) {
		ModelAndView modelAndView = new ModelAndView();

		modelAndView.addObject("username", principal.getName());
		modelAndView.addObject("book", new Book());

		modelAndView.setViewName("newBook"); 
		return modelAndView;
	}
	
	@RequestMapping(value = "/home/profile", method=RequestMethod.GET)
	public ModelAndView getProfile(Principal principal) {

		ModelAndView modelAndView = new ModelAndView();
		String email = principal.getName();
		modelAndView.addObject("name", userRepository.getUserByEmail(email).getName()+"  " + userRepository.getUserByEmail(email).getLastName());
		modelAndView.addObject("email", principal.getName());
		modelAndView.addObject("first_name", userRepository.getUserByEmail(email).getName());
		modelAndView.addObject("last_name", userRepository.getUserByEmail(email).getLastName());
		modelAndView.addObject("status", userRepository.getUserByEmail(email).getStatus());
		modelAndView.setViewName("profile");
		return modelAndView;
	}

	@RequestMapping(value = "/register", method=RequestMethod.POST)
	public ModelAndView registerUser(@Valid User user, BindingResult bindingResult, ModelMap modelMap) {
		ModelAndView modelAndView = new ModelAndView();

		if (bindingResult.hasErrors()) {
			modelAndView.addObject("successMessage","Please correct the errors in form");
			modelMap.addAttribute("bindingResult", bindingResult);
			
			modelAndView.addObject("user", new User());
			modelAndView.setViewName("register");
			return modelAndView;
		}

		else if(userService.isUserAlreadyPresent(user)){
			modelAndView.addObject("successMessage","user already exists!");
			
			modelAndView.addObject("user", new User());
			modelAndView.setViewName("register");
			return modelAndView;
			
		} else {
			userService.saveUser(user);
			modelAndView.addObject("successMessage","User is registered successfully!");
			
			modelAndView.addObject("user", new User());
			modelAndView.setViewName("login");
			return modelAndView;
			
		}

	}
}

