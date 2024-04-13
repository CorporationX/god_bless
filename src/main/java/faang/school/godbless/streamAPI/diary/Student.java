package faang.school.godbless.streamAPI.diary;

import lombok.Data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class Student {
    private String firstName;
    private String lastName;
    private Map<String, List<Integer>> courses;

    public Student(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;

        courses = new HashMap<>();
    }
}
