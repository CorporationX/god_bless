package faang.school.godbless.eco_monitoring;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
@Getter
@AllArgsConstructor
public class StatisticsAggregator {
    private Database database;

    public Map<Integer, Double> aggregateData(LocalDate startDate, LocalDate endDate,
                                              List<EnvironmentalImpact> environmentalImpactList,
                                              EnvironmentalImpactType environmentalImpactType) {
        return DateStream.getEnvironmentalImpactsInRange(environmentalImpactList, startDate, endDate)
                .filter(impact -> impact.getType().equals(environmentalImpactType))
                .filter(impact -> {
                    boolean isCompanyInDataBase = database.getIdAndCompanyMap().containsKey(impact.getCompanyId());
                    if (!isCompanyInDataBase) {
                        log.warn("Some Company with id {} is not registered in database, " +
                                "but has the environment impact", impact.getCompanyId());
                    }
                    return isCompanyInDataBase;
                })
                .collect(Collectors.groupingBy(EnvironmentalImpact::getCompanyId,
                        Collectors.summingDouble(EnvironmentalImpact::getVolume)));
    }
}
