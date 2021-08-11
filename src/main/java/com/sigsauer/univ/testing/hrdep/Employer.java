package com.sigsauer.univ.testing.hrdep;

public class Employer {
    private String name;
    private String department;
    private String position;
    private int salary;

    public Employer(String name, String department, String position, int salary) {
        this.name = name;
        this.department = department;
        this.position = position;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public int getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Employer{" +
                "name='" + name + '\'' +
                ", department='" + department + '\'' +
                ", position='" + position + '\'' +
                ", salary=" + salary +
                '}';
    }
}
