package com.arsia.portfolioback.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.arsia.portfolioback.entity.Language;

@Repository
public interface LanguageRepository extends JpaRepository<Language, Long> {

}
