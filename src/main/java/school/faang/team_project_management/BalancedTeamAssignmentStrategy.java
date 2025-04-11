package school.faang.team_project_management;

import java.util.Comparator;
import java.util.List;

import static school.faang.team_project_management.StrategyService.assignTeamService;

public class BalancedTeamAssignmentStrategy implements TeamAssignmentStrategy {
    @Override
    public List<Employee> assignTeam(Project project, List<Employee> employees) {
        employees.stream().sorted(Comparator.comparingInt(Employee::getProjectsAmount));
        return assignTeamService(project, employees);
    }
}
