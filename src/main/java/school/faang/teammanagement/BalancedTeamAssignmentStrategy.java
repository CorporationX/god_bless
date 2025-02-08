package school.faang.teammanagement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class BalancedTeamAssignmentStrategy implements TeamAssignmentStrategy {

    @Override
    public List<Employee> assignTeam(Project project, List<Employee> employees) {
        List<Employee> approvedEmployees = new ArrayList<>();
        Set<String> requiredSkills = project.getRequiredSkills();

        for (Employee employee : employees) {
            List<Project> employeeProjects = employee.getProjects();
            if (!Collections.disjoint(employee.getSkills(), requiredSkills)
                    && employeeProjects.size() < Employee.MAX_PROJECTS_COUNT) {
                approvedEmployees.add(employee);
                employee.getProjects().add(project);
            }
        }
        project.setTeamMembers(approvedEmployees);

        return approvedEmployees;
    }
}
