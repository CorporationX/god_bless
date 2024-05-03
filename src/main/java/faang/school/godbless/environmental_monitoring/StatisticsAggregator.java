package faang.school.godbless.environmental_monitoring;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StatisticsAggregator {

    private CompanyService companyService;

    public StatisticsAggregator(CompanyService companyService) {
        this.companyService = companyService;
    }

    public Map<Company,Double> getAggregateStatistics(
            LocalDate startDate,
            LocalDate endDate,
            List<EnvironmentalImpact> environmentalImpacts,
            EnvironmentalImpactType impactType
    ) {
        return environmentalImpacts.stream()
                .filter(impact -> impact.getType().equals(impactType))
                .filter(impact -> impact.getDate().isAfter(startDate) && impact.getDate().isBefore(endDate))
                .collect(Collectors.groupingBy(impact ->
                        companyService.getCompanyById(impact.getCompanyId()),
                        Collectors.summingDouble(EnvironmentalImpact::getVolume)
                ));
    }
}