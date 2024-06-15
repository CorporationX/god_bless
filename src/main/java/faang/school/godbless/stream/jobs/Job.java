package faang.school.godbless.stream.jobs;

import java.time.LocalDate;
import java.util.List;

public record Job(String title,
                  List<String> reqs,
                  double offeredSalary,
                  String location,
                  LocalDate dateAdded) {
}
