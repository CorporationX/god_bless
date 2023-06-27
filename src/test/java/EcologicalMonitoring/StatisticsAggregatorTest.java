package EcologicalMonitoring;

import faang.school.godbless.EcologicalMonitoring.*;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;

public class StatisticsAggregatorTest {


    @Test
    void aggregateTest() {
        CompanyDataLoader dataLoader = new CompanyDataLoader();
        List<EnvironmentalImpact> environmentalImpacts = dataLoader.dataLoad("./src/main/java/faang/school/godbless/EcologicalMonitoring/CSVs/overall.csv");
        StatisticsAggregator statisticsAggregator = new StatisticsAggregator();
        Map<String, Double> result = statisticsAggregator.aggregate(LocalDate.of(2023,1,1),
                    LocalDate.of(2023,6,1), environmentalImpacts, EType.ENERGY_CONSUMPTION);

        System.out.println(result);
    }
}
