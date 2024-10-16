package school.faangSprint2.t20;


import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        CompanyDataLoader dataLoader = new CompanyDataLoader();
        StatisticsAggregator statsAggregator = new StatisticsAggregator();
        EnvironmentalImpactAnalyzer analyzer = new EnvironmentalImpactAnalyzer(dataLoader, statsAggregator);

        analyzer.analyzeEmissions("environmental_impact_100.csv", "101");

        analyzer.compareCompanies("environmental_impact_100.csv", LocalDate.now());
    }
}