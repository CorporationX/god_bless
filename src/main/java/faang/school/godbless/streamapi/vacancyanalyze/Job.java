package faang.school.godbless.streamapi.vacancyanalyze;

import java.time.LocalDate;
import java.util.List;

public record Job (String position, List<String> requirements, int salary, String location, LocalDate createdAt) {}
