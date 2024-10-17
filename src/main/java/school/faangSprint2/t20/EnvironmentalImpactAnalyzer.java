package school.faangSprint2.t20;

import lombok.Data;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

@Data
public class EnvironmentalImpactAnalyzer {
    private CompanyDataLoader dataLoader;
    private StatisticsAggregator statsAggregator;

    public EnvironmentalImpactAnalyzer(CompanyDataLoader dataLoader, StatisticsAggregator statsAggregator) {
        this.dataLoader = dataLoader;
        this.statsAggregator = statsAggregator;
    }

    public void analyzeEmissions(String filePath, String companyId) {
        List<EnvironmentalImpact> impacts = dataLoader.loadData(filePath);
        Map<String, Double> monthlyEmissions = new TreeMap<>();

        impacts.stream()
                .filter(impact -> impact.getCompanyId().equals(companyId))
                .forEach(impact -> {
                    String monthKey = impact.getDate().format(DateTimeFormatter.ofPattern("yyyy.MM"));
                    monthlyEmissions.merge(monthKey, impact.getVolume(), Double::sum);
                });

        System.out.println("\nCompany ID: " + companyId);
        System.out.println("Today's date: " + LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy.MM.dd")));
        System.out.println("Month\tGasEmission");

        double total = 0;
        for (Map.Entry<String, Double> entry : monthlyEmissions.entrySet()) {
            System.out.printf("%s\t%.2f%n", entry.getKey(), entry.getValue());
            total += entry.getValue();
        }
        System.out.printf("Total\t%.2f%n", total);
    }

    public void compareCompanies(String filePath, LocalDate currentDate) {
        List<EnvironmentalImpact> impacts = dataLoader.loadData(filePath);
        LocalDate startDate = currentDate.minusYears(3);

        Map<String, CompanyStats> companyStats = new HashMap<>();

        impacts.stream()
                .filter(impact -> !impact.getDate().isBefore(startDate)
                        && !impact.getDate().isAfter(currentDate))
                .forEach(impact -> {
                    companyStats.computeIfAbsent(impact.getCompanyId(), k -> new CompanyStats())
                            .addEmission(impact.getVolume());
                });

        List<Map.Entry<String, CompanyStats>> topCompanies = companyStats.entrySet().stream()
                .sorted((e1, e2) -> Double.compare(e2.getValue().getTotal(), e1.getValue().getTotal()))
                .limit(3)
                .toList();

        System.out.println("\nCompany\tTotalGasEm\t\tAvgEm/Month\t\tMinGasEm/Month");
        for (Map.Entry<String, CompanyStats> entry : topCompanies) {
            CompanyStats stats = entry.getValue();
            System.out.printf("%s\t\t%.2f\t\t%.2f\t\t%.2f%n",
                    entry.getKey(),
                    stats.getTotal(),
                    stats.getAverage(),
                    stats.getMin());
        }
    }

    @Data
    private static class CompanyStats {

        private double total = 0;
        private List<Double> monthly = new ArrayList<>();
        private double min = Double.POSITIVE_INFINITY;
        private double max = Double.NEGATIVE_INFINITY;

        public void addEmission(double volume) {
            total += volume;
            monthly.add(volume);
            min = Math.min(min, volume);
            max = Math.max(max, volume);
        }

        public double getAverage() {
            return total / monthly.size();
        }
    }
}