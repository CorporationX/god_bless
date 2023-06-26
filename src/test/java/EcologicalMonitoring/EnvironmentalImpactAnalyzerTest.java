package EcologicalMonitoring;

import faang.school.godbless.EcologicalMonitoring.CompanyDataLoader;
import faang.school.godbless.EcologicalMonitoring.EnvironmentalImpact;
import faang.school.godbless.EcologicalMonitoring.EnvironmentalImpactAnalyzer;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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
        SimpleDateFormat pattern = new SimpleDateFormat("yyyy.MM.dd");
        try {
            environmentalImpactAnalyzer.mostImpact("./src/main/java/faang/school/godbless/EcologicalMonitoring/CSVs/overall.csv", pattern.parse("2023.08.08"));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

    }
}
