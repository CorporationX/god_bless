package school.faang.bjs2_70755;

import java.time.LocalDate;

import static java.time.Month.DECEMBER;
import static school.faang.bjs2_70755.EnvironmentalImpactType.GAS_EMISSION;

public class Main {
    public static void main(String[] args) {
        EnvironmentalImpactAnalyzer analyzer = new EnvironmentalImpactAnalyzer(
                new CompanyDataLoader(),
                new StatisticsAggregator());

        analyzer.analyzeMonthlyEmissions("environmental_impact_100.csv",
                101L,
                LocalDate.of(2022, DECEMBER, 1),
                GAS_EMISSION);

        analyzer.analyzeTopThreeCompanies(
                "environmental_impact_100.csv",
                LocalDate.of(2022, DECEMBER, 1),
                GAS_EMISSION,
                3
        );

        analyzer.analyzeEmissionsPerOneEmployee(
                "environmental_impact_100.csv",
                LocalDate.of(2022, DECEMBER, 1),
                GAS_EMISSION
        );
    }
}
