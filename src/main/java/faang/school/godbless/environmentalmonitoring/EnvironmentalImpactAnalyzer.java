package faang.school.godbless.environmentalmonitoring;

import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class EnvironmentalImpactAnalyzer {
    private final CompanyDataLoader companyDataLoader;
    private final StatisticsAggregator statisticsAggregator;

    public void analyzeCompanyEnergyConsumption(String fileName, long companyId) {
        List<EnvironmentalImpact> impacts = companyDataLoader.loadEnvironmentalData(fileName);
        LocalDate currentDate = LocalDate.now();
        LocalDate startDate = currentDate.minusMonths(11).withDayOfMonth(1);
        LocalDate endDate = currentDate.withDayOfMonth(currentDate.lengthOfMonth());

        Company company = statisticsAggregator.companyRepository().findCompanyById(companyId);

        Map<LocalDate, Double> monthlyConsumption = impacts.stream()
                .filter(impact -> impact.getCompanyId() == companyId)
                .filter(impact -> impact.getType() == ImpactType.ENERGY_CONSUMPTION)
                .filter(impact -> !impact.getDate().isBefore(startDate) && !impact.getDate().isAfter(endDate))
                .collect(Collectors.groupingBy(
                        impact -> LocalDate.of(impact.getDate().getYear(), impact.getDate().getMonth(), 1),
                        Collectors.summingDouble(EnvironmentalImpact::getVolume)
                ));

        double totalConsumption = monthlyConsumption.values().stream().mapToDouble(Double::doubleValue).sum();

        System.out.println("=== Analysis for " + company.getCompanyName() + " ===");
        System.out.println("Company Name: " + company.getCompanyName());
        System.out.println("Today's date: " + currentDate);
        System.out.println("Month  EnergyConsumption");
        monthlyConsumption.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(entry -> System.out.printf("%s  %.2f%n", entry.getKey(), entry.getValue()));
        System.out.printf("Total    %.2f%n", totalConsumption);
    }

    public void analyzeTopCompanies(String fileName, LocalDate currentDate) {
        List<EnvironmentalImpact> impacts = companyDataLoader.loadEnvironmentalData(fileName);
        LocalDate startDate = currentDate.minusMonths(11).withDayOfMonth(1);

        Map<Company, Double> companyConsumption = statisticsAggregator.aggregateEnvironmentalImpactsByCompanyAndType(startDate, currentDate, impacts, ImpactType.ENERGY_CONSUMPTION);

        System.out.printf("%-20s %-20s %-20s %-20s%n", "Company", "TotalConsumption", "AvgConsumption/Month", "MinConsumption/Month");

        companyConsumption.entrySet().stream()
                .sorted(Map.Entry.<Company, Double>comparingByValue().reversed())
                .limit(3)
                .forEach(entry -> {
                    Company company = entry.getKey();
                    double totalConsumption = entry.getValue();
                    double avgConsumption = totalConsumption / 12;

                    double minConsumption = impacts.stream()
                            .filter(impact -> impact.getCompanyId() == company.getId())
                            .filter(impact -> impact.getType() == ImpactType.ENERGY_CONSUMPTION)
                            .filter(impact -> !impact.getDate().isBefore(startDate) && !impact.getDate().isAfter(currentDate))
                            .collect(Collectors.groupingBy(
                                    impact -> LocalDate.of(impact.getDate().getYear(), impact.getDate().getMonth(), 1),
                                    Collectors.summingDouble(EnvironmentalImpact::getVolume)
                            ))
                            .values().stream().min(Double::compare).orElse(0.0);

                    System.out.printf("%-20s %-20.2f %-20.2f %-20.2f%n", company.getCompanyName(), totalConsumption, avgConsumption, minConsumption);
                });
    }

    public void analyzeEnergyConsumptionPerEmployee(String fileName, LocalDate currentDate) {
        List<EnvironmentalImpact> impacts = companyDataLoader.loadEnvironmentalData(fileName);
        LocalDate startDate = currentDate.minusMonths(11).withDayOfMonth(1);

        Map<Company, Double> companyConsumption = statisticsAggregator.aggregateEnvironmentalImpactsByCompanyAndType(startDate, currentDate, impacts, ImpactType.ENERGY_CONSUMPTION);

        System.out.printf("%-20s %-20s %-10s %-25s%n", "Company", "TotalEnergyConsumption", "Employees", "ConsumptionPerEmployee");

        companyConsumption.entrySet().stream()
                .map(entry -> {
                    Company company = entry.getKey();
                    double totalConsumption = entry.getValue();
                    int totalEmployees = company.getTotalEmployees();
                    double consumptionPerEmployee = totalEmployees > 0 ? totalConsumption / totalEmployees : 0.0;
                    return new Object[]{company.getCompanyName(), totalConsumption, totalEmployees, consumptionPerEmployee};
                })
                .forEach(data -> System.out.printf(
                        "%-20s %-20.2f %-10d %-25.2f%n",
                        data[0],
                        (Double) data[1],
                        (Integer) data[2],
                        (Double) data[3]
                ));
    }
}