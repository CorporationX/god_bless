package school.faang.BJS2_35028_EnvironmentalMonitoring;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StatisticsAggregator {
    private Map<Integer, Company> companiesByIds;

    public StatisticsAggregator(Map<Integer, Company> companiesByIds) {
        this.companiesByIds = companiesByIds;
    }

    public Map<String, Double> getTotalVolumesByCompanies(LocalDate startDate, LocalDate endDate, List<EnvironmentalImpact> envImpacts, String impactType) {
        return envImpacts.stream()
                .filter(impact -> {
                    LocalDate date = impact.getDate();
                    return date.isAfter(startDate)
                            && date.isBefore(endDate)
                            && impact.getType().equals(impactType)
                            && companiesByIds.containsKey(impact.getCompanyId());
                })
                .collect(Collectors.groupingBy(
                        impact -> companiesByIds.get(impact.getCompanyId()).getCompanyName(),
                        Collectors.summingDouble(EnvironmentalImpact::getVolume)
                ));
    }
}
