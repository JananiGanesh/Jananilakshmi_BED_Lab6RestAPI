package com.gl.studentregistration.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gl.studentregistration.dao.StudentRepository;
import com.gl.studentregistration.entity.StudentRegistration;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentRepository repository;

	@Override
	public List<StudentRegistration> getAllStudents() {
		return repository.findAll();
	}

	@Override
	public void save(StudentRegistration student) {
		repository.save(student);

	}

	@Override
	public void deleteById(int id) {
		repository.deleteById(id);

	}

	@Override
	public StudentRegistration findById(int id) {
		Optional<StudentRegistration> optStudent = repository.findById(id);
		if (optStudent.isPresent()) {
			return optStudent.get();
		} else {
			throw new RuntimeException("Student Id is not present");
		}
	}

}
