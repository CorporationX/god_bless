package faang.school.godbless.sprint_2.stream_API.task_4_analizator.models;

import java.time.LocalDate;
import java.util.List;

public record Job (String position, List<String> requirements, int salary, String location, LocalDate dataAdded){
}
