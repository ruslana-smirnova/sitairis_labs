package Entities;

public class Employee {
    private String passNumber;
    private String fullName;
    private int hours;
    private int salary;

    public Employee(String passNumber, String fullName, int hours, int salary) {
        this.passNumber = passNumber;
        this.fullName = fullName;
        this.hours = hours;
        this.salary = salary;
    }

    public String getPassNumber() {
        return passNumber;
    }

    public String getFullName() {
        return fullName;
    }

    public int getHours() {
        return hours;
    }

    public int getSalary() {
        return salary;
    }
}
