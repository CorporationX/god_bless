package school.faang.bjs2_80821;

import java.time.LocalDate;
import java.util.List;

public class Main {
    public static final String PATH = "src/main/java/school/faang/bjs2_80821/environmental_impact_100.csv";

    public static void main(String[] args) {
        CompanyDataLoader dataLoader = new CompanyDataLoader();
        StatisticsAggregator statisticsAggregator = new StatisticsAggregator();
        EnvironmentalImpactAnalyzer analyzer = new EnvironmentalImpactAnalyzer(
                dataLoader, statisticsAggregator
        );

        analyzer.analyzeTopEnvironmentalImpacts(
                PATH,
                LocalDate.now().minusYears(5),
                LocalDate.now()
        );

        analyzer.printMonthlyReport(PATH, 101);
        analyzer.printPerEmployeeEmission(
                PATH,
                LocalDate.now().minusYears(3),
                LocalDate.now(),
                List.of(
                        new Company(101, "test1", 10),
                        new Company(102, "test2", 1),
                        new Company(103, "test3", 4)
                ),
                ExposureType.GAS_EMISSION
        );
    }
}
