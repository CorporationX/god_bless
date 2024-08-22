package faang.school.godbless.environmentalmonitoring;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        CompanyRepository companyRepository = new CompanyRepository();
        StatisticsAggregator aggregator = new StatisticsAggregator(companyRepository);
        CompanyDataLoader dataLoader = new CompanyDataLoader();
        EnvironmentalImpactAnalyzer analyzer = new EnvironmentalImpactAnalyzer(dataLoader, aggregator);

        analyzer.analyzeCompanyEnergyConsumption("environmental_data.csv", 1);
        analyzer.analyzeTopCompanies("environmental_data.csv", LocalDate.now());
        analyzer.analyzeEnergyConsumptionPerEmployee("environmental_data.csv", LocalDate.now());
    }
}