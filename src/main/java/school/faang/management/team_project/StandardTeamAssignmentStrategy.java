package school.faang.management.team_project;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class StandardTeamAssignmentStrategy implements TeamAssignmentStrategy {

    @Override
    public List<Employee> assignTeam(Project project, List<Employee> employees) {
        List<Employee> assignedTeam = new ArrayList<>();
        Set<String> remainingSkills = new HashSet<>(project.getRequiredSkills());

        remainingSkills.removeAll(project.getCoveredSkills());

        for (Employee emp : employees) {
            if (remainingSkills.stream().anyMatch(skill -> emp.getSkills().contains(skill))) {
                assignedTeam.add(emp);
                remainingSkills.removeAll(emp.getSkills());
                if (remainingSkills.isEmpty()) {
                    break;
                }
            }
        }

        return assignedTeam;
    }
}
