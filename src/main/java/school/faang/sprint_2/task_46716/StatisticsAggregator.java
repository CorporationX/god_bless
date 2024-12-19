package school.faang.sprint_2.task_46716;

import lombok.NonNull;
import school.faang.sprint_2.task_46716.entity.EnvironmentalImpact;
import school.faang.sprint_2.task_46716.entity.ImpactType;
import school.faang.sprint_2.task_46716.repository.CompanyRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class StatisticsAggregator {

    public Map<String, Double> getCompaniesTotalImpact(@NonNull LocalDate startDate,
                                                        @NonNull LocalDate endDate,
                                                        @NonNull List<EnvironmentalImpact> environmentalImpacts,
                                                        @NonNull ImpactType impactType) {
        return environmentalImpacts.stream()
                .filter(impact -> {
                    LocalDate date = impact.getDate();
                    return date.isAfter(startDate) && date.isBefore(endDate) && impact.getType() == impactType;
                })
                .collect(Collectors.groupingBy(EnvironmentalImpact::getCompanyId))
                .entrySet()
                .stream()
                .collect(Collectors.toMap(entry ->
                                CompanyRepository.getCompanyById(entry.getKey())
                                        .orElseThrow(NoSuchElementException::new)
                                        .getCompanyName(),
                        entry -> entry.getValue()
                                .stream()
                                .map(EnvironmentalImpact::getVolume)
                                .reduce(Double::sum)
                                .orElse(0.0)));
    }
}
