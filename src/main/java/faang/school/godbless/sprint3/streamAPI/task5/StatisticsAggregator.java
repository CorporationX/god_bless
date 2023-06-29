package faang.school.godbless.sprint3.streamAPI.task5;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StatisticsAggregator {

    public Map<String, Double> getTotalEmissionsAndConsumption(
            LocalDate startDate, LocalDate endDate, List<EnvironmentalImpact> environmentalImpacts, Type type) {

        return environmentalImpacts.stream()
                .filter(e -> isBetweenInclusive(startDate, endDate, e.getDate()))
                .filter(e -> e.getType().equals(type))
                .collect(Collectors.groupingBy(en ->
                        Company.companies.stream()
                                .filter(x -> x.getId() == en.getCompanyId())
                                .map(Company::getCompanyName)
                                .toList()
                                .get(0)
                        ,
                        Collectors.summingDouble(EnvironmentalImpact::getVolume)));
    }

    private boolean isBetweenInclusive(LocalDate start, LocalDate end, LocalDate target) {
        return !target.isBefore(start) && !target.isAfter(end);
    }
}
