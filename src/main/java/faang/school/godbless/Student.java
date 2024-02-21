package faang.school.godbless;

import lombok.Data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Data
public class Student {
    private String firstName;
    private String lastName;
    private final Map<String, List<Integer>> courses = new HashMap<>();

}
