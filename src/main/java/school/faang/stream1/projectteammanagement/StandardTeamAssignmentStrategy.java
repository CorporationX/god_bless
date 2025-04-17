package school.faang.stream1.projectteammanagement;

import java.util.List;

public class StandardTeamAssignmentStrategy implements TeamAssignmentStrategy {
    @Override
    public List<Employee> assignTeam(Project project, List<Employee> employees) {
        return TeamAssignmentStrategy.coverAllSkills(project.getRequiredSkills(), employees);
    }
}
