package school.faang.bjs2_85817;

public class EmployeeProjectsCount {

    public static void incrementEmployeeProjectsCount(Employee employee) {
        employee.setProjectsCount(employee.getProjectsCount() + 1);
    }


    public static void subtractionEmployeeProjectsCount(Employee employee) {
        employee.setProjectsCount(employee.getProjectsCount() - 1);
    }
}
