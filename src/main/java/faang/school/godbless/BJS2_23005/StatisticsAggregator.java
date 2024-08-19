package faang.school.godbless.BJS2_23005;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StatisticsAggregator {

    public static Map<Integer, Double> mapCompanyIdBySumImpact(
            LocalDate startDate, LocalDate endDate,
            List<EnvironmentalImpact> environmentalImpacts,
            TypeEnvironmentalImpact typeEnvironmentalImpact) {
        return mapCompanyIdBySumImpact(startDate, endDate, environmentalImpacts, typeEnvironmentalImpact, i -> true);
    }

    public static Map<Integer, Double> mapCompanyIdBySumImpact(
            LocalDate startDate, LocalDate endDate,
            List<EnvironmentalImpact> environmentalImpacts,
            TypeEnvironmentalImpact typeEnvironmentalImpact,
            Predicate<EnvironmentalImpact> filter) {

        return environmentalImpacts.stream()
                .filter(filter)
                .filter(impact -> impact.getFactor().equals(typeEnvironmentalImpact))
                .filter(impact -> impact.getDate().isAfter(startDate) && impact.getDate().isBefore(endDate))
                .collect(Collectors.groupingBy(
                        impact -> impact.getCompany().getId(),
                        Collectors.summingDouble(EnvironmentalImpact::getVolume)
                ));
    }
}