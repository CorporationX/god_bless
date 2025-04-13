package school.faang;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static school.faang.ProjectManager.PROJECTS_COUNT_BY_EMPLOYEE;

public interface TeamAssignmentStrategy {

    default List<Employee> assignTeam(Project project, List<Employee> employees) {
        List<Employee> teamEmployees = new ArrayList<>();
        Set<String> projectRequiredSkills = new HashSet<>(project.requiredSkills());
        for (Employee employee : employees) {
            if (!Collections.disjoint(employee.skills(), projectRequiredSkills)) {
                projectRequiredSkills.removeAll(employee.skills());
                PROJECTS_COUNT_BY_EMPLOYEE.put(employee, PROJECTS_COUNT_BY_EMPLOYEE.getOrDefault(employee, 0) + 1);
                teamEmployees.add(employee);
            }
            if (projectRequiredSkills.isEmpty()) {
                break;
            }
        }
        return teamEmployees;
    }
}
