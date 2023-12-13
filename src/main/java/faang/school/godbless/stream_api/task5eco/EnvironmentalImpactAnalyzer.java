package faang.school.godbless.stream_api.task5eco;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
public class EnvironmentalImpactAnalyzer {
    private List<Company> companies;
    private List<EnvironmentalImpact> environmentalImpacts;

    // Дополнительный метод для получения имени компании по её ID
    private String getCompanyNameById(int companyId) {
        return companies.stream()
                .filter(company -> company.getId() == companyId)
                .findFirst()
                .map(Company::getCompanyName)
                .orElse("Unknown Company");
    }

    // Дополнительный метод для фильтрации выбросов по типу и диапазону дат
    public List<EnvironmentalImpact> filterImpactsByTypeAndDate(ImpactType type, Date startDate, Date endDate) {
        return environmentalImpacts.stream()
                .filter(impact -> impact.getType() == type && isDateInRange(impact.getDate(), startDate, endDate))
                .collect(Collectors.toList());
    }



    private boolean isDateInRange(Date date, Date startDate, Date endDate) {
        return !date.before(startDate) && !date.after(endDate);
    }




    public void analyzeEnergyConsumption(String fileName, int companyId) {
        System.out.println("Company Name: " + getCompanyNameById(companyId));
        System.out.println("Today's date: " + new SimpleDateFormat("dd.MM.yyyy").format(new Date()));

        Date currentDate = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(currentDate);
        calendar.add(Calendar.MONTH, -12); // Используем последний год

        List<EnvironmentalImpact> energyConsumptionImpacts = filterImpactsByTypeAndDate(ImpactType.ENERGY_CONSUMPTION, calendar.getTime(), currentDate);


        if (energyConsumptionImpacts.isEmpty()) {
            System.out.println("No energy consumption data found for the specified period.");
            return;
        }

        System.out.println("Month  EnergyConsumption");
        energyConsumptionImpacts.stream()
                .sorted(Comparator.comparing(EnvironmentalImpact::getDate).reversed())
                .forEach(impact -> System.out.printf("%tY.%<tm  %.2f%n", impact.getDate(), impact.getVolume()));

        double totalConsumption = energyConsumptionImpacts.stream().mapToDouble(EnvironmentalImpact::getVolume).sum();
        System.out.println("Total    " + totalConsumption);
    }



    public void analyzeTopConsumers(String fileName, Date currentDate) {
        // Implementation for analyzing top consumers
        List<EnvironmentalImpact> energyConsumptionImpacts = filterImpactsByTypeAndDate(ImpactType.ENERGY_CONSUMPTION, new Date(), currentDate);

        Map<String, Double> aggregatedData = StatisticsAggregator.aggregateEnvironmentalImpacts(energyConsumptionImpacts, new Date(), currentDate, ImpactType.ENERGY_CONSUMPTION);

        System.out.println("Company         totalConsumption  avgConsumption/month  minConsumption/month");
        aggregatedData.entrySet().stream()
                .sorted(Map.Entry.<String, Double>comparingByValue().reversed())
                .limit(3)
                .forEach(entry -> {
                    String companyName = getCompanyNameById(Integer.parseInt(entry.getKey()));
                    double totalConsumption = entry.getValue();
                    double avgConsumptionPerMonth = totalConsumption / (energyConsumptionImpacts.size() / 12.0);
                    double minConsumption = energyConsumptionImpacts.stream().mapToDouble(EnvironmentalImpact::getVolume).min().orElse(0);

                    System.out.printf("%-15s  %-15.2f  %-20.2f  %.2f%n", companyName, totalConsumption, avgConsumptionPerMonth, minConsumption);
                });
    }

    public void analyzeEnergyPerEmployee(String fileName, Date currentDate) {
        // Implementation for analyzing energy per employee
        List<EnvironmentalImpact> energyConsumptionImpacts = filterImpactsByTypeAndDate(ImpactType.ENERGY_CONSUMPTION, new Date(), currentDate);

        Map<String, Double> aggregatedData = StatisticsAggregator.aggregateEnvironmentalImpacts(energyConsumptionImpacts, new Date(), currentDate, ImpactType.ENERGY_CONSUMPTION);

        System.out.println("Company            TotalEnergyConsumption Employees ConsumptionPerEmployee");
        aggregatedData.entrySet().stream()
                .sorted(Map.Entry.<String, Double>comparingByValue().reversed())
                .forEach(entry -> {
                    String companyName = getCompanyNameById(Integer.parseInt(entry.getKey()));
                    double totalConsumption = entry.getValue();
                    int totalEmployees = companies.stream().filter(company -> company.getId() == Integer.parseInt(entry.getKey())).findFirst().map(Company::getTotalEmployees).orElse(0);
                    double consumptionPerEmployee = totalEmployees > 0 ? totalConsumption / totalEmployees : 0;

                    System.out.printf("%-15s  %-15.2f  %-8d  %.2f%n", companyName, totalConsumption, totalEmployees, consumptionPerEmployee);
                });
    }

    private Map<String, Double> aggregateEnvironmentalImpacts(List<EnvironmentalImpact> impacts, Date startDate, Date endDate, ImpactType type) {
        Map<String, Double> result = new HashMap<>();

        for (EnvironmentalImpact impact : impacts) {
            if (impact.getType() == type) {
                String companyId = Integer.toString(impact.getCompanyId());
                result.merge(companyId, impact.getVolume(), Double::sum);
            }
        }

        return result;
    }

    public void printCompanyImpacts(int companyId) {
        List<EnvironmentalImpact> companyImpacts = filterImpactsByCompanyId(companyId);
        companyImpacts.forEach(System.out::println);
    }

    public List<EnvironmentalImpact> filterImpactsByCompanyId(int companyId) {
        return environmentalImpacts.stream()
                .filter(impact -> impact.getCompanyId() == companyId)
                .collect(Collectors.toList());
    }

}

