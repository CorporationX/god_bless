package school.faang.sprint_1.team_project_management;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class StrategyService {
    public static List<Employee> assignTeamService(Project project, List<Employee> employees) {
        Set<String> requiredSkills = new HashSet<>(project.getRequiredSkills());
        return employees.stream()
                .filter(employee
                        -> employee.getSkills()
                        .stream()
                        .anyMatch(requiredSkills::remove))
                .peek(employee -> employee.incrementProjectsAmount())
                .toList();
    }
}
