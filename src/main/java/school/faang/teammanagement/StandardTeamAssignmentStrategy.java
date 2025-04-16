package school.faang.teammanagement;

import java.util.List;

public class StandardTeamAssignmentStrategy implements TeamAssignmentStrategy {

    public List<Employee> assignTeam(Project project, List<Employee> employees) {
        return TeamAssignmentStrategy.super.assignTeam(project, employees);
    }
}
