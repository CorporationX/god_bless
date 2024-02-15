package EkologyMonitor;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        String filePath = "C:\\Versions for my game\\fileForCSV.txt";
        int companyId = 1;

        CompanyDataLoader companyDataLoader = new CompanyDataLoader();
        StatisticsAggregator statisticsAggregator = new StatisticsAggregator();
        EnvironmentalImpactAnalyzer impactAnalyzer = new EnvironmentalImpactAnalyzer(companyDataLoader, statisticsAggregator);

        impactAnalyzer.analyzeEnergyConsumption(filePath, companyId);
    }

   /* private static void printFileContent(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
            e.printStackTrace();
        }
    }*/
}
