package faang.school.godbless.BJS2_23000;

import java.time.LocalDate;
import java.util.Map;

public interface JobDifference {
    Map<LocalDate, Difference> calculateDifference(
            LocalDate startDate, LocalDate endDate, Map<LocalDate, Difference> differencePerDay);
}
