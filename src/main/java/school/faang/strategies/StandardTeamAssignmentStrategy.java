package school.faang.strategies;

import school.faang.models.Employee;
import school.faang.models.Project;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class StandardTeamAssignmentStrategy implements TeamAssignmentStrategy {
    @Override
    public List<Employee> assignTeam(Project project, List<Employee> employees) {
        List<Employee> assigned = new ArrayList<>();
        Set<String> requiredSkills = new HashSet<>(project.getRequiredSkills());

        for (Employee employee : employees) {
            Set<String> commonSkills = new HashSet<>(project.getRequiredSkills());
            commonSkills.retainAll(requiredSkills);
            if (!commonSkills.isEmpty()) {
                assigned.add(employee);
                employee.setAssignedProjects(employee.getAssignedProjects() + 1);
                requiredSkills.retainAll(commonSkills);
            }
            if (requiredSkills.isEmpty()) {
                break;
            }
        }
        return assigned;
    }
}
