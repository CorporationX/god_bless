package environmental_monitoring;

import java.util.List;
import java.util.Map;

public class EmissionPerEmployeeAnalyzer extends BaseAnalyzer {
    /**
     * Analyze gas emissions per employee of companies.
     *
     * @param fileName  filename of environmental impact data
     * @param companies list of companies to analyze
     */
    public void analyzeEmissionsPerEmployee(String fileName, List<Company> companies) {
        Map<Integer, List<EnvironmentalImpact>> groupedByCompany = getGroupedByCompany(fileName);

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
