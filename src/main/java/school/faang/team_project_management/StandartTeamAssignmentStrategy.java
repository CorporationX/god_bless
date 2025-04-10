package school.faang.team_project_management;

import java.util.List;

import static school.faang.team_project_management.StrategyService.assignTeamService;

public class StandartTeamAssignmentStrategy implements TeamAssignmentStrategy {
    @Override
    public List<Employee> assignTeam(Project project, List<Employee> employees) {
        return assignTeamService(project, employees);
    }
}
