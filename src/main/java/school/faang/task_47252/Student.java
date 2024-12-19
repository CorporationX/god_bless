package school.faang.task_47252;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;
import java.util.Map;

@Getter
@AllArgsConstructor
public class Student {
    public String firstName;
    public String lastName;
    public Map<String, List<Integer>> courses;
}
