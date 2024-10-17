package school.faang.BJS2_35028_EnvironmentalMonitoring;

import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;

public class Main {
    private static final String csvFilePath = "src/main/files/EnvImpacts/environmental_impact_100.csv";

    public static void main(String[] args) {
        List<Company> companies = new ArrayList<>();

        companies.add(new Company(101, "Alpha Corp", 250));
        companies.add(new Company(102, "Beta Ltd", 150));
        companies.add(new Company(103, "Gamma Inc", 300));
        companies.add(new Company(104, "Delta PLC", 500));
        companies.add(new Company(105, "Epsilon GmbH", 200));

        LocalDate date = LocalDate.of(2023, 2, 15);

        EnvironmentalImpactAnalyzer impactAnalyzer = new EnvironmentalImpactAnalyzer(companies, date);
        impactAnalyzer.printCompanyImpactsVolumesByMonths(csvFilePath, 102, "GAS_EMISSION");
        System.out.println();
        impactAnalyzer.printTopCompaniesByMetric(csvFilePath, date, "GAS_EMISSION");
        System.out.println();
        impactAnalyzer.printVolumePerEmployee(csvFilePath, "GAS_EMISSION");
    }
}
