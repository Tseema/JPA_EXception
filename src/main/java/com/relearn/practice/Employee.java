package com.relearn.practice;


import lombok.*;

@Data
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Employee {
    private int id;
    private String name;
    private String dept;
    private String status="active";
    private int salary;
}
