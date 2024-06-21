package faang.school.godbless.task_4_analizator.models;

import java.time.LocalDate;
import java.util.List;

public record Job (String position, List<String> requirements, int salary, String location, LocalDate dataAdded){
}
