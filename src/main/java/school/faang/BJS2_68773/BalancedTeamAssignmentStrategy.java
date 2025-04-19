package school.faang.BJS2_68773;

import java.util.Comparator;
import java.util.List;

public class BalancedTeamAssignmentStrategy extends AbstractTeamAssignmentStrategy {

    @Override
    public List<Employee> assignTeam(Project project, List<Employee> employees) {
        if (project == null || project.getRequiredSkills() == null) {
            throw new IllegalArgumentException("Products and its required skills must not be null");
        }
        if (employees == null) {
            throw new IllegalArgumentException("Employees must not be null");
        }
        return assignTeamDefault(project, employees,
                Comparator.comparingInt(employee -> employee.getProjects().size()));
    }
}
