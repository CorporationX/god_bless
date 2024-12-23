package school.faang.sprint_1.task_44950;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class StandardTeamAssignmentStrategy implements TeamAssignmentStrategy {
    @Override
    public List<Employee> assignTeam(Project project, List<Employee> employees) {
        Set<String> neededSkills = new HashSet<>(project.requiredSkills);
        return employees.stream()
                .filter(emp -> {
                    boolean matches = emp.skills.stream().anyMatch(neededSkills::contains);
                    if (matches) {
                        neededSkills.removeAll(emp.skills);
                    }
                    return matches;
                })
                .collect(Collectors.toList());
    }
}
