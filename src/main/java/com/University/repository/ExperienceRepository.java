package com.University.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.University.model.Experience;

@Repository
public interface ExperienceRepository extends JpaRepository<Experience, Long> {
}
