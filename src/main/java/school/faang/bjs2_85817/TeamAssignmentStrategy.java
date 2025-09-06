package school.faang.bjs2_85817;

import java.util.List;

public interface TeamAssignmentStrategy {
    public List<Employee> assignTeam(Project project, List<Employee> employees);

    default void incrementEmployeeProjectsCount(Employee employee) {
        employee.setProjectsCount(employee.getProjectsCount() + 1);
    }
}
