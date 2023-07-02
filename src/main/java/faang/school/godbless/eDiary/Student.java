package faang.school.godbless.eDiary;

import lombok.Getter;
import lombok.Setter;

import java.util.*;
@Getter
@Setter

public class Student {
    private String firstName;
    private String lastName;
    private Map<String, List<Integer>> courses;

    public String getFullName() {
        return firstName + " " + lastName;
    }
}
