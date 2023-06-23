package faang.school.godbless.sprint3.streamAPI.task5;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EnvironmentalImpactAnalyzerTest {

    private EnvironmentalImpactAnalyzer environmentalImpactAnalyzer;

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    private PrintStream originalOut;

    @BeforeEach
    void setUp() {
        environmentalImpactAnalyzer = new EnvironmentalImpactAnalyzer();
        originalOut = System.out;
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    void tearDown() {
        System.setOut(originalOut);
    }

    @Test
    void printConsumptionEnergyCompany() {
        String expected = "CompanyName: FuriousCompany\r\n" +
                "Today's date: 2023-06-23\r\n" +
                "Month     EnergyConsumption\r\n" +
                "2023.06   15345.42         \r\n" +
                "2023.05   10009.79         \r\n" +
                "2023.04   8051.21          \r\n" +
                "2023.03   8116.8           \r\n" +
                "2023.02   12646.79         \r\n" +
                "2023.01   15733.36         \r\n" +
                "2022.12   9997.05          \r\n" +
                "2022.11   14385.51         \r\n" +
                "2022.10   12103.33         \r\n" +
                "2022.09   11603.4          \r\n" +
                "2022.08   13087.79         \r\n" +
                "2022.07   7108.54          \r\n" +
                "Total     138188.99\r\n";

        environmentalImpactAnalyzer.printConsumptionEnergyCompany("new.csv", "FuriousCompany");

        assertEquals(expected, outContent.toString());
    }

    @Test
    void printStatisticsConsumptionEnergyCompany() {
        String expected = "Company         totalConsumption    avgConsumption/month     minConsumption/month     \r\n" +
                "FuriousCompany  138188.99           11515.75                 7108.54                  \r\n" +
                "AwesomeCompany  55886.17            4657.18                  0.0                      \r\n" +
                "SuperCompany    82302.82            6858.57                  0.0                      \r\n";

        environmentalImpactAnalyzer.printStatisticsConsumptionEnergyCompany("new.csv", LocalDate.now());

        assertEquals(expected, outContent.toString());
    }

    @Test
    void printConsumptionPerEmployee() {
        String expected = "Сompany         TotalEnergyConsumption   Employees ConsumptionPerEmployee   \r\n" +
                "FuriousCompany  138188.99                11815     11.7                     \r\n" +
                "AwesomeCompany  55886.17                 9846      5.68                     \r\n" +
                "SuperCompany    82302.82                 14580     5.64                     \r\n";

        environmentalImpactAnalyzer.printConsumptionPerEmployee("new.csv", LocalDate.now());

        assertEquals(expected, outContent.toString());
    }

    public static void main(String[] args) {
        List<EnvironmentalImpact> environmentalImpacts = List.of(
                new EnvironmentalImpact(1, 1, 15345.42, LocalDate.of(2023, 6, 8), Type.ENERGY_CONSUMPTION),
                new EnvironmentalImpact(2, 1, 10009.79, LocalDate.of(2023, 5, 8), Type.ENERGY_CONSUMPTION),
                new EnvironmentalImpact(3, 1, 8051.21, LocalDate.of(2023, 4, 8), Type.ENERGY_CONSUMPTION),
                new EnvironmentalImpact(4, 1, 8116.80, LocalDate.of(2023, 3, 8), Type.ENERGY_CONSUMPTION),
                new EnvironmentalImpact(5, 1, 12646.79, LocalDate.of(2023, 2, 8), Type.ENERGY_CONSUMPTION),
                new EnvironmentalImpact(6, 1, 15733.36, LocalDate.of(2023, 1, 8), Type.ENERGY_CONSUMPTION),
                new EnvironmentalImpact(7, 1, 9997.05, LocalDate.of(2022, 12, 8), Type.ENERGY_CONSUMPTION),
                new EnvironmentalImpact(8, 1, 14385.51, LocalDate.of(2022, 11, 8), Type.ENERGY_CONSUMPTION),
                new EnvironmentalImpact(9, 1, 12103.33, LocalDate.of(2022, 10, 8), Type.ENERGY_CONSUMPTION),
                new EnvironmentalImpact(10, 1, 11603.40, LocalDate.of(2022, 9, 8), Type.ENERGY_CONSUMPTION),
                new EnvironmentalImpact(11, 1, 13087.79, LocalDate.of(2022, 8, 8), Type.ENERGY_CONSUMPTION),
                new EnvironmentalImpact(12, 1, 7108.54, LocalDate.of(2022, 7, 8), Type.ENERGY_CONSUMPTION),
                new EnvironmentalImpact(13, 2, 15345.42, LocalDate.of(2023, 6, 8), Type.ENERGY_CONSUMPTION),
                new EnvironmentalImpact(14, 2, 10009.79, LocalDate.of(2023, 5, 8), Type.ENERGY_CONSUMPTION),
                new EnvironmentalImpact(15, 3, 8051.21, LocalDate.of(2023, 4, 8), Type.ENERGY_CONSUMPTION),
                new EnvironmentalImpact(16, 2, 8116.80, LocalDate.of(2023, 3, 8), Type.ENERGY_CONSUMPTION),
                new EnvironmentalImpact(17, 3, 12646.79, LocalDate.of(2023, 2, 8), Type.ENERGY_CONSUMPTION),
                new EnvironmentalImpact(18, 2, 15733.36, LocalDate.of(2023, 1, 8), Type.ENERGY_CONSUMPTION),
                new EnvironmentalImpact(19, 3, 9997.05, LocalDate.of(2022, 12, 8), Type.ENERGY_CONSUMPTION),
                new EnvironmentalImpact(20, 2, 14385.51, LocalDate.of(2022, 11, 8), Type.ENERGY_CONSUMPTION),
                new EnvironmentalImpact(21, 3, 12103.33, LocalDate.of(2022, 10, 8), Type.ENERGY_CONSUMPTION),
                new EnvironmentalImpact(22, 2, 11603.40, LocalDate.of(2022, 9, 8), Type.ENERGY_CONSUMPTION),
                new EnvironmentalImpact(23, 3, 13087.79, LocalDate.of(2022, 8, 8), Type.ENERGY_CONSUMPTION),
                new EnvironmentalImpact(24, 2, 7108.54, LocalDate.of(2022, 7, 8), Type.ENERGY_CONSUMPTION)
        );
        CompanyDataLoader companyDataLoader = new CompanyDataLoader();
        companyDataLoader.writeCSV(environmentalImpacts, "new.csv");

        List<EnvironmentalImpact> environmentalImpacts1 = companyDataLoader.readCSV("new.csv");
        environmentalImpacts1.forEach(System.out::println);
    }
}