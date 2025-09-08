package school.faang.module1.employee;

import java.util.ArrayList;
import java.util.List;

public class StandardTeamAssignmentStrategy implements TeamAssignmentStrategy {

    @Override
    public List<Employee> assignTeam(Project project, List<Employee> employees) {
        List<Employee> teamMembers = new ArrayList<>();

        project.getRequiredSkills()
                .forEach(skill -> employees.forEach(employee -> {
                    if (employee.skills().contains(skill) && !teamMembers.contains(employee)) {
                        teamMembers.add(employee);
                    }
                }));

        project.setTeamMembers(teamMembers);
        return teamMembers;
    }
}
