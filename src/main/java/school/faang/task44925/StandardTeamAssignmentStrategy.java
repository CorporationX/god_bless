package school.faang.task44925;

import java.util.ArrayList;
import java.util.List;

public class StandardTeamAssignmentStrategy implements TeamAssignmentStrategy {
    @Override
    public List<Employee> assignTeam(Project project, List<Employee> employees) {
        validation(project, employees);
        List<Employee> assignedEmployees = new ArrayList<>();

        for (var employee : employees) {
            for (var skill : employee.getSkills()) {
                if (project.getRequiredSkills().contains(skill)) {
                    assignedEmployees.add(employee);
                    break;
                }
            }
        }

        if (assignedEmployees.isEmpty()) {
            throw new IllegalArgumentException("Not a single employee has been added");
        }

        return assignedEmployees;
    }
}
