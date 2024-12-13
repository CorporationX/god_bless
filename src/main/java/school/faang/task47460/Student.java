package school.faang.task47460;

import java.util.List;
import java.util.Map;

public record Student(String firstName, String lastName, Map<String, List<Integer>> subjects) {
}
