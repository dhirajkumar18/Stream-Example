package com.test.java8.stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Employee> employeeList= Arrays.asList(new Employee(1,"dhiraj",50000,"male"),
                new Employee(2,"priya",60000,"female"),
        new Employee(3,"ramesh",80000,"male"),
        new Employee(4,"vipin",30000,"male"),
        new Employee(5,"neha",67000,"female"),
        new Employee(6,"varsha",69000,"female"));
        List<Employee> newelist=employeeList.stream().sorted(Comparator.comparing(Employee::getSalary).reversed()).skip(1).findFirst().stream().toList();

        System.out.println(newelist);
        Map<String, Long> map=employeeList.stream().collect(Collectors.groupingBy(Employee::getGender,Collectors.counting()));
        System.out.println(map);
        double totalsalary=employeeList.stream().mapToDouble(Employee::getSalary).sum();
        System.out.println(totalsalary);

        Map<String,Double> map1=employeeList.stream().collect(Collectors
                .toMap(n -> n.getName().substring(0,1).toUpperCase()+n.getName().substring(1).toLowerCase()
                ,Employee::getSalary));
        System.out.println(map1);
    }
}
