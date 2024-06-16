package faang.school.godbless.lamdbastreamapi.analyzator;

import java.time.LocalDate;
import java.util.List;

public record Job(String name, List<String> requirements, Long proposedSalary, String location, LocalDate date) {
}
