package school.faang.bjs2_68908;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class StandardTeamAssignmentStrategy implements TeamAssignmentStrategy {
    @Override
    public List<Employee> assignTeam(Project project, List<Employee> employees) {
        Set<String> requiredSkills = project.getRequiredSkills();
        for (Employee employee : employees) {
            for (String skill : requiredSkills) {
                if (employee.getSkills().contains(skill)) {
                    acceptedEmployees.add(employee);
                    requiredSkills.remove(skill);
                    employee.projects.add(project);
                }
            }
        }
        return acceptedEmployees.stream().toList();
    }
}
