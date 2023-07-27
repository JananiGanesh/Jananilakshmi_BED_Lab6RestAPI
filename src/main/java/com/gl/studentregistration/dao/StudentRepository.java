package com.gl.studentregistration.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gl.studentregistration.entity.StudentRegistration;

public interface StudentRepository extends JpaRepository<StudentRegistration, Integer> {

}
