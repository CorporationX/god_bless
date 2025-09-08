package school.faang.javacollection.projectmanagement;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class StandardTeamAssignmentStrategy extends AbstractTeamAssignmentStrategy {

    @Override
    public List<Employee> assignTeam(Project project, List<Employee> employees) {
        if (employees.isEmpty() || project.getRequiredSkills().isEmpty()) {
            return Collections.emptyList();
        }

        Set<String> requiredSkills = new HashSet<>(project.getRequiredSkills());

        return super.findNecessaryEmployees(employees, requiredSkills);
    }
}
