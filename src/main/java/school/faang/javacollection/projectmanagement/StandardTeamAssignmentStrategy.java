package school.faang.javacollection.projectmanagement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class StandardTeamAssignmentStrategy implements TeamAssignmentStrategy {

    @Override
    public List<Employee> assignTeam(Project project, List<Employee> employees) {
        if (employees.isEmpty() || project.getRequiredSkills().isEmpty()) {
            return Collections.emptyList();
        }

        List<Employee> resultList = new ArrayList<>();
        Set<String> requiredSkills = new HashSet<>(project.getRequiredSkills());

        for (Employee employee : employees) {
            if (requiredSkills.removeAll(employee.getSkills())) {
                resultList.add(employee);
                incrementEmployeeProjectsCount(employee);
            }
            if (requiredSkills.isEmpty()) {
                return resultList;
            }
        }
        return resultList;
    }
}
