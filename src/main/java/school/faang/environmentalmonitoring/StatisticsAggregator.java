package school.faang.environmentalmonitoring;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StatisticsAggregator {

    public Map<String, Double> aggregateEmissions(String startDate, String endDate, List<EnvironmentalImpact> impacts, String type) {
        return impacts.stream()
                .filter(impact -> impact.getDate().compareTo(startDate) >= 0 && impact.getDate().compareTo(endDate) <= 0)
                .filter(impact -> impact.getType().equals(type))
                .collect(Collectors.groupingBy(
                        impact -> String.valueOf(impact.getCompanyId()),
                        Collectors.summingDouble(EnvironmentalImpact::getVolume)
                ));
    }
}

