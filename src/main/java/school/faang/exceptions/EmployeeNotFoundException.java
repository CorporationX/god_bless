package school.faang.exceptions;

public class EmployeeNotFoundException extends RuntimeException {
    public EmployeeNotFoundException(int employeeId) {
        super("Employee with ID " + employeeId + " was not found.");
    }

    public EmployeeNotFoundException(int employeeId, String additionalInfo) {
        super("Employee with ID " + employeeId + " was not found. " + additionalInfo);
    }
}
