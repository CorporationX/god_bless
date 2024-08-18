package faang.school.godbless.BJS2_23005;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StatisticsAggregator {

    public static Map<Integer, Double> sumImpactByCompanyAndType(
            LocalDate startDate, LocalDate endDate,
            List<EnvironmentalImpact> environmentalImpacts,
            TypeEnvironmentalImpact typeEnvironmentalImpact) {

        return environmentalImpacts.stream()
                .filter(impact -> impact.getFactor().equals(typeEnvironmentalImpact))
                .filter(impact -> impact.getDate().isAfter(startDate) && impact.getDate().isBefore(endDate))
                .collect(Collectors.groupingBy(
                        EnvironmentalImpact::getCompanyId,
                        Collectors.summingDouble(EnvironmentalImpact::getVolume)
                ));
    }
}
