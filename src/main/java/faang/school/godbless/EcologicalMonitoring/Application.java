package faang.school.godbless.EcologicalMonitoring;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public class Application {
    public static void main(String[] args) {
        EnvironmentalImpactAnalyzer environmentalImpactAnalyzer = new EnvironmentalImpactAnalyzer();
        System.out.println("Analyze");
        environmentalImpactAnalyzer.analyze("./src/main/java/faang/school/godbless/EcologicalMonitoring/CSVs/overall.csv", 1);
        System.out.println();
        System.out.println("Most impact companies");
        environmentalImpactAnalyzer.mostImpact("./src/main/java/faang/school/godbless/EcologicalMonitoring/CSVs/overall.csv", LocalDate.of(2023, 8, 8));
        System.out.println();
        System.out.println("Average consumption per employee");
        environmentalImpactAnalyzer.averageEnergy("./src/main/java/faang/school/godbless/EcologicalMonitoring/CSVs/overall.csv", LocalDate.of(2023, 8, 8));
        System.out.println();
        System.out.println("Aggregator test");
        CompanyDataLoader dataLoader = new CompanyDataLoader();
        List<EnvironmentalImpact> environmentalImpacts = dataLoader.dataLoad("./src/main/java/faang/school/godbless/EcologicalMonitoring/CSVs/overall.csv");
        StatisticsAggregator statisticsAggregator = new StatisticsAggregator();
        Map<String, Double> result = statisticsAggregator.aggregate(LocalDate.of(2023,1,1),
                LocalDate.of(2023,6,1), environmentalImpacts, EType.ENERGY_CONSUMPTION);

        System.out.println(result);
    }
}
