package school.faang.environmental.monitoring;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    public static final String PATH = "src/main/resources/environmental_impact_100.csv";

    public static void main(String[] args) throws IOException {
        List<EnvironmentalImpact> impacts = CompanyDataLoader.csvToEnvironmentalImpacts(PATH);
        Company google = new Company(101, "Google", 20000);
        Company amazon = new Company(102, "Amazon", 30000);
        Company yandex = new Company(103, "Yandex", 15000);
        Company apple = new Company(104, "Apple", 10000);
        Company uber = new Company(105, "Uber", 12000);
        List<Company> companies = new ArrayList<>(List.of(google, amazon, yandex, apple, uber, yandex));

        CompanyRepository companyRepository = new CompanyRepository();
        companyRepository.addCompanies(companies);
        StatisticsAggregator statisticsAggregator = new StatisticsAggregator(companyRepository);
        Map<String, Double> totalEmissionByCompany = statisticsAggregator.totalEmissionByCompany(impacts,
                new DateRange(
                        LocalDate.of(2023, 1, 9),
                        LocalDate.of(2023, 2, 6)),
                EmissionType.GAS_EMISSION);
        totalEmissionByCompany.forEach((k, v) -> System.out.println(k + ": " + v));

        EnvironmentalImpactAnalyzer analyzer = new EnvironmentalImpactAnalyzer(companyRepository, statisticsAggregator);
        System.out.println("\nОбъем выбросов парниковых газов Google по месяцам за последний год");
        analyzer.emissionsReport(PATH, 101, LocalDate.of(2023, 1, 1));

        System.out.println("\nТройку компаний с максимальными выбросами парниковых газов за последний год");
        analyzer.printTopGasEmitters(PATH, LocalDate.of(2023, 1, 1));

        System.out.println("\nВыбросы на одного сотрудника для каждой компании за последний год");
        analyzer.printEmissionsPerEmployee(PATH, LocalDate.of(2023, 1, 1));
    }
}
