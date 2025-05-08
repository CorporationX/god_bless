package school.faang.BJS2_68773;

import lombok.Getter;

import java.util.HashSet;
import java.util.Set;

@Getter
public class Employee {
    private final Long id;
    private final String name;
    private final Set<Skill> skills;
    private final Set<Project> projects;

    public Employee(Long id, String name, Set<Skill> skills) {
        this.id = id;
        this.name = name;
        this.skills = skills;
        this.projects = new HashSet<>();
    }
}
