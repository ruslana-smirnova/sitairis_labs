package Entities;

import java.util.List;

public class Enterprise {
    private String name;
    private List<Administration> administration;
    private List<Employee> employees;

    public Enterprise() {}

    public Enterprise(String name, List<Administration> administration, List<Employee> employees) {
        this.name = name;
        this.administration = administration;
        this.employees = employees;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Administration> getAdministration() {
        return administration;
    }

    public void setAdministration(List<Administration> administration) {
        this.administration = administration;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public String toString() {
        return "Enterprise{" +
                "name='" + name + '\'' +
                ", administration=" + administration +
                ", employees=" + employees +
                '}';
    }
}
