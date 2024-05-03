package faang.school.godbless.environmental_monitoring;

public class Main {
    private static final String PATH_TO_FILE = "impatcs.csv";
    public static void main(String[] args) {
        CompanyService companyService = new CompanyService();
        StatisticsAggregator statisticsAggregator = new StatisticsAggregator(companyService);
        EnvironmentalImpactAnalyzer environmentalImpactAnalyzer = new EnvironmentalImpactAnalyzer(statisticsAggregator, companyService);

        environmentalImpactAnalyzer.getStatisticsForTheYearByCompanyId(PATH_TO_FILE, 1);
        System.out.println();
        environmentalImpactAnalyzer.findTopThreeCompaniesForTheYearByEnergyConsumption(PATH_TO_FILE);
        System.out.println();
        environmentalImpactAnalyzer.findEnergyConsumptionPerEachEmployee(PATH_TO_FILE);
    }
}