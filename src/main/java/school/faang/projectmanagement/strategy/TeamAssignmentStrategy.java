package school.faang.projectmanagement.strategy;

import school.faang.projectmanagement.Employee;
import school.faang.projectmanagement.Project;

import java.util.List;

public interface TeamAssignmentStrategy {
    List<Employee> assignTeam(Project project, List<Employee> employees);
}