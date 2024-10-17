package school.faang.BJS2_35028_EnvironmentalMonitoring;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class EnvironmentalImpactAnalyzer {
    private static final CompanyDataLoader DATA_LOADER;
    private static final int MONTHS_COUNT = 12;

    private StatisticsAggregator statisticsAggregator;
    private Map<Integer, Company> companiesByIds;
    private LocalDate todayDate;
    private LocalDate oneYearAgoDate;

    static {
        DATA_LOADER = new CompanyDataLoader();
    }

    public EnvironmentalImpactAnalyzer(List<Company> companies, LocalDate todayDate) {
        companiesByIds = new HashMap<>();
        companies.forEach(company -> companiesByIds.put(company.getId(), company));

        this.todayDate = todayDate;
        oneYearAgoDate = todayDate.minusMonths(MONTHS_COUNT);

        statisticsAggregator = new StatisticsAggregator(companiesByIds);
    }

    public void printCompanyImpactsStatsByMonths(String csvFilePath, int companyId, String impactType) {
        if (!companiesByIds.containsKey(companyId)) {
            throw new IllegalArgumentException("There is no company with such id");
        }

        String companyName = companiesByIds.get(companyId).getCompanyName();

        List<EnvironmentalImpact> impacts = DATA_LOADER.loadFromCsv(csvFilePath, EnvironmentalImpact.class);
        Map<String, Double> companyEmissionsByMonths = getCompanyImpactsStatsByMonths(impacts, companyId, impactType);
        Double totalEmission = companyEmissionsByMonths.values().stream()
                .mapToDouble(Double::doubleValue)
                .sum();

        System.out.printf("Company's name: %s\n", companyName);
        System.out.printf("Today's date: %s\n", todayDate);
        System.out.printf("Month\t%s\n", impactType);
        companyEmissionsByMonths.forEach((month, emission) -> {
            System.out.printf("%s\t%.2f\n", month, emission);
        });
        System.out.printf("Total\t%.2f", totalEmission);
    }

    public void printTop3CompaniesByMetric(String csvFilePath, LocalDate date, String impactType) {
        List<EnvironmentalImpact> impacts = DATA_LOADER.loadFromCsv(scvFilePath, EnvironmentalImpact.class);
    }

    private Map<String, Double> getCompanyImpactsStatsByMonths(List<EnvironmentalImpact> impacts, int companyId, String impactType) {
        return impacts.stream()
                .filter(impact ->
                        impact.getCompanyId() == companyId
                        && impact.getDate().isAfter(oneYearAgoDate)
                        && impact.getDate().isBefore(todayDate)
                        && impactType.equals(impact.getType())
                )
                .collect(Collectors.groupingBy(
                        impact -> DateFormatter.getYearAndMonth(impact.getDate()),
                        Collectors.summingDouble(EnvironmentalImpact::getVolume))
                );
    }
}
