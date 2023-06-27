package faang.school.godbless.sprint3.environment;

import java.time.LocalDate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EnvironmentalImpactAnalyzerTest {
    private EnvironmentalImpactAnalyzer analyzer;

    @BeforeEach
    void setUp() {
        analyzer = new EnvironmentalImpactAnalyzer();
    }

    @Test
    void printEnergyConsumptionByMonths() {
        analyzer.printEnergyConsumptionByMonthsForCompany(
                "src/main/java/faang/school/godbless/sprint3/environment/file.csv",
                "company1"
        );
    }

    @Test
    void printEnergyConsumptionByCompanies() {
        analyzer.printEnergyConsumptionByCompanies(
                "src/main/java/faang/school/godbless/sprint3/environment/file.csv",
                LocalDate.now()
        );
    }

    @Test
    void printStatisticsForEmployeePerYear() {
        analyzer.printStatisticsForEmployeePerYear(
                "src/main/java/faang/school/godbless/sprint3/environment/file.csv",
                LocalDate.now(),
                new Company(1, "company1", 1000)
        );
    }
}