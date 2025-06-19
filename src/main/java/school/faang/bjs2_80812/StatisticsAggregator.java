package school.faang.bjs2_80812;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StatisticsAggregator {

    public Map<String, Double> aggregate(
            List<EnvironmentalImpact> impacts,
            LocalDate startDate,
            LocalDate endDate,
            ImpactType type,
            Map<Integer, String> companyIdToName
    ) {
        return impacts.stream()
                .filter(impact -> impact.getDate().compareTo(startDate) >= 0)
                .filter(impact -> impact.getDate().compareTo(endDate) <= 0)
                .filter(impact -> impact.getType() == type)
                .collect(Collectors.groupingBy(
                        impact -> companyIdToName.getOrDefault(impact.getCompanyId(), "Unknown Company"),
                        Collectors.summingDouble(EnvironmentalImpact::getVolume)
                ));
    }
}
