package faang.school.godbless.eco_monitoring;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Stream;

public class DateStream {
    public static Stream<EnvironmentalImpact> getEnvironmentalImpactsInRange(List<EnvironmentalImpact> environmentalImpactList,
                                                                             LocalDate startDate, LocalDate endDate) {
        return environmentalImpactList.stream()
                .filter(impact -> impact.getDate().isAfter(startDate) || impact.getDate().isEqual(startDate))
                .filter(impact -> impact.getDate().isBefore(endDate.minusDays(1)) ||
                        impact.getDate().isEqual(endDate.minusDays(1)));
    }
}
