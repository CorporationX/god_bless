package school.faang.javacollection.projectmanagement;

import java.util.List;

public interface TeamAssignmentStrategy {
    List<Employee> assignTeam(Project project, List<Employee> employees);

    default void incrementEmployeeProjectsCount(Employee employee) {
        employee.setProjectsCount(employee.getProjectsCount() + 1);
    }
}
