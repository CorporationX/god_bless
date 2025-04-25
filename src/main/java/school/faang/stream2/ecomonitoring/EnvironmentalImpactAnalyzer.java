package school.faang.stream2.ecomonitoring;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public class EnvironmentalImpactAnalyzer {
    private static final String CSV = "C:/Users/Aleksandr/IdeaProjects/environmental_impact_100.csv";
    public static final List<Company> COMPANY_LIST = List.of(
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

    }

    public static void calculateAnnualEmission(String filePath, int companyId) {

    }
}
