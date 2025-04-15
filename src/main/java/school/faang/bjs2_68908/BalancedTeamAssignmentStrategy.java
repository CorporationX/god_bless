package school.faang.bjs2_68908;

import java.util.Comparator;
import java.util.List;

public class BalancedTeamAssignmentStrategy implements TeamAssignmentStrategy {
    @Override
    public List<Employee> assignTeam(Project project, List<Employee> employees) {
        TeamAssignmentStrategy teamAssignmentStrategy = new StandardTeamAssignmentStrategy();
        employees.sort(Comparator.comparingInt(a -> a.projects.size()));
        return teamAssignmentStrategy.assignTeam(project, employees);
    }
}
