package school.faang.bjs2_80812;

import java.io.IOException;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        List<Company> companies = List.of(
                new Company(101, "EcoCompany", 14000),
                new Company(102, "PollutingCo", 11815),
                new Company(103, "GreenCompany", 13200),
                new Company(104, "SuperCompany", 14580),
                new Company(105, "NeutralCorp", 10000)
        );

        CompanyDataLoader dataLoader = new CompanyDataLoader();
        EnvironmentalImpactAnalyzer analyzer = new EnvironmentalImpactAnalyzer(dataLoader, companies);

        String filename = "environmental_impact_100.csv";

        try {
            System.out.println("=== Анализ выбросов по месяцам ===");
            analyzer.printMonthlyEmissions(filename, 101);

            System.out.println("\n=== Топ-3 компании по выбросам за год ===");
            analyzer.printTopCompanies(filename);

            System.out.println("\n=== Выбросы на одного сотрудника ===");
            analyzer.printEmissionsPerEmployee(filename);

        } catch (IOException e) {
            System.err.println("Ошибка при работе с файлом: " + e.getMessage());
        }
    }
}
