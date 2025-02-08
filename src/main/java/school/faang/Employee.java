package school.faang;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Set;

@ToString
@Getter
@Setter
public class Employee {
    private final int id;
    private int assignedProjects;
    private final String name;
    private final Set<String> skills;

    public Employee(int id, int assignedProjects, String name, Set<String> skills) {
        validateName(name);
        validateAssignedProjects(assignedProjects);
        validateSkills(skills);
        this.id = id;
        this.name = name;
        this.skills = skills;
        this.assignedProjects = assignedProjects;
    }

    private void validateName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("The employee name can't be null or blank");
        }
    }

    private void validateAssignedProjects(int assignedProjects) {
        if (assignedProjects < 0) {
            throw new IllegalArgumentException("The assignedProjects can't be less than 0");
        }
    }

    private void validateSkills(Set<String> skills) {
        if (skills == null) {
            throw new IllegalArgumentException("The set of skills can't be null");
        }
        for (String skill : skills) {
            if (skill == null || skill.isBlank()) {
                throw new IllegalArgumentException("The skill can't be null or blank");
            }
        }
    }
}
