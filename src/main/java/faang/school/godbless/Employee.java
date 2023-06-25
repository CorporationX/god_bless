package faang.school.godbless;

public class Employee {
    private String name;
    private double wage;
    private String department;

    public Employee(String name, double wage, String department){
        this.name = name;
        this.wage = wage;
        this.department = department;
    }

    public String getName(){
        return name;
    }

    public double getWage() {
        return wage;
    }

    public String getDepartment() {
        return  department;
    }
}
