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
import com.University.model.Education;
import com.University.repository.EducationRepository;

@RestController
@RequestMapping("/api/v1")
public class EducationController {
	private static final Logger logger = LoggerFactory.getLogger(UniversityApplication.class);
	@Autowired
	private EducationRepository educationRepository;

	// create get all education
	@GetMapping("/education")
	public List<Education> getAllEducation() {
		logger.info("getting All Education details");
		return educationRepository.findAll();

	}

	// get education by id
	@GetMapping("/education/{id}")
	public ResponseEntity<Education> getEducationId(@PathVariable(value = "id") Long educationId)
			throws ResourceNotFoundException {
		Education education = educationRepository.findById(educationId)
				.orElseThrow(() -> new ResourceNotFoundException("Student not found on this id:: " + educationId));
		logger.info("getting the education, Id:" + educationId);
		return ResponseEntity.ok().body(education);
	}

	// save education
	@PostMapping("/education")
	public Education createEducation(@RequestBody Education education) {
		logger.info("creating an education");
		return educationRepository.save(education);
	}

	// update education
	@PutMapping("/education/{id}")
	public ResponseEntity<Education> updateEducation(@PathVariable(value = "id") Long educationId,
			@RequestBody Education educationDetails) throws ResourceNotFoundException {
		Education education = educationRepository.findById(educationId)
				.orElseThrow(() -> new ResourceNotFoundException("Education not found on this id:: " + educationId));

		education.setCourse(educationDetails.getCourse());
		education.setUniversity(educationDetails.getUniversity());
		education.setPlace(educationDetails.getPlace());
		education.setMarks(educationDetails.getMarks());
		education.setYop(educationDetails.getYop());
		education.setDepartment(educationDetails.getDepartment());

		final Education updatedEducation = educationRepository.save(education);
		logger.info("updating the education, Id:" + educationId);
		return ResponseEntity.ok(updatedEducation);

	}

	// delete education by id
	@DeleteMapping("/education/{id}")
	public Map<String, Boolean> deleteEducation(@PathVariable(value = "id") Long educationId) throws Exception {
		Education education = educationRepository.findById(educationId)
				.orElseThrow(() -> new ResourceNotFoundException("student not found on :: " + educationId));

		educationRepository.delete(education);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		logger.info("deleting the education, Id:" + educationId);
		return response;
	}
}
