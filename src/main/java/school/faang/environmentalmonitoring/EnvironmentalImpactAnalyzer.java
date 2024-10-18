package school.faang.environmentalmonitoring;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class EnvironmentalImpactAnalyzer {
    private CompanyDataLoader companyDataLoader = new CompanyDataLoader();
    private StatisticsAggregator statisticsAggregator = new StatisticsAggregator();

    public void analyzeCompanyEmissions(String filename, int companyId) {
        List<EnvironmentalImpact> impacts = companyDataLoader.loadEnvironmentalImpactData(filename);
        String currentDate = "2023.02.15";
        List<EnvironmentalImpact> lastYearEmissions = impacts.stream()
                .filter(impact -> impact.getCompanyId() == companyId &&
                        impact.getDate().compareTo(currentDate) >= 0 &&
                        impact.getDate().compareTo("2022.02.15") <= 0)
                .collect(Collectors.toList());

        double totalEmissions = lastYearEmissions.stream().mapToDouble(EnvironmentalImpact::getVolume).sum();

        System.out.println("Company Name: " + "CompanyName");
        System.out.println("Today's date: " + currentDate);
        System.out.println("Month\tGasEmission");

        Map<String, Double> monthlyEmissions = new HashMap<>();
        for (EnvironmentalImpact impact : lastYearEmissions) {
            String month = impact.getDate().substring(0, 7);
            monthlyEmissions.put(month, monthlyEmissions.getOrDefault(month, 0.0) + impact.getVolume());
        }

        for (Map.Entry<String, Double> entry : monthlyEmissions.entrySet()) {
            System.out.printf("%s\t%.2f\n", entry.getKey(), entry.getValue());
        }
        System.out.printf("Total\t%.2f\n", totalEmissions);
    }

    public void compareCompanies(String filename, String currentDate) {
        List<EnvironmentalImpact> impacts = companyDataLoader.loadEnvironmentalImpactData(filename);
        Map<Integer, List<EnvironmentalImpact>> emissionsByCompany = impacts.stream()
                .filter(impact -> impact.getDate().compareTo(currentDate) >= 0 &&
                        impact.getDate().compareTo("2022.02.15") <= 0)
                .collect(Collectors.groupingBy(EnvironmentalImpact::getCompanyId));

        List<Map<String, Object>> results = new ArrayList<>();
        for (Map.Entry<Integer, List<EnvironmentalImpact>> entry : emissionsByCompany.entrySet()) {
            int companyId = entry.getKey();
            List<EnvironmentalImpact> companyImpacts = entry.getValue();
            double totalGasEmission = companyImpacts.stream().mapToDouble(EnvironmentalImpact::getVolume).sum();
            double avgGasEmission = totalGasEmission / 12;
            double minGasEmission = companyImpacts.stream().mapToDouble(EnvironmentalImpact::getVolume).min().orElse(0);

            Map<String, Object> result = new HashMap<>();
            result.put("CompanyId", companyId);
            result.put("TotalGasEmission", totalGasEmission);
            result.put("AvgGasEmissionPerMonth", avgGasEmission);
            result.put("MinGasEmissionPerMonth", minGasEmission);
            results.add(result);
        }

        results.sort((o1, o2) -> Double.compare((Double) o2.get("TotalGasEmission"), (Double) o1.get("TotalGasEmission")));

        System.out.println("Company\tTotalGasEmission\tAvgGasEmission/Month\tMinGasEmission/Month");
        for (int i = 0; i < Math.min(3, results.size()); i++) {
            Map<String, Object> result = results.get(i);
            System.out.printf("%d\t%.2f\t%.2f\t%.2f\n", result.get("CompanyId"), result.get("TotalGasEmission"),
                    result.get("AvgGasEmissionPerMonth"), result.get("MinGasEmissionPerMonth"));
        }
    }

    public void emissionsPerEmployee(String filename) {
        List<EnvironmentalImpact> impacts = companyDataLoader.loadEnvironmentalImpactData(filename);
        Map<Integer, List<EnvironmentalImpact>> emissionsByCompany = impacts.stream()
                .collect(Collectors.groupingBy(EnvironmentalImpact::getCompanyId));

        System.out.println("Company\tTotalGasEmission\tEmployees\tGasEmissionPerEmployee");
        for (Map.Entry<Integer, List<EnvironmentalImpact>> entry : emissionsByCompany.entrySet()) {
            int companyId = entry.getKey();
            List<EnvironmentalImpact> companyImpacts = entry.getValue();
            double totalGasEmission = companyImpacts.stream().mapToDouble(EnvironmentalImpact::getVolume).sum();

            int employees = 100;

            double gasEmissionPerEmployee = totalGasEmission / employees;
            System.out.printf("%d\t%.2f\t%d\t%.2f\n", companyId, totalGasEmission, employees, gasEmissionPerEmployee);
        }
    }
}
