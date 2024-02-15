package Test;

import java.time.LocalDate;

public class Main {
    public static void main(String args[]) {
        EnvironmentalImpactAnalyzer analyzer = new EnvironmentalImpactAnalyzer();

        String fileName = "C:\\Versions for my game\\fileForCSV.txt";
        LocalDate currentDate = LocalDate.now();

        analyzer.analyzeEnvironmentalImpactByCompanyAndType(fileName, currentDate, EnvironmentalImpactType.ENERGY_CONSUMPTION);
        analyzer.analyzeTopEnvironmentalImpacts(fileName, currentDate);
    }
}
