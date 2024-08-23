package faang.school.godbless.BJS2_22689;

import java.time.LocalDate;
import java.util.List;

public record Job(String position, List<String> requirements, int salary, String location, LocalDate createdAt) {

}
