package school.faang.task_57992;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;
import java.util.Map;

@Getter
@AllArgsConstructor
public class Student {
    private final String firstName;
    private final String lastName;
    private final Map<String, List<Integer>> coureses;
}
