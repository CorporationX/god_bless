package EcologicalMonitoring;

import faang.school.godbless.EcologicalMonitoring.CompanyDataLoader;
import faang.school.godbless.EcologicalMonitoring.EnvironmentalImpact;
import faang.school.godbless.EcologicalMonitoring.EnvironmentalImpactAnalyzer;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EnvironmentalImpactAnalyzerTest {
    EnvironmentalImpactAnalyzer environmentalImpactAnalyzer = new EnvironmentalImpactAnalyzer();

    @Test
    void analyzeTest() {
        environmentalImpactAnalyzer.analyze("./src/main/java/faang/school/godbless/EcologicalMonitoring/CSVs/overall.csv", 1);
    }

    @Test
    void mostImpactTest() {
        environmentalImpactAnalyzer.mostImpact("./src/main/java/faang/school/godbless/EcologicalMonitoring/CSVs/overall.csv", LocalDate.of(2023, 8, 8));
    }

    @Test
    void averageEnergyTest() {
        environmentalImpactAnalyzer.averageEnergy("./src/main/java/faang/school/godbless/EcologicalMonitoring/CSVs/overall.csv", LocalDate.of(2023, 8, 8));
    }
}
