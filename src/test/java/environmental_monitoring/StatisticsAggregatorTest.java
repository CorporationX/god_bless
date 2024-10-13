package environmental_monitoring;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class StatisticsAggregatorTest {

    @Test
    void aggregateStatistics() {
        CompanyDataLoader dataLoader = new CompanyDataLoader();
        List<EnvironmentalImpact> impacts = dataLoader.loadEnvironmentalImpacts("environmental_impact_100.csv");

        StatisticsAggregator statisticsAggregator = new StatisticsAggregator();
        Map<String, Double> companyEmissions = statisticsAggregator.aggregateStatistics(
                LocalDate.parse("2000.01.01", DateFormatter.FULL_DATE_SEPARATED_BY_A_DOT),
                LocalDate.parse("2024.12.31", DateFormatter.FULL_DATE_SEPARATED_BY_A_DOT),
                impacts,
                ImpactType.GAS_EMISSION
        );

        assertEquals(
                "{Some Company 104=608843.01, Some Company 105=725193.4299999998, Some Company 102=770495.57, Some Company 103=798852.0700000001, Some Company 101=663200.17}",
                companyEmissions.toString()
        );
    }
}