package com.gl.studentregistration.service;

import java.util.List;

import com.gl.studentregistration.entity.StudentRegistration;

public interface StudentService {

	public List<StudentRegistration> getAllStudents();

	public void save(StudentRegistration student);

	public void deleteById(int id);

	public StudentRegistration findById(int id);

}
