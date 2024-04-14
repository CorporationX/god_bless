package faang.school.godbless.bjs2_5296;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
public class Student {

    private String firstName;
    private String lastName;
    private Map<String, List<Integer>> courses = new HashMap<>();

    public Student(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
