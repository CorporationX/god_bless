package school.faang.teammanagement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class StandardTeamAssignmentStrategy implements TeamAssignmentStrategy {

    @Override
    public List<Employee> assignTeam(Project project, List<Employee> employees) {
        List<Employee> approvedEmployees = new ArrayList<>();
        Set<String> requiredSkills = project.getRequiredSkills();

        for (Employee employee : employees) {
            if (!Collections.disjoint(employee.getSkills(), requiredSkills)) {
                approvedEmployees.add(employee);
                employee.getProjects().add(project);
            }
        }
        project.setTeamMembers(approvedEmployees);

        return approvedEmployees;
    }
}
