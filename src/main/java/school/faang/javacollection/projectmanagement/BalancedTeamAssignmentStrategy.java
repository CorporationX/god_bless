package school.faang.javacollection.projectmanagement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class BalancedTeamAssignmentStrategy implements TeamAssignmentStrategy {

    @Override
    public List<Employee> assignTeam(Project project, List<Employee> employees) {
        if (employees.isEmpty() || project.getRequiredSkills().isEmpty()) {
            return Collections.emptyList();
        }

        List<Employee> resultList = new ArrayList<>();
        Set<String> requiredSkills = new HashSet<>(project.getRequiredSkills());

        Map<Integer, List<Employee>> groupedEmployeeByProjectsCount = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getProjectsCount,
                        TreeMap::new,
                        Collectors.toList()));

        for (var entry : groupedEmployeeByProjectsCount.entrySet()) {
            for (Employee employee : entry.getValue()) {
                if (requiredSkills.removeAll(employee.getSkills())) {
                    resultList.add(employee);
                    incrementEmployeeProjectsCount(employee);
                }
                if (requiredSkills.isEmpty()) {
                    return resultList;
                }
            }
        }

        return resultList;
    }
}
