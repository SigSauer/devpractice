package com.sigsauer.univ.testing.hrdep;

import java.util.*;
import java.util.stream.Collectors;

/**
 *  @deprecated
 */
public class HRService {

    List<Employer> employers;

    public HRService(Employer... employers) {
        this.employers = new ArrayList<>(Arrays.asList(employers));
    }

    public List<Employer> getEmployersByDepartment(String department) {
        return employers.stream().filter(e -> e.getDepartment().equals(department)).collect(Collectors.toList());
    }

    public int getAverageSalaryByDepartment(String department) {
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
