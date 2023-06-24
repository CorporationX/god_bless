package faang.school.godbless.E_diary;

import java.util.List;
import java.util.Map;

public record Student(String firstName, String lastName, Map<String, List<Integer>> courses) {
}
