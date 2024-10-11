package environmental_monitoring;

import lombok.AllArgsConstructor;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
public class EnvironmentalImpactAnalyzer {
    private final CompanyDataLoader dataLoader;
    private final StatisticsAggregator statisticsAggregator;

    public void analyzeEmissions(String fileName, int companyId) {
        List<EnvironmentalImpact> impacts = dataLoader.loadEnvironmentalImpacts(fileName);
        String companyName = getCompanyNameById(companyId);

        String today = "2023.02.15";
        String lastYear = "2022.02.15";

        Map<String, Double> monthlyEmissions = new HashMap<>();
        for (EnvironmentalImpact impact : impacts) {
            if (impact.getCompanyId() == companyId && isWithinDateRange(impact.getDate(), lastYear, today)) {
                String monthKey = impact.getDate().substring(0, 7);
                monthlyEmissions.merge(monthKey, impact.getVolume(), Double::sum);
            }
        }

        double totalEmissions = 0.0;
        System.out.println("Company Name: " + companyName);
        System.out.println("Today's date: " + today);
        System.out.println("Month    GasEmission");
        for (int i = 0; i < 12; i++) {
            String monthKey = getPreviousMonthKey(today, i);
            double emissions = monthlyEmissions.getOrDefault(monthKey, 0.0);
            System.out.printf("%s  %.2f%n", monthKey, emissions);
            totalEmissions += emissions;
        }
        System.out.printf("Total    %.2f%n", totalEmissions);
    }

    private boolean isWithinDateRange(String date, String startDate, String endDate) {
        return date.compareTo(startDate) >= 0 && date.compareTo(endDate) <= 0;
    }

    private String getPreviousMonthKey(String currentDate, int monthsAgo) {
        String[] parts = currentDate.split("\\.");
        int year = Integer.parseInt(parts[0]);
        int month = Integer.parseInt(parts[1]);

        month -= monthsAgo;
        if (month <= 0) {
            month += 12;
            year -= 1;
        }

        return String.format("%04d.%02d", year, month);
    }

    private String getCompanyNameById(int companyId) {
        return "EcoCompany " + companyId;
    }
}
