package faang.school.godbless.environmental_monitoring;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.IntStream;

public class EnvironmentalImpactAnalyzer {
    private final NumberFormat FORMATTER = new DecimalFormat("#0.00");
    private CompanyDataLoader companyDataLoader;
    private StatisticsAggregator statisticsAggregator;
    private CompanyService companyService;

    public EnvironmentalImpactAnalyzer(StatisticsAggregator statisticsAggregator, CompanyService companyService) {
        this.companyDataLoader = new CompanyDataLoader();
        this.statisticsAggregator = statisticsAggregator;
        this.companyService = companyService;
    }

    public void getStatisticsForTheYearByCompanyId(String fileName, int companyId) {
        List<EnvironmentalImpact> filteredImpactsByCompanyId = companyDataLoader.readDataFromCSV(fileName).stream()
                .filter(impact -> impact.getCompanyId() == companyId)
                .toList();
        System.out.printf("Company name: %s\n", companyService.getCompanyById(companyId).getCompanyName());
        System.out.printf("Today's date: %s\n", LocalDate.now());
        System.out.println("Month   EnergyConsumption");
        IntStream.range(0, 11)
                .forEach(i ->
                    statisticsAggregator.getAggregateStatistics(
                            LocalDate.now().minusMonths(i).withDayOfMonth(1),
                            LocalDate.now().minusMonths(i).plusMonths(1).withDayOfMonth(1),
                            filteredImpactsByCompanyId,
                            EnvironmentalImpactType.ENERGY_CONSUMPTION
                    ).entrySet().stream()
                            .forEach(entry ->
                                    System.out.printf(
                                            "%-10s %s\n",
                                            LocalDate.now().minusMonths(i).format(DateTimeFormatter.ofPattern("yyyy-MM")),
                                            FORMATTER.format(entry.getValue())
                                    )
                            )
                );
    }

    public void findTopThreeCompaniesForTheYearByEnergyConsumption(String fileName) {
        List<EnvironmentalImpact> impacts = companyDataLoader.readDataFromCSV(fileName);
        System.out.println("Сompany   totalConsumption  avgConsumption/month  minConsumption/month");
        statisticsAggregator.getAggregateStatistics(
                LocalDate.now().minusYears(1),
                LocalDate.now(),
                impacts,
                EnvironmentalImpactType.ENERGY_CONSUMPTION
        ).entrySet().stream()
                .sorted((o1, o2) -> o2.getValue().compareTo(o1.getValue()))
                .limit(3)
                .forEach(entry ->
                    System.out.printf(
                            "%-10s %-20s %-20s %s\n",
                            entry.getKey().getCompanyName(),
                            FORMATTER.format(entry.getValue()),
                            FORMATTER.format(entry.getValue() / 12),
                            FORMATTER.format(impacts.stream()
                                    .filter(impact -> impact.getCompanyId() == entry.getKey().getId())
                                    .filter(impact -> impact.getDate().isAfter(LocalDate.now().minusYears(1)))
                                    .filter(impact -> impact.getType().equals(EnvironmentalImpactType.ENERGY_CONSUMPTION))
                                    .map(EnvironmentalImpact::getVolume)
                                    .min(Double::compareTo)
                                    .get())
                    )
                );
    }

    public void findEnergyConsumptionPerEachEmployee(String fileName) {
        List<EnvironmentalImpact> impacts = companyDataLoader.readDataFromCSV(fileName);
        System.out.println("Company  TotalEnergyConsumption Employees ConsumptionPerEmployee");
        statisticsAggregator.getAggregateStatistics(
                LocalDate.now().minusYears(1),
                LocalDate.now(),
                impacts,
                EnvironmentalImpactType.ENERGY_CONSUMPTION
        ).entrySet().stream()
                .sorted((o1, o2) -> o2.getValue().compareTo(o1.getValue()))
                .limit(3)
                .forEach(entry ->
                        System.out.printf(
                                "%-10s %-20s %-20s %s\n",
                                entry.getKey().getCompanyName(),
                                FORMATTER.format(entry.getValue()),
                                entry.getKey().getTotalEmployees(),
                                FORMATTER.format(entry.getValue() / entry.getKey().getTotalEmployees())
                        )
                );
    }
}