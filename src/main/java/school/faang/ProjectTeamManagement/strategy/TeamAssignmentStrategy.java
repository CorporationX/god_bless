package school.faang.ProjectTeamManagement.strategy;

import school.faang.ProjectTeamManagement.model.Employee;
import school.faang.ProjectTeamManagement.model.Project;

import java.util.List;

public interface TeamAssignmentStrategy {
    List<Employee> assignTeam(Project project, List<Employee> employees);
}
