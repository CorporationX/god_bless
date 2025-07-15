package school.faang.bjs2_80821;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StatisticsAggregator {

    public Map<Integer, Double> aggregateEnvironmentalImpactsByCompanyAndType(
            LocalDate startDate, LocalDate endDate,
            List<EnvironmentalImpact> list, ExposureType type
    ) {
        return list.stream()
                .filter(e -> e.getDate().isAfter(startDate))
                .filter(e -> e.getDate().isBefore(endDate))
                .filter(environmentalImpact -> environmentalImpact.getType() == type)
                .collect(Collectors.groupingBy(
                        EnvironmentalImpact::getCompanyId,
                        Collectors.summingDouble(EnvironmentalImpact::getVolume)
                ));
    }

    public Map<String, List<EnvironmentalImpact>> aggregateEnvironmentalImpactsByCompanies(
            LocalDate startDate, LocalDate endDate,
            List<EnvironmentalImpact> list, ExposureType type
    ) {
        return list.stream()
                .filter(e -> e.getDate().isAfter(startDate))
                .filter(e -> e.getDate().isBefore(endDate))
                .filter(environmentalImpact -> environmentalImpact.getType() == type)
                .collect(Collectors.groupingBy(
                        e -> Integer.toString(e.getCompanyId())
                ));
    }

    public Map<Month, List<EnvironmentalImpact>> aggregateEnvironmentalImpactsByCompanyAndMonth(
            LocalDate startDate, LocalDate endDate,
            List<EnvironmentalImpact> list, ExposureType type,
            long companyId
    ) {
        return list.stream()
                .filter(e -> e.getCompanyId() == companyId && e.getType() == type)
                .filter(e -> e.getDate().isAfter(startDate))
                .filter(e -> e.getDate().isBefore(endDate))
                .collect(Collectors.groupingBy(
                        i -> Month.from(i.getDate())
                ));
    }


}
