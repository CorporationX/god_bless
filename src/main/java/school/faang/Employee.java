package school.faang;

import java.util.Set;

public class Employee {
    private final int id;
    private final String name;
    private final Set<String> skills;


    public Employee(int id, String name, Set<String> skills) {
        validateName(name);
        this.id = id;
        this.name = name;
        this.skills = skills;
    }

    private void validateName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("The employee name can't be null or blank");
        }
    }
}
