package school.faang.stream2.ecomonitoring;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
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
        Map<String, Double> emissionsOnPeriodByCompanyName = StatisticsAggregator.calculateEmissionOnPeriod(
                LocalDate.of(2022, 03, 01),
                LocalDate.of(2023, 03, 01),
                environmentalImpacts,
                PolutionType.GAS_EMISSION
        );
        System.out.println(emissionsOnPeriodByCompanyName);

        calculateAndPrintAnnualEmission(CSV, 101);

        calculateAndPrint3MostImpactors(CSV, LocalDate.of(2022, 12, 25));

        calculateAndPrintAnnualEmissionsPerEmployee(LocalDate.of(2022, 12, 25));

    }

    public static void calculateAndPrintAnnualEmission(String filePath, int companyId) {
        LocalDate endOfPeriod = LocalDate.of(2023, 2, 1);
        calculateAndPrintAnnualEmission(filePath, companyId, endOfPeriod);
    }

    public static void calculateAndPrintAnnualEmission(String filePath, int companyId, LocalDate endOfPeriod) {
        int yearsToSubtract = 1;
        String companyName = COMPANY_LIST
                .findByCompanyId(companyId)
                .map(Company::getCompanyName)
                .orElse("UNDEFINED");

        System.out.printf("\nCompany name: %s\n", companyName);
        System.out.printf("Today's date: %s\n", endOfPeriod);
        System.out.println("Month:        GasEmission:");

        Map<YearMonth, Double> emissionsByYearMonth = getEmissionForCompanyByYearMonth(
                filePath,
                companyId,
                endOfPeriod,
                yearsToSubtract);

        emissionsByYearMonth
                .forEach((key, value) -> System.out.printf("%s       %s\n", key, value));
    }

    public static void calculateAndPrint3MostImpactors(String filePath, LocalDate endOfPeriodDate) {
        final int yearsToSubtract = 1;
        final String column1 = "Сompany         ";
        final String column2 = "TotalGasEmission  ";
        final String column3 = "AvgGasEmission/Month  ";
        final String column4 = "MinGasEmission/Month";
        System.out.println("\n" + column1 + column2 + column3 + column4);

        List<EnvironmentalImpact> environmentalImpacts = CompanyDataLoader.parseEnvImpactsCsv(filePath);

        Map<String, Double> most3Impactors = StatisticsAggregator.calculateEmissionOnPeriod(
                endOfPeriodDate.minusYears(yearsToSubtract),
                endOfPeriodDate,
                environmentalImpacts,
                PolutionType.GAS_EMISSION)
                .entrySet().stream()
                .sorted(Comparator.comparingDouble(Map.Entry<String, Double>::getValue).reversed())
                .limit(3)
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue
                ));

        Map<String, Double> minimalMonthEmissionByCompany = most3Impactors.keySet().stream()
                .map(COMPANY_LIST::findByCompanyName)
                .flatMap(Optional::stream)
                .collect(Collectors.toMap(
                        Company::getCompanyName,
                        company -> getEmissionForCompanyByYearMonth(CSV, company.getId(), endOfPeriodDate,
                                yearsToSubtract)
                                .values().stream()
                                .min(Comparator.comparingDouble(Double::valueOf))
                                .orElse(0.0)
                ));

        most3Impactors.forEach((key, value) -> {
            String average = String.format("%.2f", value / 12.0);
            String monthly = String.format("%.2f", value);
            final int spaceHolders = 7; //4 arguments + 3 separators
            System.out.printf("%s".repeat(spaceHolders) + "\n",
                    key, " ".repeat(column1.length() - key.length()),
                    value, " ".repeat(column2.length() - monthly.length()),
                    average, " ".repeat(column3.length() - average.length()),
                    minimalMonthEmissionByCompany.get(key)
            );
        });

    }


    public static void calculateAndPrintAnnualEmissionsPerEmployee(LocalDate endOfPeriodDate) {
        String column1 = "Company         ";
        String column2 = "TotalGasEmission  ";
        String column3 = "Employees   ";
        String column4 = "GasEmissionPerEmployee";
        System.out.println("\n" + column1 + column2 + column3 + column4);

        Map<String, Double> annualEmissionsByCompanyName = StatisticsAggregator.calculateEmissionOnPeriod(
                endOfPeriodDate.minusYears(1),
                endOfPeriodDate,
                CompanyDataLoader.parseEnvImpactsCsv(CSV),
                PolutionType.GAS_EMISSION
        );

        annualEmissionsByCompanyName.forEach((key, value) -> {
            Integer numberOfEmployees = COMPANY_LIST.findByCompanyName(key)
                    .map(Company::getTotalEmployees)
                    .orElse(1);
            String employees = String.valueOf(numberOfEmployees);
            String forEmployee = String.format("%.2f", value / numberOfEmployees);
            final int spaceHolders = 7; //4 arguments + 3 separators
            System.out.printf("%s".repeat(spaceHolders) + "\n",
                    key, " ".repeat(column1.length() - key.length()),
                    value, " ".repeat(column2.length() - String.valueOf(value).length()),
                    employees, " ".repeat(column3.length() - employees.length()),
                    forEmployee
            );
        });

    }

    private static Map<YearMonth, Double> getEmissionForCompanyByYearMonth(String filePath,
                                                                           int companyId,
                                                                           LocalDate endOfPeriod,
                                                                           int yearsToSubtract) {
        return CompanyDataLoader.parseEnvImpactsCsv(filePath).stream()
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
    }
}
