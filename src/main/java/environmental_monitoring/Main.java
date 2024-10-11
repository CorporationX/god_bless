package environmental_monitoring;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        String fileName = "environmental_impact_100.csv";
        CompanyDataLoader dataLoader = new CompanyDataLoader();
        List<EnvironmentalImpact> impacts = dataLoader.loadEnvironmentalImpacts(fileName);
        System.out.println(impacts);

        EnvironmentalImpactAnalyzer analyzer = new EnvironmentalImpactAnalyzer(dataLoader, new StatisticsAggregator());
        analyzer.analyzeEmissions(fileName, 101);

        ComparisonAnalyzer comparisonAnalyzer = new ComparisonAnalyzer();
        comparisonAnalyzer.compareCompanies(fileName);

        List<Company> companies = List.of(new Company(101, "EcoCompany", 100), new Company(102, "PollutingCo", 200));
        EmissionPerEmployeeAnalyzer emissionPerEmployeeAnalyzer = new EmissionPerEmployeeAnalyzer();
        emissionPerEmployeeAnalyzer.analyzeEmissionsPerEmployee(fileName, companies);

        StatisticsAggregator statisticsAggregator = new StatisticsAggregator();
        Map<String, Double> companyEmissions = statisticsAggregator.aggregateStatistics("2000-01-01", "2024-12-31", impacts, ImpactType.GAS_EMISSION);
        System.out.println(companyEmissions);
    }
}
