package faang.school.godbless.eco_monitoring;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EnvironmentalImpactAnalyzer {

    public void printMonthlyEnergyConsumption(String path, String companyName){
        LocalDate end = LocalDate.now();
        Map<String, Double> monthlyStatistics = getMonthlyEnergyConsumption(path, companyName, end);
        System.out.println("CompanyName: " + companyName + "\n" +
                "Today's date: " + end + "\n" +
                "Month        EnergyConsumption");

        double totalConsumption = 0.0;
        for (Map.Entry<String, Double> entry : monthlyStatistics.entrySet()) {
            System.out.printf("%-13s %s%n", entry.getKey(), entry.getValue());
            totalConsumption += entry.getValue();
        }
        System.out.println("Total:     " + totalConsumption);
    }

    public void printStatisticsConsumptionEnergyPerCompany(String path, LocalDate end) {

        LocalDate start = end.minusYears(1);
        List<EnvironmentalImpact> environmentalImpacts = CompanyDataLoader.loadData(path);

        Map<String, Double> totalEmissionsAndConsumption =
                StatisticsAggregator.getStatistics(start, end, environmentalImpacts, ImpactType.ENERGY_CONSUMPTION);

        for (Map.Entry<String, Double> entry : totalEmissionsAndConsumption.entrySet()) {
            String companyName = entry.getKey();
            double totalEnergyConsumption = entry.getValue();
            double avgEnergyConsumption = Math.round((entry.getValue() / 12) * 100) / 100.0;
            double minConsumption = Double.MAX_VALUE;

            Map<String, Double> statPerMonth = getMonthlyEnergyConsumption(path, entry.getKey(), end);

            for (Map.Entry<String, Double>  entryStatPerMonth : statPerMonth.entrySet()) {
                if (entryStatPerMonth.getValue() < minConsumption) {
                    minConsumption = entryStatPerMonth.getValue();
                }
            }

            System.out.println(companyName +": " + "\n total: " + totalEnergyConsumption + "\n avg: "
                    + avgEnergyConsumption + "\n min: " + minConsumption);
        }
    }

    public void printConsumptionPerEmployee(String path, LocalDate end) {
        LocalDate start = end.minusYears(1);
        List<EnvironmentalImpact> environmentalImpacts = CompanyDataLoader.loadData(path);
        Map<String, Double> totalEmissionsAndConsumption =
                StatisticsAggregator.getStatistics(start, end, environmentalImpacts, ImpactType.ENERGY_CONSUMPTION);

        for (Map.Entry<String, Double> entry : totalEmissionsAndConsumption.entrySet()) {
            String companyName = entry.getKey();
            double totalEnergyConsumption = entry.getValue();
            int employees = Company.companies.stream()
                    .filter(x -> x.getName().equals(companyName))
                    .map(Company::getEmployeeQuantity)
                    .toList()
                    .get(0);
            double consumptionPerEmployee = Math.round((totalEnergyConsumption / employees) * 100) / 100.0;

            System.out.println(companyName + ":\n total " + totalEnergyConsumption + ":\n employee quantity " +
                    employees + ":\n per employee " + consumptionPerEmployee);
        }
    }


    public Map<String, Double> getMonthlyEnergyConsumption(String path, String companyName, LocalDate end){
        List<EnvironmentalImpact> environmentalImpacts = CompanyDataLoader.loadData(path);

        if (!companyExists(companyName)) {
            throw new IllegalArgumentException(companyName + " not in the list");
        }

        LocalDate start = end.withDayOfMonth(1);

        Map<String, Double> montlyStatistics = new HashMap<>();
        for (int i = 0; i < 12; i++) {
            Map<String, Double> yearlyData =
                    StatisticsAggregator.getStatistics(start, end, environmentalImpacts, ImpactType.ENERGY_CONSUMPTION);
            Double montlyData = yearlyData.get(companyName);
            if (montlyData == null) {
                montlyData = 0.0;
            }
            String date = start.format(DateTimeFormatter.ofPattern("yyyy.MM"));

            montlyStatistics.put(date, montlyData);
            end = start.minusDays(1);
            start = start.minusMonths(1);
        }

        return montlyStatistics;
    }

    private boolean companyExists(String companyName){
        return Company.companies.stream()
                .map(Company::getName)
                .toList()
                .contains(companyName);
    }
}
