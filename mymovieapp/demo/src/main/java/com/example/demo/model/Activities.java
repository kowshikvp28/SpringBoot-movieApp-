package com.example.demo.model;



import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;

import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
// import jakarta.persistence.ManyToOne;
// import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Activities {
    @Id
    private int id;
    private String favorie;
    private String recent;
    private String liked;
    @JsonBackReference
    @ManyToOne()
    @JoinColumn(name = "reg_id")
    private Register register;
}