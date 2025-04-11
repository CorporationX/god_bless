package school.faang.management.team_project;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BalancedTeamAssignmentStrategy implements TeamAssignmentStrategy {
    @Override
    public List<Employee> assignTeam(Project project, List<Employee> employees) {
        List<Employee> assignedTeam = new ArrayList<>();
        Set<String> remainingSkills = new HashSet<>(project.getRequiredSkills());

        remainingSkills.removeAll(project.getCoveredSkills());

        List<Employee> candidates = employees.stream()
                .filter(employee -> !project.getTeamMembers().contains(employee))
                .sorted(Comparator.comparingInt(Employee::getProjectCount))
                .toList();

        for (Employee employee : candidates) {
            if (remainingSkills.stream().anyMatch(skill -> employee.getSkills().contains(skill))) {
                assignedTeam.add(employee);
                remainingSkills.removeAll(employee.getSkills());
                if (remainingSkills.isEmpty()) {
                    break;
                }
            }
        }

        return assignedTeam;
    }
}
