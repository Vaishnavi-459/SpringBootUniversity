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
import com.University.model.Experience;

import com.University.repository.ExperienceRepository;

@RestController
@RequestMapping("/api/v1")
public class ExperienceController {
	private static final Logger logger = LoggerFactory.getLogger(UniversityApplication.class);
	@Autowired
	private ExperienceRepository experienceRepository;

	// create get all experience
	@GetMapping("/experience")
	public List<Experience> getAllExperience() {
		logger.info("getting All experience details");
		return experienceRepository.findAll();

	}

	// get experience by id
	@GetMapping("/experience/{id}")
	public ResponseEntity<Experience> getExperienceId(@PathVariable(value = "id") Long experienceId)
			throws ResourceNotFoundException {
		Experience experience = experienceRepository.findById(experienceId)
				.orElseThrow(() -> new ResourceNotFoundException(" experience not found on this id:: " + experienceId));
		logger.info("getting the experience, Id:" + experienceId);
		return ResponseEntity.ok().body(experience);
	}

	// save experience
	@PostMapping("/experience")
	public Experience createExperience(@RequestBody Experience experience) {
		logger.info("creating an experience");
		return experienceRepository.save(experience);
	}

	// update experience
	@PutMapping("/experience/{id}")
	public ResponseEntity<Experience> updateExperience(@PathVariable(value = "id") Long experienceId,
			@RequestBody Experience experienceDetails) throws ResourceNotFoundException {
		Experience experience = experienceRepository.findById(experienceId)
				.orElseThrow(() -> new ResourceNotFoundException(" experience not found on this id:: " + experienceId));

		experience.setOrganisationName(experienceDetails.getOrganisationName());
		experience.setDesignation(experienceDetails.getDesignation());
		experience.setExp(experienceDetails.getExp());

		final Experience updatedExperience = experienceRepository.save(experience);
		logger.info("updating the experience, Id:" + experienceId);
		return ResponseEntity.ok(updatedExperience);

	}

	// delete experience by id
	@DeleteMapping("/experience/{id}")
	public Map<String, Boolean> deleteExperience(@PathVariable(value = "id") Long experienceId) throws Exception {
		Experience experience = experienceRepository.findById(experienceId)
				.orElseThrow(() -> new ResourceNotFoundException("student not found on :: " + experienceId));

		experienceRepository.delete(experience);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		logger.info("deleting the experience, Id:" + experienceId);
		return response;
	}
}
