package environmental_monitoring;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ComparisonAnalyzerTest {
    @Test
    void compareCompanies() {
        ComparisonAnalyzer analyzer = new ComparisonAnalyzer();

        PrintStream originalOut = System.out;
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        analyzer.compareCompanies("environmental_impact_100.csv");

        assertEquals(
                """
                        Some Company 103     798852.0700000001    66571.00583333334    12520.76           \s
                        Some Company 102     770495.5700000001    64207.96416666667    10319.13           \s
                        Some Company 105     725193.43            60432.785833333335   14691.97           \s
                        """,
                outContent.toString()
        );

        System.setOut(originalOut);
    }
}