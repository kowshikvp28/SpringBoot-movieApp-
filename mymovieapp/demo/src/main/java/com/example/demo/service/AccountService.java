package com.example.demo.service;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.model.Account;
import com.example.demo.repository.AccountRepo;

@Service
public class AccountService {
    private AccountRepo accountRepo;

    public AccountService(AccountRepo accountRepo) {
        this.accountRepo = accountRepo;
    }

    public boolean storedetails(Account account) {
        try
        {
            accountRepo.save(account);
            return true;
        } catch (Exception e) {
            System.out.print("");
            return false;
        }
    }

    public List<Account> getAllDetail() {
        return accountRepo.findAll();
    }

     public List<Account> getByPaginateSort(int offset, int pageSize, String field) {
        Page<Account> pg = accountRepo.findAll(PageRequest.of(offset, pageSize, Sort.by(field)));
        return pg.getContent();
    }
}

