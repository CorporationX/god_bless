package school.faang.sprint_2.task_46716;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
        EnvironmentalImpactAnalyzer environmentalImpactAnalyzer = new EnvironmentalImpactAnalyzer();
        String fileName = "/environmental_impact_100.csv";
        LocalDate date = LocalDate.of(2023, 1, 1);

        environmentalImpactAnalyzer.printCompaniesGasEmissionsPerEmployee(fileName, date);
        environmentalImpactAnalyzer.printCompanyYearGasEmission(fileName, date, 101);
        environmentalImpactAnalyzer.printCompaniesWithLargestGasEmission(fileName, date);
    }
}
