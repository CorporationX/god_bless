package school.faang.task_45005.strategies;

import school.faang.task_45005.employee.Employee;
import school.faang.task_45005.project.Project;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class BalancedTeamAssignmentStrategy implements TeamAssignmentStrategy {
    @Override
    public List<Employee> assignTeam(Project project, List<Employee> employees) {
        List<Employee> team = new ArrayList<>();
        Set<String> requiredSkills = new HashSet<>(project.getRequiredSkills());

        Map<Employee, Long> projectCounts = employees.stream()
                .collect(Collectors.toMap(
                        employee -> employee,
                        employee -> project.getTeamMembers().stream()
                                .filter(member -> member.equals(employee))
                                .count()
                ));

        List<Employee> sortedEmployees = employees.stream()
                .sorted(Comparator.comparing(projectCounts::get))
                .toList();

        for (Employee employee : sortedEmployees) {
            if (requiredSkills.isEmpty()) {
                break;
            }

            if (project.getTeamMembers().contains(employee)) {
                continue;
            }

            Set<String> employeeSkills = employee.getSkills();
            Set<String> matchingSkills = new HashSet<>(employeeSkills);
            matchingSkills.retainAll(requiredSkills);

            if (!matchingSkills.isEmpty()) {
                team.add(employee);
                requiredSkills.removeAll(matchingSkills);
            }
        }

        return team;
    }
}
