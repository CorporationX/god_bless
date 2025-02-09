package school.faang.strategies;

import school.faang.models.Employee;
import school.faang.models.Project;

import java.util.List;

public interface TeamAssignmentStrategy {
    List<Employee> assignTeam(Project project, List<Employee> employees);
}
