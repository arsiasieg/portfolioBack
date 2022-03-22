package com.arsia.portfolioback.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.arsia.portfolioback.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
