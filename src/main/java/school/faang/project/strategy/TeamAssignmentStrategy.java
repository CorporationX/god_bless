package school.faang.project.strategy;

import school.faang.project.domain.Employee;
import school.faang.project.domain.Project;

import java.util.Set;

/**
 * @author Danil Pudovkin
 * @since 08.06.2025
 */
public interface TeamAssignmentStrategy {
    void assignTeam(Project project, Set<Employee> employees);
}
