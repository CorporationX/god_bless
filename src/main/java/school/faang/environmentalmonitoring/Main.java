package school.faang.environmentalmonitoring;

import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        String filename = "src/main/resources/environmental_impact_100.csv";
        EnvironmentalImpactAnalyzer analyzer = new EnvironmentalImpactAnalyzer();

        analyzer.analyzeCompanyEmissions(filename, 101); // Replace 101 with the actual company ID.
        analyzer.compareCompanies(filename, "2023.02.15");
        analyzer.emissionsPerEmployee(filename);
    }
}

