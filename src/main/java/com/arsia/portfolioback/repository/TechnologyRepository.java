package com.arsia.portfolioback.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.arsia.portfolioback.entity.Technology;

@Repository
public interface TechnologyRepository extends JpaRepository<Technology, Long> {
}
