package school.faang.team_project_management;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class StrategyService {
    public static List<Employee> assignTeamService(Project project, List<Employee> employees) {
        Set<String> requiredSkills = new HashSet<>(project.getRequiredSkills());
        return employees.stream()
                .filter(employee
                        -> employee.getSkills()
                        .stream()
                        .anyMatch(requiredSkills::remove))
                .peek(employee -> employee.incrementProjectsAmount())
                .collect(Collectors.toList());
    }
}
