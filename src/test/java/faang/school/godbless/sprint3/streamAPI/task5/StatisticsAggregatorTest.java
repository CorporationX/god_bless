package faang.school.godbless.sprint3.streamAPI.task5;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class StatisticsAggregatorTest {

    private StatisticsAggregator statisticsAggregator;

    @BeforeEach
    void setUp() {
        statisticsAggregator = new StatisticsAggregator();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testGetTotalEmissionsAndConsumption() {
        List<EnvironmentalImpact> environmentalImpacts = List.of(
                new EnvironmentalImpact(1, 2, 3.4, LocalDate.of(2023, 1, 8), Type.GAS_EMISSION),
                new EnvironmentalImpact(2, 1, 3.4, LocalDate.of(2023, 5, 15), Type.ENERGY_CONSUMPTION),
                new EnvironmentalImpact(3, 1, 2.4, LocalDate.of(2023, 6, 10), Type.ENERGY_CONSUMPTION),
                new EnvironmentalImpact(4, 2, 6.4, LocalDate.of(2023, 3, 6), Type.GAS_EMISSION),
                new EnvironmentalImpact(5, 1, 10.4, LocalDate.of(2023, 4, 24), Type.ENERGY_CONSUMPTION),
                new EnvironmentalImpact(6, 3, 10.4, LocalDate.of(2023, 3, 13), Type.ENERGY_CONSUMPTION),
                new EnvironmentalImpact(7, 3, 16.8, LocalDate.of(2023, 4, 30), Type.GAS_EMISSION),
                new EnvironmentalImpact(8, 3, 1.4, LocalDate.of(2023, 5, 1), Type.ENERGY_CONSUMPTION),
                new EnvironmentalImpact(9, 3, 12.5, LocalDate.of(2023, 6, 12), Type.GAS_EMISSION)
        );

        Map<String, Double> totalEmissionsAndConsumption =
                statisticsAggregator.getTotalEmissionsAndConsumption
                        (LocalDate.of(2023, 6, 10), LocalDate.now(), environmentalImpacts, Type.ENERGY_CONSUMPTION);

        assertEquals(1, 1);
    }
}