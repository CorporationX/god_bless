package environmental_monitoring;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        String fileName = "environmental_impact_100.csv";
        CompanyDataLoader dataLoader = new CompanyDataLoader();
        List<EnvironmentalImpact> impacts = dataLoader.loadEnvironmentalImpacts(fileName);
        System.out.println(impacts);

        EnvironmentalImpactAnalyzer analyzer = new EnvironmentalImpactAnalyzer(dataLoader);
        analyzer.analyzeEmissions(fileName, 101);

        ComparisonAnalyzer comparisonAnalyzer = new ComparisonAnalyzer();
        comparisonAnalyzer.compareCompanies(fileName);

        List<Company> companies = List.of(new Company(101, "EcoCompany", 100), new Company(102, "PollutingCo", 200));
        EmissionPerEmployeeAnalyzer emissionPerEmployeeAnalyzer = new EmissionPerEmployeeAnalyzer();
        emissionPerEmployeeAnalyzer.analyzeEmissionsPerEmployee(fileName, companies);

        StatisticsAggregator statisticsAggregator = new StatisticsAggregator();
        Map<String, Double> companyEmissions = statisticsAggregator.aggregateStatistics(
                LocalDate.parse("2000.01.01", DateFormatter.FULL_DATE_SEPARATED_BY_A_DOT),
                LocalDate.parse("2024.12.31", DateFormatter.FULL_DATE_SEPARATED_BY_A_DOT),
                impacts,
                ImpactType.GAS_EMISSION
        );
        System.out.println(companyEmissions);
    }
}
