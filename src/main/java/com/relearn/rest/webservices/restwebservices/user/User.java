package com.relearn.rest.webservices.restwebservices.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

@Entity(name = "person_details")
public class User {

    @Size(min=2)
    //@JsonProperty("User_name")
    private String name ;

    @Id
    @GeneratedValue
    private Integer Id;

    @Past
    private LocalDate birth;

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", Id=" + Id +
                ", birth=" + birth +
                '}';
    }

    public User(String name, Integer id, LocalDate birth) {
        super();
        this.name = name;
        Id = id;
        this.birth = birth;
    }

    protected User() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public LocalDate getBirth() {
        return birth;
    }

    public void setBirth(LocalDate birth) {
        this.birth = birth;
    }


}
