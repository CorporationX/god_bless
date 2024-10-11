package environmental_monitoring;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ComparisonAnalyzer {
    public void compareCompanies(String fileName, String currentDate) {
        CompanyDataLoader dataLoader = new CompanyDataLoader();
        List<EnvironmentalImpact> impacts = dataLoader.loadEnvironmentalImpacts(fileName);

        Map<Integer, List<EnvironmentalImpact>> groupedByCompany = impacts.stream()
                .collect(Collectors.groupingBy(EnvironmentalImpact::getCompanyId));

        Map<String, CompanyStats> stats = new HashMap<>();

        for (Map.Entry<Integer, List<EnvironmentalImpact>> entry : groupedByCompany.entrySet()) {
            int companyId = entry.getKey();
            List<EnvironmentalImpact> companyImpacts = entry.getValue();

            double totalEmission = companyImpacts.stream()
                    .mapToDouble(EnvironmentalImpact::getVolume)
                    .sum();

            double avgEmission = totalEmission / 12;
            double minEmission = companyImpacts.stream()
                    .mapToDouble(EnvironmentalImpact::getVolume)
                    .min()
                    .orElse(0.0);

            String companyName = getCompanyNameById(companyId);
            stats.put(companyName, new CompanyStats(totalEmission, avgEmission, minEmission));
        }

        stats.entrySet().stream()
                .sorted((e1, e2) -> Double.compare(e2.getValue().getTotalGasEmission(), e1.getValue().getTotalGasEmission()))
                .limit(3)
                .forEach(entry -> {
                    String name = entry.getKey();
                    CompanyStats stat = entry.getValue();
                    System.out.printf("%-20s %-20s %-20s %-20s%n", name, stat.getTotalGasEmission(), stat.getAvgGasEmission(), stat.getMinGasEmission());
                });
    }

    private String getCompanyNameById(int companyId) {
        return "Some Company " + companyId;
    }
}
