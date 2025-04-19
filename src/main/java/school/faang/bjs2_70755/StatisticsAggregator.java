package school.faang.bjs2_70755;

import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

import static school.faang.bjs2_70755.CompanyService.getCompanyById;

@NoArgsConstructor
public class StatisticsAggregator {
    public Map<YearMonth, Double> getEmissionsWithCompanyId(LocalDate startDate,
                                                            LocalDate endDate,
                                                            List<EnvironmentalImpact> impactList,
                                                            EnvironmentalImpactType type,
                                                            long companyId) {
        return getEmissions(startDate, endDate, impactList, type)
                .entrySet()
                .stream()
                .filter(entry -> Objects.equals(entry.getKey().id(), companyId))
                .findFirst()
                .map(Map.Entry::getValue)
                .orElseThrow(() -> new CompanyNotFoundException(companyId));
    }

    public Map<Company, Double> getTotalEmissions(LocalDate startDate,
                                                  LocalDate endDate,
                                                  List<EnvironmentalImpact> impactList,
                                                  EnvironmentalImpactType type) {
        return getEmissions(startDate, endDate, impactList, type)
                .entrySet()
                .stream()
                .collect(Collectors.groupingBy(Map.Entry::getKey,
                        Collectors.flatMapping(entry -> entry.getValue().values().stream(),
                                Collectors.averagingDouble(Double::doubleValue))));
    }

    public Map<Company, Map<YearMonth, Double>> getEmissions(LocalDate startDate,
                                                             LocalDate endDate,
                                                             List<EnvironmentalImpact> impactList,
                                                             EnvironmentalImpactType type) {
        return impactList.stream()
                .filter(Objects::nonNull)
                .filter(e -> !e.date().isBefore(startDate)
                        && !e.date().isAfter(endDate))
                .filter(e -> Objects.equals(e.type(), type))
                .collect(Collectors.groupingBy(
                        entry -> getCompanyById(entry.companyId()),
                        Collectors.groupingBy(
                                impact -> YearMonth.from(impact.date()),
                                Collectors.summingDouble(EnvironmentalImpact::volume)
                        )
                ));
    }
}
