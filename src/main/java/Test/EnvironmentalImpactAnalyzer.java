package Test;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Collectors;

class EnvironmentalImpactAnalyzer {
    private CompanyDataLoader dataLoader;
    private StatisticsAggregator statisticsAggregator;
    private EnvironmentalImpactType type;

    public EnvironmentalImpactAnalyzer() {
        this.dataLoader = new CompanyDataLoader();
        this.statisticsAggregator = new StatisticsAggregator();
    }

    public void analyzeEnvironmentalImpactByCompanyAndType(String fileName, LocalDate currentDate, EnvironmentalImpactType type) {
        List<EnvironmentalImpact> environmentalImpacts = dataLoader.loadEnvironmentalImpacts(fileName);

        LocalDate startDate = currentDate.minusYears(1).withDayOfMonth(1);
        LocalDate endDate = currentDate.withDayOfMonth(1).minusDays(1);

        Map<String, Double> aggregatedData = statisticsAggregator.aggregateEnvironmentalImpactsByCompanyAndType(
                startDate, endDate, environmentalImpacts, type);

        AtomicBoolean headerPrinted = new AtomicBoolean(false);

        System.out.println("\nCompany Name                                 Total Environmental Impact");
        aggregatedData.forEach((companyName, totalImpact) -> {
            if (!headerPrinted.get()) {
                headerPrinted.set(true);
            }

            int employees = getEmployeesById(companyName, environmentalImpacts);
            double yearlyImpactPerEmployee = totalImpact / employees;

            double monthlyCost = totalImpact / 12;
            System.out.printf("  %s           %.2f (Monthly Cost: %.2f, Employees: %d, Yearly Impact per Employee: %.2f)%n",
                    companyName, totalImpact, monthlyCost, employees, yearlyImpactPerEmployee);
        });

        if (!headerPrinted.get()) {
            System.out.println("No data available.");
        }
    }

    private int getEmployeesById(String companyName, List<EnvironmentalImpact> environmentalImpacts) {
        return environmentalImpacts.stream()
                .filter(impact -> impact.getCompanyName().equals(companyName))
                .mapToInt(EnvironmentalImpact::getEmployees)
                .findFirst()
                .orElse(0);
    }

    public void analyzeTopEnvironmentalImpacts(String fileName, LocalDate currentDate) {
        type = EnvironmentalImpactType.ENERGY_CONSUMPTION;
        List<EnvironmentalImpact> environmentalImpacts = dataLoader.loadEnvironmentalImpacts(fileName);

        LocalDate startDate = currentDate.minusYears(1).withDayOfMonth(1);
        LocalDate endDate = currentDate.withDayOfMonth(1).minusDays(1);

        Map<String, Double> aggregatedData = statisticsAggregator.aggregateEnvironmentalImpactsByCompanyAndType(
                startDate, endDate, environmentalImpacts, type);

        List<Map.Entry<String, Double>> sortedCompanies = aggregatedData.entrySet().stream()
                .sorted(Map.Entry.<String, Double>comparingByValue().reversed())
                .limit(3)
                .collect(Collectors.toList());
        System.out.println("\nTop 3 Companies: Total Environmental Impact");
        sortedCompanies.forEach(entry ->
                System.out.printf("%s: %.2f%n", entry.getKey(), entry.getValue()));

        double totalEnvironmentalImpact = aggregatedData.values().stream().mapToDouble(Double::doubleValue).sum();
        double avgMonthlyImpact = totalEnvironmentalImpact / aggregatedData.size();
        double minMonthlyImpact = aggregatedData.values().stream().mapToDouble(Double::doubleValue).min().orElse(0);

        System.out.printf("Total Environmental Impact: %.2f%n", totalEnvironmentalImpact);
        System.out.printf("Average Yearly Impact per Company: %.2f%n", avgMonthlyImpact);
        System.out.printf("Minimum Yearly Impact per Company: %.2f%n", minMonthlyImpact);
    }
}
