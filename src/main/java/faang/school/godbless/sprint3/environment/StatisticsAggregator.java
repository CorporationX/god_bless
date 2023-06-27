package faang.school.godbless.sprint3.environment;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class StatisticsAggregator {
    public Map<String, Double> getImpactStatistics(
            List<EnvironmentalImpact> impactList,
            EnvironmentalImpact.Type type,
            LocalDate startDate,
            LocalDate endDate) {

        return impactList.stream()
                .filter(impact -> Objects.equals(type, impact.getType()))
                .filter(impact -> impact.getDate().isAfter(startDate))
                .filter(impact -> impact.getDate().isBefore(endDate))
                .collect(Collectors.groupingBy(
                        EnvironmentalImpact::getCompany,
                        Collectors.summingDouble(EnvironmentalImpact::getVolume))
                );
    }
}
