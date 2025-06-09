package school.faang.project.strategy;

import school.faang.project.domain.Employee;
import school.faang.project.domain.Project;

import java.util.Collection;

/**
 * @author Danil Pudovkin
 * @since 08.06.2025
 */
public class BalancedTeamAssignmentStrategy implements TeamAssignmentStrategy {

    private static final int MAX_PROJECTS_PER_EMPLOYEE = 3;

    @Override
    public void assignTeam(Project project, Collection<Employee> employees) {
        var teamMembers = project.getTeamMembers();
        var requiredSkills = project.getRequiredSkills();
        for (var requiredSkill : requiredSkills) {
            for (var employee : employees) {
                var employeeSkills = employee.getSkills();
                var employeeProjectNumber = employee.getProjects().size();
                if (employeeSkills.contains(requiredSkill)
                        && !teamMembers.contains(employee)
                        && employeeProjectNumber <= MAX_PROJECTS_PER_EMPLOYEE) {
                    teamMembers.add(employee);
                    employee.getProjects().add(project);
                }
            }
        }
    }
}
