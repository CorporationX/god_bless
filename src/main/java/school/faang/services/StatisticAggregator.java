package school.faang.services;

import school.faang.models.Company;
import school.faang.models.EmissionType;
import school.faang.models.EnvironmentalImpact;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StatisticAggregator {
    public static Map<String, Double> getEnvironmentalImpactByCompany(
            LocalDate startDate, LocalDate endDate, List<EnvironmentalImpact> impacts, EmissionType emissionType,
            boolean anyEmissionType) {

        validateDate(startDate);
        validateDate(endDate);
        validateImpactList(impacts);
        validateEmissionType(emissionType);

        return impacts.stream()
                .filter(impact -> isDateInRange(startDate, endDate, impact.getDate())
                        && (anyEmissionType || impact.getType().equals(emissionType)))
                .collect(Collectors.groupingBy(
                        impact -> Company.getCompanyNameById(impact.getCompanyId()),
                        Collectors.summingDouble(EnvironmentalImpact::getVolume)
                ));
    }

    private static boolean isDateInRange(LocalDate startDate, LocalDate endDate, LocalDate dateToCheck) {
        return (dateToCheck.isEqual(startDate) || dateToCheck.isAfter(startDate))
                && (dateToCheck.isEqual(endDate) || dateToCheck.isBefore(endDate));
    }

    private static void validateDate(LocalDate localDate) {
        if (localDate == null) {
            throw new IllegalArgumentException("Date can't be null.");
        }
    }

    private static void validateImpactList(List<EnvironmentalImpact> impacts) {
        if (impacts == null) {
            throw new IllegalArgumentException("Environmental impact list can't be null.");
        }
        for (EnvironmentalImpact impact : impacts) {
            if (impact == null) {
                throw new IllegalArgumentException("Impact in list can't be null.");
            }
        }
    }

    private static void validateEmissionType(EmissionType type) {
        if (type == null) {
            throw new IllegalArgumentException("EmissionType can't be null.");
        }
    }
}
