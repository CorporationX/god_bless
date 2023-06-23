package faang.school.godbless.sprint3.streamAPI.task5;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.LocalDate;

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
        String expected = "Сompany         totalConsumption    avgConsumption/month     minConsumption/month     \r\n" +
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
        EnvironmentalImpactAnalyzer analyzer = new EnvironmentalImpactAnalyzer();
//        analyzer.printConsumptionEnergyCompany("C:\\IDEA_project\\god_bless\\new.csv", "FuriousCompany");
//        analyzer.printStatisticsConsumptionEnergyCompany("C:\\IDEA_project\\god_bless\\new.csv", LocalDate.now());
        analyzer.printConsumptionPerEmployee("C:\\IDEA_project\\god_bless\\new.csv", LocalDate.now());
    }
}