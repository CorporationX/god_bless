package school.faang.environmental.monitoring;

import lombok.AllArgsConstructor;

import java.io.IOException;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@AllArgsConstructor
public class EnvironmentalImpactAnalyzer {
    public static final String ERROR_EMPTY_LIST = "Невозможно выполнить операцию, если список пустой";

    private final CompanyRepository companyRepo;
    private final StatisticsAggregator statisticsAggregator;

    public void emissionsReport(String fileName, int idCompany, LocalDate currDate) throws IOException {
        List<EnvironmentalImpact> impacts = CompanyDataLoader.csvToEnvironmentalImpacts(fileName);
        DateRange dateRange = new DateRange(currDate.minusYears(1), currDate);

        List<EnvironmentalImpact> impactsByCurrCompany = impacts.stream()
                .filter(impact -> dateRange.isDateInRange(impact.getDate()))
                .filter(impact -> impact.getCompanyId() == idCompany)
                .toList();
        Map<Month, Double> totalEmissionByMonth = getTotalEmissionByMonth(impactsByCurrCompany);

        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        Company currCompany = companyRepo.getCompany(idCompany);
        System.out.println("Company Name: " + currCompany.getCompanyName());
        System.out.println("Today's date: " + currDate.format(dateFormatter));
        System.out.printf("%-10s %s%n", "Month", "GasEmission");
        totalEmissionByMonth.forEach((month, gasEmission) ->
                System.out.printf("%-10s %.2f%n", month, gasEmission));
        double totalEmission = totalEmissionByMonth.values().stream()
                .mapToDouble(Double::doubleValue)
                .sum();
        System.out.printf("Total %.2f%n", totalEmission);
    }

    public void printTopGasEmitters(String fileName, LocalDate currDate) throws IOException {
        List<EnvironmentalImpact> impacts = CompanyDataLoader.csvToEnvironmentalImpacts(fileName);
        DateRange dateRange = new DateRange(currDate.minusYears(1), currDate);

        Map<String, List<EnvironmentalImpact>> companyToImpact = impacts.stream()
                .filter(impact -> dateRange.isDateInRange(impact.getDate()))
                .collect(Collectors.groupingBy(
                        impact -> companyRepo.getCompany(impact.getCompanyId()).getCompanyName()
                ));
        Map<String, EmissionStatistic> companyToEmissionStatistic = companyToImpact.entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> getEmissionStatisticForCompany(entry.getValue()))
                );

        System.out.printf("%-15s %-18s %-23s %-23s%n",
                "Company", "TotalGasEmission", "AvgGasEmission/Month", "MinGasEmission/Month");
        companyToEmissionStatistic.entrySet().stream()
                .sorted((entry1, entry2) -> Double.compare(
                        entry2.getValue().getTotalVolOverYear(),
                        entry1.getValue().getTotalVolOverYear()))
                .limit(3)
                .forEach(entry ->
                        System.out.printf("%-15s %-18.2f %-23.2f %-23.2f%n",
                                entry.getKey(),
                                entry.getValue().getTotalVolOverYear(),
                                entry.getValue().getAvgVolOverMonth(),
                                entry.getValue().getMinVolOverMonth())
                );
    }

    public void printEmissionsPerEmployee(String fileName, LocalDate currDate) throws IOException {
        List<EnvironmentalImpact> impacts = CompanyDataLoader.csvToEnvironmentalImpacts(fileName);
        DateRange dateRange = new DateRange(currDate.minusYears(1), currDate);

        Map<String, Double> companyToImpact = statisticsAggregator.totalEmissionByCompany(impacts, dateRange,
                EmissionType.GAS_EMISSION);

        Map<String, Integer> companyToEmployeesCount = companyRepo.employeesCountByCompany(
                new ArrayList<>(companyToImpact.keySet()));

        System.out.printf("%-18s %-18s %-10s %-20s%n",
                "Company", "TotalGasEmission", "Employees", "GasEmissionPerEmployee");
        companyToImpact.forEach((companyName, totalEmission) -> {
            int employeesCount = companyToEmployeesCount.get(companyName);
            System.out.printf("%-18s %-18.2f %-10d %-20.2f%n",
                    companyName,
                    totalEmission,
                    employeesCount,
                    totalEmission / employeesCount);
        });
    }

    private static Map<Month, Double> getTotalEmissionByMonth(List<EnvironmentalImpact> impacts) {
        return impacts.stream()
                .collect(Collectors.groupingBy(
                        impact -> impact.getDate().getMonth(),
                        Collectors.summingDouble(EnvironmentalImpact::getVolume)
                ));
    }

    private EmissionStatistic getEmissionStatisticForCompany(List<EnvironmentalImpact> impacts) {
        double totalVolEmission = impacts.stream()
                .mapToDouble(EnvironmentalImpact::getVolume)
                .sum();
        Map<Month, Double> totalEmissionByMonth = getTotalEmissionByMonth(impacts);
        double avgVolOverMonth = totalEmissionByMonth.values().stream()
                .mapToDouble(Double::doubleValue)
                .average()
                .orElseThrow(() ->
                        new IllegalArgumentException(ERROR_EMPTY_LIST));
        double minVolOverMonth = totalEmissionByMonth.values().stream()
                .mapToDouble(Double::doubleValue)
                .min()
                .orElseThrow(() ->
                        new IllegalArgumentException(ERROR_EMPTY_LIST));
        return new EmissionStatistic(totalVolEmission, avgVolOverMonth, minVolOverMonth);
    }
}
