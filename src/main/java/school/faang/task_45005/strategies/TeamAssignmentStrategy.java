package school.faang.task_45005.strategies;

import school.faang.task_45005.employee.Employee;
import school.faang.task_45005.project.Project;

import java.util.List;

public interface TeamAssignmentStrategy {
    List<Employee> assignTeam(Project project, List<Employee> employees);
}
