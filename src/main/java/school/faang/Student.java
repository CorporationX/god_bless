package school.faang;

import lombok.Getter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
public class Student {
    private final String firstName;
    private final String lastName;
    private final Map<String, List<Integer>> courses;

    public Student(String firstName, String lastName, Map<String, List<Integer>> courses) {
        validateName(firstName);
        validateName(lastName);
        validateCourses(courses);
        this.courses = new HashMap<>(courses);
        this.firstName = firstName;
        this.lastName = lastName;
    }

    private void validateName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name can't be null or empty.");
        }
    }

    private void validateCourses(Map<String, List<Integer>> courses) {
        if (courses == null) {
            throw new IllegalArgumentException("The courses Map can't be null.");
        }
        for (var entry : courses.entrySet()) {
            if (entry.getKey() == null) {
                throw new IllegalArgumentException("Subject can't be null.");
            } else if (entry.getValue() == null) {
                throw new IllegalArgumentException("List of grades can't be null.");
            }
        }
    }
}
