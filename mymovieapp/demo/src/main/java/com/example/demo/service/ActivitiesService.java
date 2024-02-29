package com.example.demo.service;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.model.Activities;
import com.example.demo.repository.ActivitiesRepo;

@Service
public class ActivitiesService {
    private ActivitiesRepo activitiesRepo;

    public ActivitiesService(ActivitiesRepo activitiesRepo) {
        this.activitiesRepo = activitiesRepo;
    }

    public boolean storedetails(Activities activities) {
        try
        {
            activitiesRepo.save(activities);
            return true;
        } catch (Exception e) {
            System.out.print("");
            return false;
        }
    }

    public List<Activities> getAllDetail() {
        return activitiesRepo.findAll();
    }

     public List<Activities> getByPaginateSort(int offset, int pageSize, String field) {
        Page<Activities> pg = activitiesRepo.findAll(PageRequest.of(offset, pageSize, Sort.by(field)));
        return pg.getContent();
    }
}

