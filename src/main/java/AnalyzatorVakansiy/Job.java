package AnalyzatorVakansiy;

import java.time.LocalDate;
import java.util.List;

public class Job {
    private String name;
    private List<String> requirements;
    private double salary;
    private String location;
    private LocalDate vacancyDate;

    public Job(String name, List<String> requirements, double salary, String location, LocalDate vacancyDate) {
        this.name = name;
        this.requirements = requirements;
        this.salary = salary;
        this.location = location;
        this.vacancyDate = vacancyDate;
    }

    public String getName() {
        return name;
    }

    public List<String> getRequirements() {
        return requirements;
    }

    public double getSalary() {
        return salary;
    }

    public String getLocation() {
        return location;
    }

    public LocalDate getVacancyDate() {
        return vacancyDate;
    }

    @Override
    public String toString() {
        return "Job{" +
                "name='" + name + '\'' +
                ", requirements=" + requirements +
                ", salary=" + salary +
                ", location='" + location + '\'' +
                ", vacancyDate=" + vacancyDate +
                '}';
    }
}
