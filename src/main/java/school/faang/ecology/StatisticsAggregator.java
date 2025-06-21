package school.faang.ecology;

import lombok.RequiredArgsConstructor;
import school.faang.ecology.domain.EnvironmentalImpact;
import school.faang.ecology.domain.EnvironmentalImpactType;

import java.time.LocalDate;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author Danil Pudovkin
 * @since 21.06.2025
 */
@RequiredArgsConstructor
public class StatisticsAggregator {

    /**
     * @param startDate Начало периода
     * @param endDate   Конец периода
     * @param impacts   Список объектов {@link EnvironmentalImpact}
     * @param type      Тип воздействия
     * @return Возвращает суммарный объём выбросов для каждой компании
     */
    public Map<Integer, Double> aggregate(LocalDate startDate, LocalDate endDate,
                                                 Set<EnvironmentalImpact> impacts, EnvironmentalImpactType type) {
        return impacts.stream()
                .filter(impact -> impact.getDate().isAfter(startDate)
                        && impact.getDate().isBefore(endDate))
                .filter(impact -> impact.getType().equals(type))
                .collect(Collectors.groupingBy(
                        EnvironmentalImpact::getCompanyId,
                        Collectors.summingDouble(EnvironmentalImpact::getVolume))
                );
    }
}
