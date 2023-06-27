package faang.school.godbless.eco_monitoring;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;


public class EnvironmentalImpactAnalyzerTest {
    private EnvironmentalImpactAnalyzer environmentalImpactAnalyzer;

    @BeforeEach
    void setUp(){
        environmentalImpactAnalyzer = new EnvironmentalImpactAnalyzer();
    }

    @Test
    void test(){
        environmentalImpactAnalyzer.printMonthlyEnergyConsumption(
                "src/test/java/faang/school/godbless/eco_monitoring/test.scv", "ABC Company");
        environmentalImpactAnalyzer.printStatisticsConsumptionEnergyPerCompany(
                "src/test/java/faang/school/godbless/eco_monitoring/test.scv", LocalDate.now());
        environmentalImpactAnalyzer.printConsumptionPerEmployee(
                "src/test/java/faang/school/godbless/eco_monitoring/test.scv", LocalDate.now());
    }
}
