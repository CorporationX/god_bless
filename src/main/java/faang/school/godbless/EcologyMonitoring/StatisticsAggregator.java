package faang.school.godbless.EcologyMonitoring;

import java.time.LocalDate;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StatisticsAggregator {
    public static Map<String, DoubleSummaryStatistics> aggregateEnvironmentalImpactsByCompanyAndType(LocalDate startDate, LocalDate endDate, List<EnvironmentalImpact> impacts, ImpactType type) {
        return impacts.stream()
                .filter(impact -> impact.getDate().isAfter(startDate) && impact.getDate().isBefore(endDate))
                .filter(impact -> impact.getType().equals(type))
                .collect(Collectors.groupingBy(
                        EnvironmentalImpact::getCompanyName,
                        Collectors.summarizingDouble(EnvironmentalImpact::getVolume)));
    }

    public static Map<String, DoubleSummaryStatistics> aggregateEnvironmentalImpactsByCompany(LocalDate startDate, LocalDate endDate, List<EnvironmentalImpact> impacts) {
        return impacts.stream()
                .filter(impact -> impact.getDate().isAfter(startDate) && impact.getDate().isBefore(endDate))
                .collect(Collectors.groupingBy(
                        EnvironmentalImpact::getCompanyName,
                        Collectors.summarizingDouble(EnvironmentalImpact::getVolume)));
    }
}
