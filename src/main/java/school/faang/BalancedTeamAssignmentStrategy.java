package school.faang;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static school.faang.ProjectManager.PROJECTS_COUNT_BY_EMPLOYEE;

public class BalancedTeamAssignmentStrategy implements TeamAssignmentStrategy {

    @Override
    public List<Employee> assignTeam(Project project, List<Employee> employees) {
        if (project == null || project.requiredSkills() == null) {
            throw new IllegalArgumentException("Products and its required skills must not be null");
        }
        if (employees == null) {
            throw new IllegalArgumentException("Employees must not be null");
        }
        employees.sort(Comparator.comparingInt(employee -> PROJECTS_COUNT_BY_EMPLOYEE.getOrDefault(employee, 0)));
        return TeamAssignmentStrategy.super.assignTeam(project, employees);
    }
}
