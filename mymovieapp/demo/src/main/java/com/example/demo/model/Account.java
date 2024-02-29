package com.example.demo.model;



import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;

import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
// import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Account {
    @Id
    private int id;
    private String name;
    private String dob;
    private String gender,address;
    @JsonBackReference
    @OneToOne()
    @JoinColumn(name = "sc_id")
    private Register register;
}