package com.sigsauer.univ.testing.hrdep;

import java.util.List;
import java.util.stream.Collectors;

public class DepartmentEmployers {

    public static List<Employer> getEmployersByDepartment(List<Employer> employers, String department) {
        return employers.stream().filter(e -> e.getDepartment().equals(department)).collect(Collectors.toList());
    }
}
