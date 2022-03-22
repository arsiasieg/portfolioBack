package com.arsia.portfolioback.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.arsia.portfolioback.entity.Hobby;

@Repository
public interface HobbyRepository extends JpaRepository<Hobby, Long> {

}
