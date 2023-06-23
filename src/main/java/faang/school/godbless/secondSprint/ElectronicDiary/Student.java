package faang.school.godbless.secondSprint.ElectronicDiary;

import java.util.List;
import java.util.Map;

public record Student(String firstName, String lastName, Map<String, List<Integer>> courses) {
}
