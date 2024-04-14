package com.relearn.practice;

import java.sql.SQLOutput;
import java.util.*;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

public class EmployeeQuery {

    public static void main(String[] args){
        List<Employee> list = new ArrayList<>();
        list.add(new Employee(1,"dad","mag","active",12345));
        list.add(new Employee(2,"mom","house","passive",12344));
        list.add(new Employee(3,"shilpa","mag","active",12343));
        list.add(new Employee(4,"shru","house","active",12342));
        list.add(new Employee(5,"me","mag","passive",12341));

       /* findnthhighestsalary(list,3);
        deptwiseemp(list);
        statuswise(list,"active");
        countactive(list);
        MaxSalaryDept(list);
        Averagesalaryofdept(list);
        MinSalaryDeptwise(list);*/
        longestname(list);
    }

    private static void longestname(List<Employee> list) {
        String s = list.stream().map(employee -> employee.getName()).
                reduce((name1, name2) -> name1.length() > name2.length() ? name1 : name2).get();
        //String s1 = list.stream().map(employee -> employee.getName()).sorted(Collections.reverseOrder()).findFirst().get();
        System.out.println(s);
    }

    private static void MinSalaryDeptwise(List<Employee> list) {
        Map<String, Optional<Employee>> collect = list.stream().collect(Collectors.groupingBy(Employee::getDept,
                Collectors.reducing(BinaryOperator.minBy(Comparator.comparing(Employee::getSalary)))));

        collect.entrySet().forEach(set->
        {
            System.out.println(" dept " + set.getKey());
            System.out.println(" min salary  " + set.getValue().stream().toList());
        });
    }

    private static void Averagesalaryofdept(List<Employee> list) {
        System.out.println(list.stream().collect(Collectors.groupingBy(Employee::getDept,
                Collectors.averagingInt(Employee::getSalary))));
    }

    private static void MaxSalaryDept(List<Employee> list) {
        Map<String, Optional<Employee>> collect = list.stream().collect(Collectors.groupingBy(Employee::getDept,
                Collectors.reducing(BinaryOperator.maxBy(Comparator.comparing(Employee::getSalary)))
        ));

        System.out.println(collect.entrySet().stream().filter(set-> set.getKey().
                equalsIgnoreCase("mag")).collect(Collectors.toList()));

        collect.entrySet().forEach(key->
        {
            System.out.println("Dept  "+ key.getKey());
            System.out.println("salary   " + key.getValue());
        });

    }

    private static void countactive(List<Employee> list) {
        System.out.println(list.stream().filter(emp->emp.getStatus().
                equalsIgnoreCase("active")).count());
    }

    private static void statuswise(List<Employee> list, String active) {
        System.out.println(list.stream().filter(emp->emp.getStatus().
                equalsIgnoreCase(active)).collect(Collectors.toList()));
    }

    private static void deptwiseemp(List<Employee> list) {
        System.out.println(list.stream().collect(Collectors.groupingBy(Employee::getDept,Collectors.toList()))

        );
    }

    private static void findnthhighestsalary(List<Employee> list, int n) {
        System.out.println(list.stream().map(emp->emp.getSalary()).sorted(Collections.
                reverseOrder())
                        .skip(n-1)
                        .findFirst().get()
                );

    }
}
