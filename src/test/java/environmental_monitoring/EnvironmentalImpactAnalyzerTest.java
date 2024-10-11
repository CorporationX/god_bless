package environmental_monitoring;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class EnvironmentalImpactAnalyzerTest {
    @Test
    void analyzeEmissions() {
        CompanyDataLoader dataLoader = new CompanyDataLoader();
        EnvironmentalImpactAnalyzer analyzer = new EnvironmentalImpactAnalyzer(dataLoader, new StatisticsAggregator());

        PrintStream originalOut = System.out;
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        analyzer.analyzeEmissions("environmental_impact_100.csv", 101);

        assertEquals(
                """
                        Company Name: EcoCompany 101
                        Today's date: 2023.02.15
                        Month    GasEmission
                        2023.02  78354,34
                        2023.01  75324,84
                        2022.12  12545,53
                        2022.11  115703,19
                        2022.10  98197,70
                        2022.09  86485,31
                        2022.08  87594,19
                        2022.07  52049,44
                        2022.06  30701,68
                        2022.05  26243,95
                        2022.04  0,00
                        2022.03  0,00
                        Total    663200,17
                        """,
                outContent.toString()
        );

        System.setOut(originalOut);
    }
}