package school.faang.sprint_2.task_46716.entity;

import lombok.Data;

import java.util.concurrent.atomic.AtomicInteger;

@Data
public class Company {
    private static final AtomicInteger idCounter = new AtomicInteger(1);

    private final int id;
    private final String companyName;
    private final int totalEmployees;

    public Company(String companyName, int totalEmployees) {
        this.id = idCounter.getAndIncrement();
        this.companyName = companyName;
        this.totalEmployees = totalEmployees;
    }

    public Company(int id, String companyName, int totalEmployees) {
        this.id = id;
        idCounter.set(id + 1);

        this.companyName = companyName;
        this.totalEmployees = totalEmployees;
    }
}
