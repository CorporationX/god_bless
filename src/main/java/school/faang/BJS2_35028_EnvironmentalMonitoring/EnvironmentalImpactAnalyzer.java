package school.faang.BJS2_35028_EnvironmentalMonitoring;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class EnvironmentalImpactAnalyzer {
    private static final CompanyDataLoader DATA_LOADER;
    private static final int MONTHS_COUNT = 12;
    private static final int TOP_COMPANIES_BY_METRIC_LIMIT = 3;

    private StatisticsAggregator statisticsAggregator;
    private Map<Integer, Company> companiesByIds;
    private Map<String, Company> companiesByNames;
    private LocalDate todayDate;

    static {
        DATA_LOADER = new CompanyDataLoader();
    }

    public EnvironmentalImpactAnalyzer(List<Company> companies, LocalDate todayDate) {
        companiesByIds = new HashMap<>();
        companiesByNames = new HashMap<>();
        companies.forEach(company -> {
            companiesByIds.put(company.getId(), company);
            companiesByNames.put(company.getCompanyName(), company);
        });

        this.todayDate = todayDate;
        statisticsAggregator = new StatisticsAggregator(companiesByIds);
    }

    public void printCompanyImpactsVolumesByMonths(String csvFilePath, int companyId, String impactType) {
        if (!companiesByIds.containsKey(companyId)) {
            throw new IllegalArgumentException("There is no company with such id");
        }

        String companyName = companiesByIds.get(companyId).getCompanyName();

        List<EnvironmentalImpact> impacts = DATA_LOADER.loadFromCsv(csvFilePath, EnvironmentalImpact.class);
        List<EnvironmentalImpact> filteredImpacts =
                filterByTypeAndDate(impacts, impactType, todayDate, MONTHS_COUNT).stream()
                        .filter(impact -> impact.getCompanyId() == companyId)
                        .toList();
        Map<String, Double> companyEmissionsByMonths = getImpactsVolumesByMonths(filteredImpacts);
        double monthlyTotalsSum = calculateVolumesSum(companyEmissionsByMonths);

        System.out.printf("%s: %s\n", "Company name", companyName);
        System.out.printf("%s: %s\n", "Today's date", todayDate);
        System.out.printf("%-10s %-10s\n", "Month", impactType);
        companyEmissionsByMonths.forEach((month, emission) -> {
            System.out.printf("%-10s %.2f\n", month, emission);
        });
        System.out.printf("%-10s %.2f\n", "Total", monthlyTotalsSum);
    }

    public void printTopCompaniesByMetric(String csvFilePath, LocalDate date, String impactType) {
        List<EnvironmentalImpact> impacts = DATA_LOADER.loadFromCsv(csvFilePath, EnvironmentalImpact.class);
        List<EnvironmentalImpact> filteredImpacts = filterByTypeAndDate(impacts, impactType, date, MONTHS_COUNT);

        Map<String, Map<String, Double>> topCompaniesStats = filteredImpacts.stream()
                .collect(Collectors.groupingBy(
                        EnvironmentalImpact::getCompanyId,
                        Collectors.summingDouble(EnvironmentalImpact::getVolume)
                ))
                .entrySet().stream()
                .sorted(Map.Entry.<Integer, Double>comparingByValue().reversed())
                .limit(TOP_COMPANIES_BY_METRIC_LIMIT)
                .collect(Collectors.toMap(
                        entry -> companiesByIds.get(entry.getKey()).getCompanyName(),
                        entry -> getImpactsVolumesByMonths(filteredImpacts, impact -> impact.getCompanyId() == entry.getKey())
                ));

        System.out.printf("%-15s %-20s %-25s %s\n", "Company", String.format("Total (%s)", impactType),
                String.format("Avg (%s)", impactType), String.format("Min (%s)", impactType)
        );
        topCompaniesStats.forEach((companyName, companyStats) -> {
            double volumesSum = calculateVolumesSum(companyStats);
            double volumesAverage = calculateVolumesAverage(companyStats);
            double monthlyVolumesMin = getMonthlyVolumesMin(companyStats);
            System.out.printf("%-15s %-20.2f %-25.2f %.2f\n", companyName, volumesSum, volumesAverage, monthlyVolumesMin);
        });
    }

    public void printVolumePerEmployee(String csvFilePath, String impactType) {
        List<EnvironmentalImpact> impacts = DATA_LOADER.loadFromCsv(csvFilePath, EnvironmentalImpact.class);
        List<EnvironmentalImpact> filteredImpacts = filterByTypeAndDate(impacts, impactType, todayDate, MONTHS_COUNT);

        LocalDate oneYearAgoDate = todayDate.minusMonths(MONTHS_COUNT);
        Map<String, Double> totalVolumesByCompanies =
                statisticsAggregator.getTotalVolumesByCompanies(oneYearAgoDate, todayDate, filteredImpacts, impactType);

        System.out.printf("%-15s %-20s %-10s %s\n", "Company", String.format("Total(%s)", impactType),
                "Employees", String.format("%s_PerEmployee", impactType)
        );
        totalVolumesByCompanies.forEach((companyName, totalVolumes) -> {
            int companyEmployeesCount = companiesByNames.get(companyName).getTotalEmployees();
            double volumesPerEmployee = totalVolumes / companyEmployeesCount;
            System.out.printf("%-15s %-20.2f %-10d %.2f\n", companyName, totalVolumes, companyEmployeesCount, volumesPerEmployee);
        });
    }

    private Map<String, Double> getImpactsVolumesByMonths(List<EnvironmentalImpact> impacts) {
        return getImpactsVolumesByMonths(impacts, impact -> true);
    }

    private Map<String, Double> getImpactsVolumesByMonths(
            List<EnvironmentalImpact> impacts, Predicate<EnvironmentalImpact> condition) {
        return impacts.stream()
                .filter(condition)
                .collect(Collectors.groupingBy(
                        impact -> DateFormatter.getYearAndMonth(impact.getDate()),
                        Collectors.summingDouble(EnvironmentalImpact::getVolume)
                ));
    }

    private List<EnvironmentalImpact> filterByTypeAndDate(
            List<EnvironmentalImpact> impacts, String impactType, LocalDate date, int monthsCount
    ) {
        LocalDate oneYearAgoDate = date.minusMonths(monthsCount);
        return impacts.stream()
                .filter(impact ->
                        impact.getDate().isAfter(oneYearAgoDate)
                                && impact.getDate().isBefore(date)
                                && impactType.equals(impact.getType())
                )
                .toList();
    }

    private <T extends Number> double calculateVolumesSum(Map<?, T> inputMap) {
        return inputMap.values().stream()
                .mapToDouble(Number::doubleValue)
                .sum();
    }

    private <T extends Number> double calculateVolumesAverage(Map<?, T> inputMap) {
        return inputMap.values().stream()
                .mapToDouble(Number::doubleValue)
                .average()
                .orElseThrow(() -> new IllegalStateException("Unable to calculate average value"));
    }

    private <T extends Number> double getMonthlyVolumesMin(Map<?, T> inputMap) {
        return inputMap.values().stream()
                .mapToDouble(Number::doubleValue)
                .min()
                .orElseThrow(() -> new IllegalStateException("Unable to get minimal value"));
    }
}
