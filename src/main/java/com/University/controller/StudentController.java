package com.University.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.University.UniversityApplication;
import com.University.exception.ResourceNotFoundException;
import com.University.model.Student;
import com.University.repository.StudentRepository;

@RestController
@RequestMapping("/api/v1")
public class StudentController {
	private static final Logger logger = LoggerFactory.getLogger(UniversityApplication.class);

	@Autowired
	private StudentRepository studentRepository;

	// create get all students
	@GetMapping("/students")
	public List<Student> getAllStudents() {
		logger.info("getting All Students details");
		return studentRepository.findAll();

	}

	// get student by id
	@GetMapping("/students/{id}")
	public ResponseEntity<Student> getStudentId(@PathVariable(value = "id") Long studentId)
			throws ResourceNotFoundException {
		Student student = studentRepository.findById(studentId)
				.orElseThrow(() -> new ResourceNotFoundException("Student not found on this id:: " + studentId));
		logger.info("getting the student, Id:" + studentId);
		return ResponseEntity.ok().body(student);
	}

	// save student
	@PostMapping("/students")
	public Student createStudent(@RequestBody Student student) {
		logger.info("creating student details");
		return studentRepository.save(student);
	}

	// update student
	@PutMapping("/student/{id}")
	public ResponseEntity<Student> updateStudent(@PathVariable(value = "id") Long studentId,
			@RequestBody Student studentDetails) throws ResourceNotFoundException {
		Student student = studentRepository.findById(studentId)
				.orElseThrow(() -> new ResourceNotFoundException("Student not found on this id:: " + studentId));

		student.setStdName(studentDetails.getStdName());
		student.setStdDob(studentDetails.getStdDob());
		student.setStdPercentage(studentDetails.getStdPercentage());
		student.setStdPhymarks(studentDetails.getStdPhymarks());
		student.setStdChemarks(studentDetails.getStdChemarks());
		student.setStdMathsmarks(studentDetails.getStdMathsmarks());
		student.setAddressid(studentDetails.getAddressid());
		student.setEducationid(studentDetails.getEducationid());

		final Student updatedStudent = studentRepository.save(student);
		logger.info("updating the student, Id:" + studentId);
		return ResponseEntity.ok(updatedStudent);

	}

	// delete student by id
	@DeleteMapping("/Student/{id}")
	public Map<String, Boolean> deleteStudent(@PathVariable(value = "id") Long studentId) throws Exception {
		Student student = studentRepository.findById(studentId)
				.orElseThrow(() -> new ResourceNotFoundException("student not found on :: " + studentId));

		studentRepository.delete(student);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		logger.info("deleting the student, Id:" + studentId);
		return response;
	}
}
