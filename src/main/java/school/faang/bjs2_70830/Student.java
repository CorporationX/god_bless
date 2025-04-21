package school.faang.bjs2_70830;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Getter
@EqualsAndHashCode
@ToString
public class Student {
    private final String firstName;
    private final String lastName;
    private final Map<Subject, List<Integer>> courses;

    public Student(String firstName, String lastName, Map<Subject, List<Integer>> courses) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.courses = courses == null ? new HashMap<>() : courses;
    }
}
