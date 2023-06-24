package faang.school.godbless.secondSprint.JobAnalyzer;

import java.time.LocalDateTime;
import java.util.List;

public record Job(String position, List<String> requirements, int salary, String location, LocalDateTime date) {
}
