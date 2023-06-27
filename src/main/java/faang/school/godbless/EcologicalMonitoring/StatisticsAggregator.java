package faang.school.godbless.EcologicalMonitoring;

import java.time.LocalDate;
import java.time.Period;
import java.util.*;
import java.util.stream.Collectors;

import static faang.school.godbless.EcologicalMonitoring.Companies.COMPANIES;

public class StatisticsAggregator {
    public Map<String, Double> aggregate(LocalDate startDate, LocalDate endDate, List<EnvironmentalImpact> environmentalImpacts, EType eType) {
        Map<Integer, String> companiesMap = COMPANIES.stream()
                .collect(Collectors.toMap(Company::getId, Company::getCompanyName));
        return environmentalImpacts.stream()
                .filter(impact -> impact.getDate().isAfter(startDate) && impact.getDate().isBefore(endDate) && impact.getType().equals(eType))
                .collect(Collectors.toMap(impact -> companiesMap.get(impact.getCompanyId()), EnvironmentalImpact::getVolume, Double::sum));
    }
}
