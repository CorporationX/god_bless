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
        return impactList.stream()
                .filter(Objects::nonNull)
                .filter(impact -> !impact.date().isBefore(startDate)
                        && !impact.date().isAfter(endDate))
                .filter(impact -> Objects.equals(impact.type(), type))
                .filter(impact -> Objects.equals(impact.companyId(), companyId))
                .collect(
                        Collectors.groupingBy(
                                impact -> YearMonth.from(impact.date()),
                                Collectors.summingDouble(EnvironmentalImpact::volume)

                ));
    }

    public Map<Company, Double> getTotalEmissions(LocalDate startDate,
                                                  LocalDate endDate,
                                                  List<EnvironmentalImpact> impactList,
                                                  EnvironmentalImpactType type) {
        return impactList.stream()
                .filter(Objects::nonNull)
                .filter(impact -> !impact.date().isBefore(startDate)
                        && !impact.date().isAfter(endDate))
                .filter(impact -> Objects.equals(impact.type(), type))
                .collect(Collectors.groupingBy(
                        entry -> getCompanyById(entry.companyId()),
                                Collectors.summingDouble(EnvironmentalImpact::volume)

                ));
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
