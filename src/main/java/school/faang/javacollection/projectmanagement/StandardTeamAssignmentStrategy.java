package school.faang.javacollection.projectmanagement;

import java.util.Collections;
import java.util.List;

public class StandardTeamAssignmentStrategy extends AbstractTeamAssignmentStrategy {

    @Override
    public List<Employee> assignTeam(Project project, List<Employee> employees) {
        if (employees.isEmpty() || project.getRequiredSkills().isEmpty()) {
            return Collections.emptyList();
        }

        return findNecessaryEmployees(employees, project.getRequiredSkills());
    }
}
