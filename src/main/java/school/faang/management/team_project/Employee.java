package school.faang.management.team_project;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

@Getter
@EqualsAndHashCode
@ToString
public class Employee {
    private static final AtomicInteger idCounter = new AtomicInteger(1);

    private final int id;
    private final String name;
    private final Set<String> skills;
    private int projectCount = 0;

    public Employee(String name, Set<String> skills) {
        this.id = idCounter.getAndIncrement();
        this.name = name;
        this.skills = skills;
    }

    public void incrementProjectCount() {
        projectCount++;
    }

    public void decrementProjectCount() {
        projectCount = Math.max(0, projectCount - 1);
    }
}
