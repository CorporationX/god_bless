package school.faang.models;

import school.faang.exceptions.NoSuchCompanyException;

import java.util.HashMap;
import java.util.Map;

public class Company {
    private final int id;
    private final String companyName;
    private final int totalEmployees;
    private static final Map<Integer, String> companyById = new HashMap<>();
    private static final Map<String, Integer> employeesByCompanyName = new HashMap<>();

    public Company(int id, String companyName, int totalEmployees) {
        validateString(companyName, "Company name");
        validateTotalEmployees(totalEmployees);
        companyById.put(id, companyName);
        employeesByCompanyName.put(companyName, totalEmployees);

        this.id = id;
        this.companyName = companyName;
        this.totalEmployees = totalEmployees;
    }

    public static int getTotalEmployeesByCompanyName(String name) {
        if (!employeesByCompanyName.containsKey(name)) {
            throw new NoSuchCompanyException("No company with name " + name);
        }
        return employeesByCompanyName.get(name);
    }

    public static String getCompanyNameById(int id) {
        if (!companyById.containsKey(id)) {
            throw new NoSuchCompanyException("No company with id " + id);
        }
        return companyById.get(id);
    }

    private void validateString(String string, String message) {
        if (string == null || string.isBlank()) {
            throw new IllegalArgumentException(message + " can't be null or empty.");
        }
    }

    private void validateTotalEmployees(int totalEmployees) {
        if (totalEmployees < 0) {
            throw new IllegalArgumentException("Total employees can't be negative.");
        }
    }

}
