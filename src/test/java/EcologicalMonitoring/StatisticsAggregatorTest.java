package EcologicalMonitoring;

import faang.school.godbless.EcologicalMonitoring.*;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class StatisticsAggregatorTest {


    @Test
    void aggregateTest() {
        CompanyDataLoader dataLoader = new CompanyDataLoader();
        List<EnvironmentalImpact> environmentalImpacts = dataLoader.dataLoad("./src/main/java/faang/school/godbless/EcologicalMonitoring/CSVs/overall.csv");
        StatisticsAggregator statisticsAggregator = new StatisticsAggregator();
        SimpleDateFormat pattern = new SimpleDateFormat("yyyy.MM.dd");
        Map<String, Double> result;

        try {
            result = statisticsAggregator.aggregate(pattern.parse("2023.01.01"),
                    pattern.parse("2023.06.01"), environmentalImpacts, EType.ENERGY_CONSUMPTION);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        System.out.println(result);
    }
}
