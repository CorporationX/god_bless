package school.faang.javacollection.projectmanagement;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class BalancedTeamAssignmentStrategy extends AbstractTeamAssignmentStrategy {

    @Override
    public List<Employee> assignTeam(Project project, List<Employee> employees) {
        if (employees.isEmpty() || project.getRequiredSkills().isEmpty()) {
            return Collections.emptyList();
        }

        List<Employee> sortedEmployeeByProjectsCount = employees.stream()
                .sorted(Comparator.comparingInt(Employee::getProjectsCount))
                .toList();

        return findNecessaryEmployees(sortedEmployeeByProjectsCount, project.getRequiredSkills());
    }
}
