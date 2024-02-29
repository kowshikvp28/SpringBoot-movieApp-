package com.example.demo.controller;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.model.Account;
import com.example.demo.service.AccountService;
@RestController
public class AccountController 
{
    private AccountService accountService;
    public AccountController(AccountService accountService)
    {
        this.accountService = accountService;
    }
    @PostMapping("/api/posts")
    public ResponseEntity<Account> showinfo(@RequestBody Account account)
    {
        if (accountService.storedetails(account))
        {
            return new ResponseEntity<>(account,HttpStatus.OK);
        } 
        else
        {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/gets")
    public List<Account> getdetail()
    {
       return accountService.getAllDetail();
    }
    @GetMapping("/api/account/{offset}/{pagesize}/{field}")
    public ResponseEntity<List<Account>> getMethod(@PathVariable("offset") int offset,
            @PathVariable("pagesize") int pageSize, @PathVariable("field") String field) {
        List<Account> ch = accountService.getByPaginateSort(offset, pageSize, field);
        if (ch.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(ch, HttpStatus.OK);
    }
    
}

