package school.faang.sprint_1.task_44926.stratagy;

import school.faang.sprint_1.task_44926.entity.Employee;
import school.faang.sprint_1.task_44926.entity.Project;

import java.util.Set;

public interface TeamAssignmentStrategy {
    Set<Employee> assignTeam(Project project, Set<Employee> employees);
}
