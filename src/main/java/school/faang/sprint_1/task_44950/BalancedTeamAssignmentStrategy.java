package school.faang.sprint_1.task_44950;

import java.util.*;
import java.util.stream.Collectors;

public class BalancedTeamAssignmentStrategy implements TeamAssignmentStrategy {
    private final Map<Employee, Long> workload = new HashMap<>();

    @Override
    public List<Employee> assignTeam(Project project, List<Employee> employees) {
        Set<String> neededSkills = new HashSet<>(project.requiredSkills);
        return employees.stream()
                .filter(emp -> emp.skills.stream().anyMatch(neededSkills::contains))
                .sorted(Comparator.comparingLong(emp -> workload.getOrDefault(emp, 0L)))
                .peek(emp -> neededSkills.removeAll(emp.skills))
                .peek(emp -> workload.put(emp, workload.getOrDefault(emp, 0L) + 1))
                .limit(neededSkills.size())
                .collect(Collectors.toList());
    }
}
