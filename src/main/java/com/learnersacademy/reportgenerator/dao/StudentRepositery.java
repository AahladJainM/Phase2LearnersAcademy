package com.learnersacademy.reportgenerator.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learnersacademy.reportgenerator.entity.Students;

@Repository
public interface StudentRepositery extends JpaRepository<Students, String> {

}