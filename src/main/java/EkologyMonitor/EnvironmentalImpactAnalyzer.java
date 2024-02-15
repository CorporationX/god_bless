package EkologyMonitor;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

public class EnvironmentalImpactAnalyzer {
    private final CompanyDataLoader companyDataLoader;
    private final StatisticsAggregator statisticsAggregator;

    public EnvironmentalImpactAnalyzer(CompanyDataLoader companyDataLoader, StatisticsAggregator statisticsAggregator) {
        this.companyDataLoader = companyDataLoader;
        this.statisticsAggregator = statisticsAggregator;
    }

    public void analyzeEnergyConsumption(String filePath, int companyId) {
        List<EnvironmentalImpact> impacts = companyDataLoader.loadFromCSV(filePath);

        Company company = createDummyCompany(companyId, impacts);

        if (company != null) {
            System.out.println("Company Name: " + company.getCompanyName());
            System.out.println("Today's date: " + LocalDate.now().format(DateTimeFormatter.ofPattern("dd.MM.yyyy")));
            System.out.println("Month\tEnergyConsumption");

            Map<String, Double> monthlyStatistics = statisticsAggregator.aggregateStatisticsByMonth(
                    impacts, EnvironmentalImpact.ImpactType.ENERGY_CONSUMPTION);

            for (int i = 0; i < 12; i++) {
                LocalDate currentDate = LocalDate.now().minusMonths(i);
                int monthValue = currentDate.getMonthValue();
                String monthLabel = currentDate.format(DateTimeFormatter.ofPattern("yyyy.MM"));
                double energyConsumption = monthlyStatistics.getOrDefault(monthLabel, 0.0);
                System.out.printf("%d.%02d\t%.2f%n", currentDate.getYear(), monthValue, energyConsumption);
            }

            double totalEnergyConsumption = statisticsAggregator.aggregateStatistics(
                            LocalDate.now().minusYears(1), LocalDate.now(), impacts, EnvironmentalImpact.ImpactType.ENERGY_CONSUMPTION)
                    .values().stream().mapToDouble(Double::doubleValue).sum();

            System.out.printf("Total\t%.2f%n", totalEnergyConsumption);
        } else {
            System.out.println("Company with ID " + companyId + " not found.");
        }
    }

    private Company createDummyCompany(int companyId, List<EnvironmentalImpact> impacts) {
        String companyName = statisticsAggregator.getCompanyNameById(companyId, impacts);
        return new Company(companyId, companyName, 0);
    }
}