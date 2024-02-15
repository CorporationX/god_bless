package EkologyMonitor;

import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StatisticsAggregator {
    public Map<String, Double> aggregateStatisticsByMonth(
            List<EnvironmentalImpact> impacts, EnvironmentalImpact.ImpactType type) {
        return impacts.stream()
                .filter(impact -> impact.getType() == type)
                .collect(Collectors.groupingBy(
                        impact -> impact.getDate().format(DateTimeFormatter.ofPattern("yyyy.MM")),
                        Collectors.summingDouble(EnvironmentalImpact::getVolume)
                ));
    }

    public Map<String, Double> aggregateStatistics(
            LocalDate startDate, LocalDate endDate, List<EnvironmentalImpact> impacts,
            EnvironmentalImpact.ImpactType type) {
        return impacts.stream()
                .filter(impact -> impact.getType() == type
                        && !impact.getDate().isBefore(startDate)
                        && !impact.getDate().isAfter(endDate))
                .collect(Collectors.groupingBy(
                        impact -> getCompanyNameById(impact.getCompanyId(), impacts),
                        Collectors.summingDouble(EnvironmentalImpact::getVolume)
                ));
    }

    public String getCompanyNameById(int companyId, List<EnvironmentalImpact> impacts) {
        return impacts.stream()
                .filter(impact -> impact.getCompanyId() == companyId)
                .findFirst()
                .map(impact -> {
                    Company company = getCompanyById(companyId, impacts);
                    return company != null ? company.getCompanyName() : "";
                })
                .orElse("");
    }

    private Company getCompanyById(int companyId, List<EnvironmentalImpact> impacts) {
        Map<Integer, Company> companyMap = impacts.stream()
                .collect(Collectors.toMap(EnvironmentalImpact::getCompanyId,
                        impact -> new Company(impact.getCompanyId(), "", 0),
                        (existing, replacement) -> existing));

        return companyMap.getOrDefault(companyId, null);
    }
}