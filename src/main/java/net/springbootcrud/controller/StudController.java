package net.springbootcrud.controller;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import net.springbootcrud.model.Student;
import net.springbootcrud.service.StudService;



@Controller
@RequestMapping("/students/")
public class StudController {

	@Autowired
	private StudService service;
	
	@GetMapping("list")
	public String showUpdateForm(Model model) {
		model.addAttribute("students", service.listAll());
		return "index";
	}
	
	@GetMapping("signup")
	public String showSignUpForm(Student student) {
		return "add-student";
	}

	

	@PostMapping("add")
	public String addStudent(@Valid Student student, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "add-student";
		}

		service.save(student);
		return "redirect:list";
		
	}
		@GetMapping("edit/{id}")
	public String showUpdateForm(@PathVariable("id") int id, Model model) {
		Student student = service.get(id);
		model.addAttribute("student", student);
		return "update-student";
	}

	@PostMapping("update/{id}")
	public String updateStudent(@PathVariable("id") int id, @Valid Student student, BindingResult result,
			Model model) {
		if (result.hasErrors()) {
			student.setId(id);
			return "update-student";
		}

		service.save(student);
		model.addAttribute("students", service.listAll());
		return "index";
	}
	@GetMapping("delete/{id}")
	public String deleteStudent(@PathVariable("id") int id, Model model) {
		Student student = service.get(id);
				/*.orElseThrow(() -> new IllegalArgumentException("Invalid student Id:" + id));*/
		service.delete(id);
		model.addAttribute("students", service.listAll());
		return "index";
	}
}
