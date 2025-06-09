package school.faang.bjs2_79783;

import java.util.Set;

public class BalancedTeamAssignmentStrategy implements TeamAssignmentStrategy {

    private static final int MAX_PROJECTS_PER_EMPLOYEE = 3;

    @Override
    public void assignTeam(Project project, Set<Employee> employees) {
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
