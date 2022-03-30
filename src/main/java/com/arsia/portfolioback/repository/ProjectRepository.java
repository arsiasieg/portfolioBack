package com.arsia.portfolioback.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.arsia.portfolioback.entity.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {

}
