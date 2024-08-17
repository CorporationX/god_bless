package faang.school.godbless.environmentalmonitoring;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public record StatisticsAggregator(CompanyRepository companyRepository) {
    public Map<Company, Double> aggregateEnvironmentalImpactsByCompanyAndType(LocalDate startDate, LocalDate endDate,
                                                                              List<EnvironmentalImpact> impacts, ImpactType type) {
        return impacts.stream()
                .filter(impact -> impact.getType() == type)
                .filter(impact -> impact.getDate().isAfter(startDate) && impact.getDate().isBefore(endDate))
                .collect(Collectors.groupingBy(
                        impact -> companyRepository.findCompanyById(impact.getCompanyId()),
                        Collectors.summingDouble(EnvironmentalImpact::getVolume)
                ));
    }
}