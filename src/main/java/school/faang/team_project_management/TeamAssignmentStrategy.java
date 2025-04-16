package school.faang.team_project_management;

import java.util.List;

public interface TeamAssignmentStrategy {
    public  List<Employee> assignTeam(Project project, List<Employee> employees);
}
