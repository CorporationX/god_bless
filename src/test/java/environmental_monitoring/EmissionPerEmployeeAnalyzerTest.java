package environmental_monitoring;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EmissionPerEmployeeAnalyzerTest {

    @Test
    void analyzeEmissionsPerEmployee() {
        List<Company> companies = List.of(new Company(101, "EcoCompany", 100), new Company(102, "PollutingCo", 200));
        EmissionPerEmployeeAnalyzer emissionPerEmployeeAnalyzer = new EmissionPerEmployeeAnalyzer();

        PrintStream originalOut = System.out;
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        emissionPerEmployeeAnalyzer.analyzeEmissionsPerEmployee("environmental_impact_100.csv", companies);

        assertEquals(
                """
                        Company              TotalGasEmission     Employees            GasEmissionPerEmployee
                        EcoCompany           663200.17            100                  6632.001700000001  \s
                        PollutingCo          770495.5700000001    200                  3852.47785         \s
                        """,
                outContent.toString()
        );

        System.setOut(originalOut);
    }
}