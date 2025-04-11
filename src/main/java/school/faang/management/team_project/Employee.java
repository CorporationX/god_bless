package school.faang.management.team_project;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Set;

@Getter
@EqualsAndHashCode
@ToString
public class Employee {
    private static int idCounter = 1;

    private final int id = idCounter++;
    private final String name;
    @Setter
    private Set<String> skills;
    private int projectCount = 0;

    public Employee(String name, Set<String> skills) {
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
