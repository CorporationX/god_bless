package faang.school.godbless.EcologicalMonitoring;

import java.util.*;
import java.util.stream.Collectors;

import static faang.school.godbless.EcologicalMonitoring.Companies.COMPANIES;
import static faang.school.godbless.EcologicalMonitoring.DateRefactor.getDatesRange;

public class StatisticsAggregator {
    public Map<String, Double> aggregate(Date startDate, Date endDate, List<EnvironmentalImpact> environmentalImpacts, EType eType) {
        List<Date> datesRange = getDatesRange(startDate, endDate, 1);
        Map<Integer, String> companiesMap = COMPANIES.stream()
                .collect(Collectors.toMap(Company::getId, Company::getCompanyName));
        return environmentalImpacts.stream()
                .filter(impact -> datesRange.contains(impact.getDate()) && impact.getType().equals(eType))
                .collect(Collectors.toMap(impact -> companiesMap.get(impact.getCompanyId()), EnvironmentalImpact::getVolume, Double::sum));
    }
}
