package school.faang.sprint_2.task_47666;

import java.util.List;
import java.util.Map;

public record Student(String firstName, String lastName, Map<String, List<Integer>> subjects) {
}
