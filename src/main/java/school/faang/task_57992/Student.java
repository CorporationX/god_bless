package school.faang.task_57992;

import lombok.Getter;

import java.util.List;
import java.util.Map;

@Getter
public class Student {
    private final String firstName;
    private final String lastName;
    private final Map<String, List<Integer>> courses;

    public Student(String firstName, String lastName, Map<String, List<Integer>> coureses) {
        validateString(firstName, "First name");
        validateString(lastName, "Last name");
        validateCoureses(coureses, "Coureses");
        this.firstName = firstName;
        this.lastName = lastName;
        this.courses = coureses;
    }

    private void validateString(String name, String message) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException(message + " cant be null or blank");
        }
    }

    private void validateCoureses(Map<String, List<Integer>> coureses, String message) {
        if (coureses == null) {
            throw new IllegalArgumentException(message + " cant be null");
        }
    }
}