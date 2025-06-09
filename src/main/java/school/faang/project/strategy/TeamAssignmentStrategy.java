package school.faang.project.strategy;

import school.faang.project.domain.Employee;
import school.faang.project.domain.Project;

import java.util.Collection;

/**
 * @author Danil Pudovkin
 * @since 08.06.2025
 */
public interface TeamAssignmentStrategy {
    void assignTeam(Project project, Collection<Employee> employees);
}
