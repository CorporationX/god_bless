package school.faang.environmental.monitoring;

import lombok.AllArgsConstructor;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@AllArgsConstructor
public class StatisticsAggregator {
    private final CompanyRepository companyRepo;

    public Map<String, Double> totalEmissionByCompany(List<EnvironmentalImpact> impacts, LocalDate startDate,
                                                 LocalDate endDate, EmissionType emissionType) {
        DateRange dateRange = new DateRange(startDate, endDate);
        return impacts.stream()
                .filter(impact -> dateRange.isDateInRange(impact.getDate()))
                .collect(Collectors.groupingBy(
                        impact -> companyRepo.getCompany(impact.getCompanyId()).getCompanyName(),
                        Collectors.summingDouble(EnvironmentalImpact::getVolume)
                ));
    }
}
