package school.faang.BJS2_35028_EnvironmentalMonitoring;

import java.time.LocalDate;
import java.util.AbstractMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EnvironmentalImpactAnalyzer {
    private static final CompanyDataLoader DATA_LOADER;
    private static final int MONTHS_COUNT = 12;
    private static final int TOP_COMPANIES_BY_METRIC_LIMIT = 3;

    private StatisticsAggregator statisticsAggregator;
    private Map<Integer, Company> companiesByIds;
    private LocalDate todayDate;

    static {
        DATA_LOADER = new CompanyDataLoader();
    }

    public EnvironmentalImpactAnalyzer(List<Company> companies, LocalDate todayDate) {
        companiesByIds = new HashMap<>();
        companies.forEach(company -> companiesByIds.put(company.getId(), company));

        this.todayDate = todayDate;
        statisticsAggregator = new StatisticsAggregator(companiesByIds);
    }

    public void printCompanyImpactsStatsByMonths(String csvFilePath, int companyId, String impactType) {
        if (!companiesByIds.containsKey(companyId)) {
            throw new IllegalArgumentException("There is no company with such id");
        }

        String companyName = companiesByIds.get(companyId).getCompanyName();

        List<EnvironmentalImpact> impacts = DATA_LOADER.loadFromCsv(csvFilePath, EnvironmentalImpact.class);
        Stream<EnvironmentalImpact> filteredImpacts =
                filterByTypeAndDate(impacts, impactType, todayDate, MONTHS_COUNT)
                .filter(impact -> impact.getCompanyId() == companyId);
        Map<String, Double> companyEmissionsByMonths = getImpactsStatsByMonths(filteredImpacts);
        double monthlyTotalsSum = calculateValuesSum(companyEmissionsByMonths);

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
        Stream<EnvironmentalImpact> filteredImpacts = filterByTypeAndDate(impacts, impactType, date, MONTHS_COUNT);

        Map<String, Map<String, Double>> topCompaniesStats = filteredImpacts
                .collect(Collectors.groupingBy(
                        impact -> companiesByIds.get(impact.getCompanyId()).getCompanyName(),
                        Collectors.collectingAndThen(
                                Collectors.toList(),
                                companyImpacts -> getImpactsStatsByMonths(companyImpacts.stream())
                        )
                ))
                .entrySet().stream()
                .sorted((firstCompany, secondCompany) ->
                        Double.compare(
                                calculateValuesSum(secondCompany.getValue()),
                                calculateValuesSum(firstCompany.getValue())
                        )
                )
                .limit(TOP_COMPANIES_BY_METRIC_LIMIT)
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue
                ));

        System.out.printf("%-15s %-20s %-25s %s\n", "Company", "Total(" + impactType + ")",
                "Avg(" + impactType + ")/month", "Min(" + impactType + ")/month"
        );
        topCompaniesStats.forEach((companyName, companyStats) -> {
            double monthlyStatsSum = calculateValuesSum(companyStats);
            double monthlyStatsAverage = calculateValuesAverage(companyStats);
            double monthlyStatsMin = getMinValue(companyStats);
            System.out.printf("%-15s %-20.2f %-25.2f %.2f\n", companyName, monthlyStatsSum, monthlyStatsAverage, monthlyStatsMin);
        });
    }

    private Map<String, Double> getImpactsStatsByMonths(Stream<EnvironmentalImpact> impacts) {
        return impacts
                .collect(Collectors.groupingBy(
                        impact -> DateFormatter.getYearAndMonth(impact.getDate()),
                        Collectors.summingDouble(EnvironmentalImpact::getVolume))
                );
    }

    private Stream<EnvironmentalImpact> filterByTypeAndDate(
            List<EnvironmentalImpact> impacts, String impactType, LocalDate date, int monthsCount
    ) {
        LocalDate oneYearAgoDate = date.minusMonths(monthsCount);
        return impacts.stream()
                .filter(impact ->
                        impact.getDate().isAfter(oneYearAgoDate)
                        && impact.getDate().isBefore(date)
                        && impactType.equals(impact.getType())
                );
    }

    private <T extends Number> double calculateValuesSum(Map<?, T> inputMap) {
        return inputMap.values().stream()
                .mapToDouble(Number::doubleValue)
                .sum();
    }

    private <T extends Number> double calculateValuesAverage(Map<?, T> inputMap) {
        return inputMap.values().stream()
                .mapToDouble(Number::doubleValue)
                .average()
                .orElseThrow(() -> new IllegalStateException("Unable to calculate average value"));
    }

    private <T extends Number> double getMinValue(Map<?, T> inputMap) {
        return inputMap.values().stream()
                .mapToDouble(Number::doubleValue)
                .min()
                .orElseThrow(() -> new IllegalStateException("Unable to get minimal value"));
    }
}
