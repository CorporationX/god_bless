package school.faang.teammanagement;

import java.util.List;

public class StandardTeamAssignmentStrategy implements TeamAssignmentStrategy {

    @Override
    public List<Employee> assignTeam(Project project, List<Employee> employees) {
        return TeamAssignmentStrategy.assignTeamHelperMethod(project, employees);
    }
}
