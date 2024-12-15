package school.faang.sprint_2.task_47167;

import java.util.Date;
import java.util.List;

public record Job(String position, List<String> requirements, int salary, String location, Date datePosted) {
}
