package com.example.demo.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.model.Register;
import com.example.demo.repository.RegisterRepo;

@Service
public class RegisterService {
    private RegisterRepo registerRepo;

    public RegisterService(RegisterRepo registerRepo) {
        this.registerRepo = registerRepo;
    }

    @SuppressWarnings("null")
    public boolean storedetails(Register register) {
        try
        {
            registerRepo.save(register);
            return true;
        } catch (Exception e) {
            System.out.print("");
            return false;
        }
    }
    public List<Register> getAllDetail()
    {
        return registerRepo.findAll();
    }
     public List<Register> getByPaginateSort(int offset, int pageSize, String field) {
        Page<Register> pg = registerRepo.findAll(PageRequest.of(offset, pageSize, Sort.by(field)));
        return pg.getContent();
    }
    public Register getProduct(int id) {
        return registerRepo.findById(id).orElse(null);
    }

    public boolean updateProduct(int id, Register register) {
        if (this.getProduct(id) == null) {
            return false;
        }
        try {
            registerRepo.save(register);
        } catch (Exception e) {
            return false;
        }
        return true;

    }
    public boolean deleteProduct(int id) {
        try {
            registerRepo.deleteById(id);
            return true;

        } catch (Exception e) {
            return false;
        }
    }
}
