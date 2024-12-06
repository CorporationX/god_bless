package school.faang.task44925;

import java.util.List;

public interface TeamAssignmentStrategy {
    default void validation(Project project, List<Employee> employees) {
        if (project == null) {
            throw new IllegalArgumentException("Project cannot be null");
        }
        if (employees == null) {
            throw new IllegalArgumentException("Employees cannot be null");
        }
    }

    List<Employee> assignTeam(Project project, List<Employee> employees);
}
