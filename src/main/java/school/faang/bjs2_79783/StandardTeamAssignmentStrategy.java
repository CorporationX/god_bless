package school.faang.bjs2_79783;

import java.util.Set;

public class StandardTeamAssignmentStrategy implements TeamAssignmentStrategy {

    @Override
    public void assignTeam(Project project, Set<Employee> employees) {
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
