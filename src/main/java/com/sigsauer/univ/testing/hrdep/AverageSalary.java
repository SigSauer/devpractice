package com.sigsauer.univ.testing.hrdep;

import java.util.*;

public class AverageSalary {

    public static int getAverageSalaryByDepartment(List<Employer> employers, String department) {
        int c = 0;
        int totalSalary = 0;
        for (Employer e: employers) {
            if(e.getDepartment().equals(department)) {
                totalSalary+=e.getSalary();
                c++;
            }
        }
        return c == 0 ? 0 : totalSalary/c;
    }
}
