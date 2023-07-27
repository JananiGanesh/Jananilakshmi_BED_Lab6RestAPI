package com.gl.studentregistration.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.gl.studentregistration.entity.StudentRegistration;
import com.gl.studentregistration.service.StudentService;

@Controller
@RequestMapping("/students")
public class StudentController {

	@Autowired
	StudentService service;

	@RequestMapping("/list")
	public String getAllStudents(Model model) {
		List<StudentRegistration> students = service.getAllStudents();
		model.addAttribute("students", students);
		return "student-list";
	}

	@GetMapping("/showFormForAdd")
	public String addStudent(Model model) {
		StudentRegistration student = new StudentRegistration();
		model.addAttribute("student", student);
		return "student-form";
	}

	@PostMapping("/showFormForUpdate")
	public String updateStudent(Model model, @RequestParam("studentId") int studentId) {
		StudentRegistration student = service.findById(studentId);
		model.addAttribute("student", student);
		return "student-form";
	}

	@PostMapping("/delete")
	public String delete(@RequestParam("studentId") int studentId) {
		service.deleteById(studentId);
		return "redirect:/students/list/";

	}

	@PostMapping("/save")
	public String save(@ModelAttribute("book") StudentRegistration student) {
		service.save(student);
		return "redirect:/students/list/";
	}

	@RequestMapping(value = "/403")
	public ModelAndView accesssDenied(Principal user) {

		ModelAndView model = new ModelAndView();

		if (user != null) {
			model.addObject("msg", "Hi " + user.getName() + ", you do not have permission to access this page!");
		} else {
			model.addObject("msg", "You do not have permission to access this page!");
		}

		model.setViewName("403");
		return model;

	}

}
