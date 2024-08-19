package faang.school.godbless.BJS2_23005;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StatisticsAggregator {

    public static Map<Company, Double> mapCompanyBySumImpact(
            LocalDate startDate, LocalDate endDate,
            List<EnvironmentalImpact> environmentalImpacts,
            TypeEnvironmentalImpact typeEnvironmentalImpact) {
        return mapCompanyBySumImpact(startDate, endDate, environmentalImpacts, typeEnvironmentalImpact, i -> true);
    }

    public static Map<Company, Double> mapCompanyBySumImpact(
            LocalDate startDate, LocalDate endDate,
            List<EnvironmentalImpact> environmentalImpacts,
            TypeEnvironmentalImpact typeEnvironmentalImpact,
            Predicate<EnvironmentalImpact> filter) {

        return environmentalImpacts.stream()
                .filter(filter)
                .filter(impact -> impact.getFactor().equals(typeEnvironmentalImpact))
                .filter(impact -> impact.getDate().isAfter(startDate) && impact.getDate().isBefore(endDate))
                .collect(Collectors.groupingBy(
                        EnvironmentalImpact::getCompany,
                        Collectors.summingDouble(EnvironmentalImpact::getVolume)
                ));
    }
}