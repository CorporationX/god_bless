package school.faang.javacollection.projectmanagement;

public class EmployeeProjectsCount {
    public static void incrementEmployeeProjectsCount(Employee employee) {
        employee.setProjectsCount(employee.getProjectsCount() + 1);
    }

    public static void decrementEmployeeProjectsCount(Employee employee) {
        employee.setProjectsCount(employee.getProjectsCount() - 1);
    }
}
