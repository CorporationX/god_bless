package school.faang.javacollection.projectmanagement;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BalancedTeamAssignmentStrategy extends AbstractTeamAssignmentStrategy {

    @Override
    public List<Employee> assignTeam(Project project, List<Employee> employees) {
        if (employees.isEmpty() || project.getRequiredSkills().isEmpty()) {
            return Collections.emptyList();
        }

        Set<String> requiredSkills = new HashSet<>(project.getRequiredSkills());

        List<Employee> sortedEmployeeByProjectsCount = employees.stream()
                .sorted(Comparator.comparingInt(Employee::getProjectsCount))
                .toList();

        return super.findNecessaryEmployees(sortedEmployeeByProjectsCount, requiredSkills);
    }
}
