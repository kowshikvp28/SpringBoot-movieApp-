package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Activities;

public interface ActivitiesRepo extends JpaRepository<Activities,Integer> {
    
}
