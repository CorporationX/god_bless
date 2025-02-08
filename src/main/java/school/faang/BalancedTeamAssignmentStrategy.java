package school.faang;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BalancedTeamAssignmentStrategy implements TeamAssignmentStrategy {
    private static final int MAX_PROJECTS_PER_EMPLOYEE = 3;

    @Override
    public List<Employee> assignTeam(Project project, List<Employee> employees) {
        List<Employee> assigned = new ArrayList<>();
        Set<String> requiredSkills = new HashSet<>(project.getRequiredSkills());
        employees.sort(Comparator.comparingInt(Employee::getAssignedProjects));

        for (Employee employee : employees) {
            if (employee.getAssignedProjects() > MAX_PROJECTS_PER_EMPLOYEE) {
                continue;
            }
            Set<String> commonSkills = new HashSet<>(project.getRequiredSkills());
            commonSkills.retainAll(requiredSkills);
            if (!commonSkills.isEmpty()) {
                assigned.add(employee);
                employee.setAssignedProjects(employee.getAssignedProjects() + 1);
                requiredSkills.removeAll(commonSkills);
            }
            if (requiredSkills.isEmpty()) {
                break;
            }
        }
        return assigned;
    }
}
