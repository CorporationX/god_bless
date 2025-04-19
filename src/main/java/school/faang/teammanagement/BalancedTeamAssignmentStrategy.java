package school.faang.teammanagement;

import lombok.Data;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Data
public class BalancedTeamAssignmentStrategy implements TeamAssignmentStrategy {

    private final Set<Project> projects;

    @Override
    public List<Employee> assignTeam(Project project, List<Employee> employees) {
        Set<Employee> noDuplicatesEmployees = new HashSet<>(employees);
        Map<Employee, Integer> relevantEmployeesMap = new HashMap<>();

        for (Employee employee : noDuplicatesEmployees) {
            if (employee.getSkills().stream().noneMatch(skill -> project.getRequiredSkills().contains(skill))) {
                continue;
            }
            int load = 0;
            for (Project currentProject : projects) {
                if (currentProject.getTeamMembers().contains(employee)) {
                    load++;
                }
            }
            relevantEmployeesMap.put(employee, load);
        }
        List<Employee> sortedByLoadEmployees = relevantEmployeesMap.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey).toList();
        return TeamAssignmentStrategy.assignTeamHelperMethod(project, sortedByLoadEmployees);
    }
}
