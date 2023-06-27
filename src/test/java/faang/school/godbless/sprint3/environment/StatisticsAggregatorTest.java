package faang.school.godbless.sprint3.environment;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StatisticsAggregatorTest {
    private StatisticsAggregator aggregator;
    private List<EnvironmentalImpact> impactList;

    @BeforeEach
    void setUp() {
        aggregator = new StatisticsAggregator();

        impactList = List.of(
                new EnvironmentalImpact(
                    1,
                    "company1",
                    10000.0,
                    LocalDate.of(2023, 1, 10),
                    EnvironmentalImpact.Type.ENERGY_CONSUMPTION
                ),
                new EnvironmentalImpact(
                        2,
                        "company1",
                        9000.0,
                        LocalDate.of(2023, 1, 10),
                        EnvironmentalImpact.Type.GAS_EMISSION
                ),
                new EnvironmentalImpact(
                        3,
                        "company2",
                        12000.0,
                        LocalDate.of(2023, 2, 10),
                        EnvironmentalImpact.Type.ENERGY_CONSUMPTION
                ),
                new EnvironmentalImpact(
                        4,
                        "company2",
                        12000.0,
                        LocalDate.of(2023, 3, 10),
                        EnvironmentalImpact.Type.GAS_EMISSION
                ),
                new EnvironmentalImpact(
                        5,
                        "company3",
                        13000.0,
                        LocalDate.of(2023, 3, 10),
                        EnvironmentalImpact.Type.ENERGY_CONSUMPTION
                ),
                new EnvironmentalImpact(
                        6,
                        "company3",
                        14000.0,
                        LocalDate.of(2023, 3, 10),
                        EnvironmentalImpact.Type.GAS_EMISSION
                ),
                new EnvironmentalImpact(
                        7,
                        "company1",
                        12000.0,
                        LocalDate.of(2023, 4, 10),
                        EnvironmentalImpact.Type.ENERGY_CONSUMPTION
                ),
                new EnvironmentalImpact(
                        8,
                        "company1",
                        12000.0,
                        LocalDate.of(2023, 4, 10),
                        EnvironmentalImpact.Type.GAS_EMISSION
                ),
                new EnvironmentalImpact(
                        9,
                        "company2",
                        13000.0,
                        LocalDate.of(2023, 5, 10),
                        EnvironmentalImpact.Type.ENERGY_CONSUMPTION
                ),
                new EnvironmentalImpact(
                        10,
                        "company2",
                        13000.0,
                        LocalDate.of(2023, 5, 10),
                        EnvironmentalImpact.Type.GAS_EMISSION
                ),
                new EnvironmentalImpact(
                        11,
                        "company3",
                        13000.0,
                        LocalDate.of(2023, 6, 10),
                        EnvironmentalImpact.Type.ENERGY_CONSUMPTION
                ),
                new EnvironmentalImpact(
                        12,
                        "company3",
                        14000.0,
                        LocalDate.of(2023, 6, 10),
                        EnvironmentalImpact.Type.GAS_EMISSION
                )
        );
    }

    @ParameterizedTest
    @MethodSource("getParams")
    void getImpactStatistics(
            EnvironmentalImpact.Type type,
            LocalDate startDate,
            LocalDate endDate,
            Map<String, Double> expected) {
        Map<String, Double> result = aggregator.getImpactStatistics(impactList, type, startDate, endDate);

        System.out.println(result);

        assertEquals(expected, result);
    }

    static Stream<Arguments> getParams() {
        return Stream.of(
                Arguments.of(
                        EnvironmentalImpact.Type.ENERGY_CONSUMPTION,
                        LocalDate.now().minusYears(1),
                        LocalDate.now(),
                        Map.of("company1", 22000.0, "company2", 25000.0, "company3", 26000.0)
                ),
                Arguments.of(
                        EnvironmentalImpact.Type.GAS_EMISSION,
                        LocalDate.now().minusMonths(3),
                        LocalDate.now(),
                        Map.of("company1", 12000.0, "company2", 13000.0, "company3", 14000.0)
                )
        );
    }
}