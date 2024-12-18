package school.faang.task_46892;

public record Employee(String name, double salary, String department) {
    private static final String ERROR_MESSAGE = "Input parameters can't be null or empty!";

    public Employee {
        validateName(name);
        validateDepartment(department);
    }

    private static void validateName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }
    }

    private static void validateDepartment(String department) {
        if (department == null || department.isBlank()) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }
    }
}
