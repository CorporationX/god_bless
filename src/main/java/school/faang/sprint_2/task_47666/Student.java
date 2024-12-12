package school.faang.sprint_2.task_47666;

import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class Student {
    private String firstName;
    private String lastName;
    private Map<String, List<Integer>> subjects;
}
