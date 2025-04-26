package school.faang.stream2.ecomonitoring;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class EnvironmentalImpactAnalyzer {
    private static final String CSV = "C:/Users/Aleksandr/IdeaProjects/environmental_impact_100.csv";
    public static final CompanyList COMPANY_LIST = CompanyList.of(
            new Company(101, "Zetatech", 12074),
            new Company(102, "Militech", 683410),
            new Company(103, "Biotechnica", 36256),
            new Company(104, "Arasaka", 1145933),
            new Company(105, "Petrochem", 338187)
    );

    public static void main(String[] args) {
        List<EnvironmentalImpact> environmentalImpacts = CompanyDataLoader.parseEnvImpactsCsv(CSV);
        Map<String, Double> stringDoubleMap = StatisticsAggregator.calculateEmissionOnPeriod(
                LocalDate.of(2022, 03, 01),
                LocalDate.of(2023, 03, 01),
                environmentalImpacts,
                PolutionType.GAS_EMISSION
        );
        System.out.println(stringDoubleMap);

        calculateAndPrintAnnualEmission(CSV, 101);

    }

    public static void calculateAndPrintAnnualEmission(String filePath, int companyId) {
        LocalDate endOfPeriod = LocalDate.of(2023, 2, 1);
        int yearsToSubtract = 1;
        String companyName = COMPANY_LIST
                .findByCompanyId(companyId)
                .map(Company::getCompanyName)
                .orElse("UNDEFINED");

        System.out.printf("\nCompany name: %s\n", companyName);
        System.out.printf("Today's date: %s\n", endOfPeriod);
        System.out.println("Month:        GasEmission:");

        Map<YearMonth, Double> collectByMonthForCompany = CompanyDataLoader.parseEnvImpactsCsv(filePath).stream()
                .filter(envImpEvent ->
                        companyId == envImpEvent.getCompanyId())
                .filter(envImpEvent ->
                        endOfPeriod
                                .minusYears(yearsToSubtract)
                                .isBefore(envImpEvent.getDate()))
                .collect(Collectors.groupingBy(
                        impact -> YearMonth.from(impact.getDate()),
                        TreeMap::new,
                        Collectors.summingDouble(EnvironmentalImpact::getVolume)
                ));

        collectByMonthForCompany
                .forEach((key, value) -> System.out.printf("%s       %s\n", key, value));
    }
}
