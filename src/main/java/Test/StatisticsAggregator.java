package Test;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class StatisticsAggregator {
    public Map<String, Double> aggregateEnvironmentalImpactsByCompanyAndType(
            LocalDate startDate, LocalDate endDate, List<EnvironmentalImpact> impacts, EnvironmentalImpactType type) {
        return impacts.stream()
                .filter(impact -> impact.getDate().isAfter(startDate) && impact.getDate().isBefore(endDate) && impact.getType() == type)
                .collect(Collectors.groupingBy(
                        EnvironmentalImpact::getCompanyName,
                        Collectors.summingDouble(EnvironmentalImpact::getVolume)
                ));
    }
}