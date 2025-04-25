package school.faang.stream2.ecomonitoring;


import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StatisticsAggregator {
    public static Map<String, Double> calculateEmissionOnPeriod(LocalDate startDate,
                                                         LocalDate endDate,
                                                         List<EnvironmentalImpact> impactEvents,
                                                         PolutionType type) {

        return impactEvents.stream()
                .filter(impEvent -> type.equals(impEvent.getType()))
                .filter(impEvent ->
                        startDate.isBefore(impEvent.getDate())
                                && endDate.isAfter(impEvent.getDate()))
                .collect(Collectors.groupingBy(
                        impEvent -> EnvironmentalImpactAnalyzer.COMPANY_LIST.stream()
                                .filter(company -> company.getId() == impEvent.getCompanyId())
                                .findFirst()
                                .map(Company::getCompanyName)
                                .orElse("UNDEFINED"),
                        Collectors.summingDouble(EnvironmentalImpact::getVolume)
                ));

    }
}
