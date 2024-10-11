package environmental_monitoring;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class EmissionPerEmployeeAnalyzer {
    /**
     * Analyze gas emissions per employee of companies.
     *
     * @param fileName filename of environmental impact data
     * @param companies list of companies to analyze
     */
    public void analyzeEmissionsPerEmployee(String fileName, List<Company> companies) {
        CompanyDataLoader dataLoader = new CompanyDataLoader();
        List<EnvironmentalImpact> impacts = dataLoader.loadEnvironmentalImpacts(fileName);

        Map<Integer, List<EnvironmentalImpact>> groupedByCompany = impacts.stream()
                .collect(Collectors.groupingBy(EnvironmentalImpact::getCompanyId));

        System.out.printf("%-20s %-20s %-20s %-20s%n", "Company", "TotalGasEmission", "Employees", "GasEmissionPerEmployee");
        for (Company company : companies) {
            List<EnvironmentalImpact> companyImpacts = groupedByCompany.get(company.getId());
            if (companyImpacts != null) {
                double totalEmission = companyImpacts.stream().mapToDouble(EnvironmentalImpact::getVolume).sum();
                double gasEmissionPerEmployee = totalEmission / company.getTotalEmployees();
                System.out.printf("%-20s %-20s %-20s %-20s%n", company.getCompanyName(), totalEmission, company.getTotalEmployees(), gasEmissionPerEmployee);
            }
        }
    }
}
