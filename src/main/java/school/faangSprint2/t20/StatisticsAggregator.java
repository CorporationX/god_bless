package school.faangSprint2.t20;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StatisticsAggregator {
    public Map<String, Double> aggregateEmissions(
            LocalDate startDate,
            LocalDate endDate,
            List<EnvironmentalImpact> impacts,
            String impactType) {

        return impacts.stream()
                .filter(impact -> !impact.getDate().isBefore(startDate)
                        && !impact.getDate().isAfter(endDate)
                        && impact.getType().equals(impactType))
                .collect(Collectors.groupingBy(
                        EnvironmentalImpact::getCompanyId,
                        Collectors.summingDouble(EnvironmentalImpact::getVolume)
                ));
    }
}