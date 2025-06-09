package school.faang.project.strategy;

import school.faang.project.domain.Employee;
import school.faang.project.domain.Project;

import java.util.Collection;

/**
 * @author Danil Pudovkin
 * @since 08.06.2025
 */
public class StandardTeamAssignmentStrategy implements TeamAssignmentStrategy {

    @Override
    public void assignTeam(Project project, Collection<Employee> employees) {
        var teamMembers = project.getTeamMembers();
        var requiredSkills = project.getRequiredSkills();
        for (var requiredSkill : requiredSkills) {
            for (var employee : employees) {
                var employeeSkills = employee.getSkills();
                if (employeeSkills.contains(requiredSkill)
                        && !teamMembers.contains(employee)) {
                    teamMembers.add(employee);
                    employee.getProjects().add(project);
                }
            }
        }
    }
}
