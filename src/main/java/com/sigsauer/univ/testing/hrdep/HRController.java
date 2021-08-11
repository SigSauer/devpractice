package com.sigsauer.univ.testing.hrdep;

import java.util.*;

//LR 11
public class HRController {

        public static void main(String[] args) {
            List<Employer> employers = Arrays.asList(
                new Employer("Johnson", "IT", "Junior", 1000),
                new Employer("Ivanov", "IT", "Middle", 2000),
                new Employer("Alekseiev", "IT", "Senior", 5000),
                new Employer("Romanov", "IT", "Middle", 2500),
                new Employer("Bogdanov", "HR", "Chief", 4000),
                new Employer("Petrov", "HR", "Assistant", 1500),
                new Employer("Kovalev", "HR", "Operator", 1000)
            );

            System.out.println("Department: IT");
            System.out.println(DepartmentEmployers.getEmployersByDepartment(employers,"IT").toString());

            System.out.println("\nAverage salary fot department IT is: "+
                     AverageSalary.getAverageSalaryByDepartment(employers,"IT"));

        }
}
