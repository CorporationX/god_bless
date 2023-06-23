package faang.school.godbless.sprint3.streamAPI.task5;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class EnvironmentalImpactAnalyzer {

    private final CompanyDataLoader companyDataLoader;

    private final StatisticsAggregator statisticsAggregator;


    public EnvironmentalImpactAnalyzer() {
        companyDataLoader = new CompanyDataLoader();
        statisticsAggregator = new StatisticsAggregator();
    }

    public void printConsumptionEnergyCompany(String pathCSV, String companyName) {
        LocalDate end = LocalDate.now();
        Map<String, Double> statPerMonth = analiseConsumptionEnergyCompanyPerLastYear(pathCSV, companyName, end);

        System.out.println("CompanyName: " + companyName);
        System.out.println("Today's date: " + end);
        System.out.println("Month     EnergyConsumption");

        double totalConsumption = 0.0;
        String format = "%1$-10s%2$-17s";
        for (var entry : statPerMonth.entrySet()) {
            System.out.printf((format) + "%n", entry.getKey(), entry.getValue());
            totalConsumption += entry.getValue();
        }
        System.out.println("Total     " + totalConsumption);
    }

    public void printStatisticsConsumptionEnergyCompany(String pathCSV, LocalDate end) {
        String format = "%1$-16s%2$-20s%3$-25s%4$-25s";
        System.out.printf((format) + "%n", "Сompany", "totalConsumption", "avgConsumption/month", "minConsumption/month");
        LocalDate start = end.minusYears(1);
        List<EnvironmentalImpact> environmentalImpacts = companyDataLoader.readCSV(pathCSV);
        Map<String, Double> totalEmissionsAndConsumption =
                statisticsAggregator.getTotalEmissionsAndConsumption(start, end, environmentalImpacts, Type.ENERGY_CONSUMPTION);
        for (var entry : totalEmissionsAndConsumption.entrySet()) {
            String companyName = entry.getKey();
            double totalEnergyConsumption = entry.getValue();
            double avgEnergyConsumption = Math.round((entry.getValue() / 12) * 100) / 100.0;
            double minConsumption = Double.MAX_VALUE;
            Map<String, Double> statPerMonth = analiseConsumptionEnergyCompanyPerLastYear(pathCSV, entry.getKey(), end);
            for (var entryStatPerMonth : statPerMonth.entrySet()) {
                if (entryStatPerMonth.getValue() < minConsumption) {
                    minConsumption = entryStatPerMonth.getValue();
                }
            }
            System.out.printf((format) + "%n", companyName, totalEnergyConsumption, avgEnergyConsumption, minConsumption);
        }
    }

    public void printConsumptionPerEmployee(String pathCSV, LocalDate end) {
        String format = "%1$-16s%2$-25s%3$-10s%4$-25s";
        LocalDate start = end.minusYears(1);
        List<EnvironmentalImpact> environmentalImpacts = companyDataLoader.readCSV(pathCSV);
        Map<String, Double> totalEmissionsAndConsumption =
                statisticsAggregator.getTotalEmissionsAndConsumption(start, end, environmentalImpacts, Type.ENERGY_CONSUMPTION);

        System.out.printf((format) + "%n", "Сompany", "TotalEnergyConsumption", "Employees", "ConsumptionPerEmployee");

        for (var entry : totalEmissionsAndConsumption.entrySet()) {
            String companyName = entry.getKey();
            double totalEnergyConsumption = entry.getValue();
            int employees = Company.companies.stream()
                    .filter(x -> x.getCompanyName().equals(companyName))
                    .map(Company::getTotalEmployees)
                    .toList()
                    .get(0);
            double consumptionPerEmployee = Math.round((totalEnergyConsumption / employees) * 100) / 100.0;
            System.out.printf((format) + "%n", companyName, totalEnergyConsumption, employees, consumptionPerEmployee);
        }
    }

    private Map<String, Double> analiseConsumptionEnergyCompanyPerLastYear(String pathCSV, String companyName, LocalDate now) {
        List<EnvironmentalImpact> environmentalImpacts = companyDataLoader.readCSV(pathCSV);
        LocalDate end = now;
        if (now == null) {
            end = LocalDate.now();
        }
        LocalDate start = end.withDayOfMonth(1);
        Map<String, Double> statPerMonth = new LinkedHashMap<>();
        for (int i = 0; i < 12; i++) {
            Map<String, Double> totalEmissionsAndConsumption =
                    statisticsAggregator.getTotalEmissionsAndConsumption(start, end, environmentalImpacts, Type.ENERGY_CONSUMPTION);
            Double consumptionPerMonth = totalEmissionsAndConsumption.get(companyName);
            if (consumptionPerMonth == null) {
                consumptionPerMonth = 0.0;
            }
            String date = start.format(DateTimeFormatter.ofPattern("yyyy.MM"));

            statPerMonth.put(date, consumptionPerMonth);
            end = start.minusDays(1);
            start = start.minusMonths(1);
        }

        return statPerMonth;
    }

}
