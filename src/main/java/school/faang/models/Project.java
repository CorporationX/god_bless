package school.faang.models;

import lombok.Getter;
import lombok.ToString;

import java.util.Set;

@ToString
@Getter
public class Project {
    private final int projectId;
    private final String name;
    private final Set<String> requiredSkills;
    private final Set<Employee> teamMembers;

    public Project(int projectId, String name, Set<String> requiredSkills, Set<Employee> teamMembers) {
        validateName(name);
        validateRequiredSkills(requiredSkills);
        validateTeamMembers(teamMembers);
        this.projectId = projectId;
        this.name = name;
        this.requiredSkills = requiredSkills;
        this.teamMembers = teamMembers;
    }

    private void validateName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("The project name can't be null or blank");
        }
    }

    private void validateEmployee(Employee employee) {
        if (employee == null) {
            throw new IllegalArgumentException("The employee in teamMembers can't be null");
        }
    }

    private void validateRequiredSkills(Set<String> requiredSkills) {
        if (requiredSkills == null) {
            throw new IllegalArgumentException("The requiredSkills can't be null");
        }
        for (String requiredSkill : requiredSkills) {
            if (requiredSkill == null || requiredSkill.isBlank()) {
                throw new IllegalArgumentException("The required skill in project can't be null or blank");
            }
        }
    }

    private void validateTeamMembers(Set<Employee> teamMembers) {
        if (teamMembers == null) {
            throw new IllegalArgumentException("The teamMembers can't be null");
        }
        for (Employee employee : teamMembers) {
            validateEmployee(employee);
        }
    }
}
