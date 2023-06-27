package faang.school.godbless.eco_monitoring;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class StatisticsAggregator {
    public static Map<String, Double> getStatistics(LocalDate startDate, LocalDate endDate,
                                                    List<EnvironmentalImpact> list, ImpactType type) {
        return list.stream()
                .filter(impact -> isBetween(startDate, endDate, impact.getDate()))
                .filter(impact -> impact.getType().equals(type))
                .collect(Collectors.groupingBy(impact -> {
                            Optional<Company> matchingCompany = Company.companies.stream()
                                    .filter(company -> company.getId() == impact.getCompanyId())
                                    .findFirst();
                            return matchingCompany.map(Company::getName).orElse("");
                        },
                        Collectors.summingDouble(EnvironmentalImpact::getVolume)
                ));
    }

    private static boolean isBetween(LocalDate start, LocalDate end, LocalDate date) {
        return date.isAfter(start) && date.isBefore(end);
    }
}
