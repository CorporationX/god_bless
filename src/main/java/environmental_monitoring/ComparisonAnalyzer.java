package environmental_monitoring;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ComparisonAnalyzer extends BaseAnalyzer {
    private static final int COUNT_MONTHS = 12;
    private static final int LIMIT_TOP = 3;
    /**
     * Prints the top 3 companies with the highest total gas emissions, along with their
     * average and minimum gas emissions.
     *
     * @param fileName the name of the CSV file containing the gas emission data
     */
    public void compareCompanies(String fileName) {
        Map<Integer, List<EnvironmentalImpact>> groupedByCompany = getGroupedByCompany(fileName);

        Map<String, CompanyStats> stats = new HashMap<>();

        for (Map.Entry<Integer, List<EnvironmentalImpact>> entry : groupedByCompany.entrySet()) {
            int companyId = entry.getKey();
            List<EnvironmentalImpact> companyImpacts = entry.getValue();

            double totalEmission = companyImpacts.stream()
                    .mapToDouble(EnvironmentalImpact::getVolume)
                    .sum();

            double avgEmission = totalEmission / COUNT_MONTHS;
            double minEmission = companyImpacts.stream()
                    .mapToDouble(EnvironmentalImpact::getVolume)
                    .min()
                    .orElse(0.0);

            String companyName = getCompanyNameById(companyId);
            stats.put(companyName, new CompanyStats(totalEmission, avgEmission, minEmission));
        }

        stats.entrySet().stream()
                .sorted((e1, e2) -> Double.compare(e2.getValue().getTotalGasEmission(), e1.getValue().getTotalGasEmission()))
                .limit(LIMIT_TOP)
                .forEach(entry -> {
                    String name = entry.getKey();
                    CompanyStats stat = entry.getValue();
                    System.out.printf("%-20s %-20s %-20s %-20s%n", name, stat.getTotalGasEmission(), stat.getAvgGasEmission(), stat.getMinGasEmission());
                });
    }
}
