package com.example.demo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Register;
import com.example.demo.service.RegisterService;


@RestController
public class RegisterController {
    private RegisterService registerService;

    public RegisterController(RegisterService registerService) 
    {
        this.registerService = registerService;
    }
    @PostMapping("/api/post")
    public ResponseEntity<Register> showinfo(@RequestBody Register register) {
        if (registerService.storedetails(register))
        {
            return new ResponseEntity<>(register,HttpStatus.OK);
        } 
        else
        {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/get")
    public List<Register> getdetail()
    {
        return registerService.getAllDetail();
    }
    @GetMapping("/api/register/{offset}/{pagesize}/{field}")
    public ResponseEntity<List<Register>> getMethod(@PathVariable("offset") int offset,
            @PathVariable("pagesize") int pageSize, @PathVariable("field") String field) {
        List<Register> ch = registerService.getByPaginateSort(offset, pageSize, field);
        if (ch.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(ch, HttpStatus.OK);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Register> putMethodName(@PathVariable int id, @RequestBody Register register) {
        if (registerService.updateProduct(id, register) == true) {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Register> delMethod(@PathVariable int id) {
        if (registerService.deleteProduct(id))
        {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }
}
