package faang.school.godbless;

import lombok.Getter;

import java.util.List;
import java.util.Map;

@Getter
public class Student {
    private String firstName;
    private String lastName;
    private Map<String, List<Integer>> courses;

    public Student(String firstName, String lastName, Map<String, List<Integer>> courses) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.courses = courses;
    }
}
