package environmental_monitoring;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ComparisonAnalyzer {
    /**
     * Prints the top 3 companies with the highest total gas emissions, along with their
     * average and minimum gas emissions.
     *
     * @param fileName the name of the CSV file containing the gas emission data
     */
    public void compareCompanies(String fileName) {
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

    /**
     * Given a company ID, returns the name of the company.
     *
     * @param companyId the ID of the company
     * @return the name of the company
     */
    private String getCompanyNameById(int companyId) {
        return "Some Company " + companyId;
    }
}
