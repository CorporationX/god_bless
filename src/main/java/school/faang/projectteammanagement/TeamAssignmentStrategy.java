package school.faang.projectteammanagement;

import java.util.List;

public interface TeamAssignmentStrategy {
    List<Employee> assignTeam(Project project, List<Employee> employees);
}
