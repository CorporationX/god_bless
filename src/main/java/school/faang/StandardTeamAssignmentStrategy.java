package school.faang;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class StandardTeamAssignmentStrategy implements TeamAssignmentStrategy {

    @Override
    public List<Employee> assignTeam(Project project, List<Employee> employees) {
        if (project == null || project.requiredSkills() == null) {
            throw new IllegalArgumentException("Products and its required skills must not be null");
        }
        if (employees == null) {
            throw new IllegalArgumentException("Employees must not be null");
        }
        return TeamAssignmentStrategy.super.assignTeam(project, employees);
    }
}
