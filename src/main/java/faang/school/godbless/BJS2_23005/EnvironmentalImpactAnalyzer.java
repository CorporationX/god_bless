package faang.school.godbless.BJS2_23005;

import java.io.File;
import java.time.LocalDate;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EnvironmentalImpactAnalyzer {

    public static void analyseLastYearForIdCompany(File file, int id) {
        LocalDate lastYear = LocalDate.now().minusYears(1L);
        List<EnvironmentalImpact> impacts = getImpactsFromCsvByFilter(file, impact -> impact.getCompany().getId() == id);
        if (impacts.isEmpty()) {
            return;
        }

        Company company = impacts.get(0).getCompany();
        System.out.printf("Company name: %s\nToday's date: %s\nMonth      EnergyConsumption\n", company.getName(), LocalDate.now());

        Stream.iterate(lastYear, date -> !date.isAfter(LocalDate.now()), date -> date.plusMonths(1L))
                .map(date -> {
                    Map<Company, Double> map = StatisticsAggregator.mapCompanyBySumImpact(
                                    date,
                                    date.plusMonths(1L),
                                    impacts,
                                    TypeEnvironmentalImpact.ENERGY_CONSUMPTION);
                    return new AbstractMap.SimpleEntry<>(date, map.getOrDefault(company, 0D));
                })
                .forEach(entry -> System.out.printf("%s %.2f%n", entry.getKey(), entry.getValue()));
    }

    public static void analyseConsumptionPerEmployee(File file, int year) {
        List<EnvironmentalImpact> impacts = getImpactsFromCsvByFilter(file, impact -> impact.getDate().getYear() == year);
        Map<Company, Double> companyBySumConsumption = mapCompanyBySumConsumption(impacts, year);

        System.out.println("Company         TotalEnergyConsumption Employees ConsumptionPerEmployee");
        companyBySumConsumption.forEach((company, consumption) ->
            System.out.printf("%-12s %10.2f %18d %11.2f%n",
                    company.getName(),
                    consumption,
                    company.getTotalEmployees(),
                    consumption / company.getTotalEmployees()
            )
        );
    }

    public static void analyseTop3CompaniesMaximumConsumption(File file, int year) {
        List<EnvironmentalImpact> impacts = getImpactsFromCsvByFilter(file, impact -> impact.getDate().getYear() == year);
        Map<Company, Double> companyBySumConsumption = mapCompanyBySumConsumption(impacts, year);
        Map<Company, Double> top3Companies = findTop3Companies(companyBySumConsumption);

        System.out.println("Сompany         totalConsumption  avgConsumption/month  minConsumption/month");
        top3Companies.forEach((key, value) -> System.out.printf("%-12s %10.2f %17.2f %21.2f%n",
                key.getName(),
                value,
                avgConsumptionCompany(impacts, key.getId()),
                minConsumptionCompany(impacts, key.getId())
        ));
    }

    private static List<EnvironmentalImpact> getImpactsFromCsvByFilter(File file, Predicate<EnvironmentalImpact> filter) {
        return CompanyDataLoader.parseCsvToEnvironmentalImpact(file).orElse(new ArrayList<>())
                .stream()
                .filter(filter)
                .toList();
    }

    private static Map<Company, Double> mapCompanyBySumConsumption(List<EnvironmentalImpact> impacts, int year) {
        Map<Company, Double> companyBySumImpact = StatisticsAggregator.mapCompanyBySumImpact(
                LocalDate.of(year, 1, 1),
                LocalDate.of(year, 12, 31),
                impacts,
                TypeEnvironmentalImpact.ENERGY_CONSUMPTION);
        return companyBySumImpact.entrySet().stream()
                .collect(Collectors.groupingBy(
                        Map.Entry::getKey,
                        Collectors.summingDouble(Map.Entry::getValue))
                );
    }

    private static Map<Company, Double> findTop3Companies(Map<Company, Double> companyBySumConsumption) {
        return companyBySumConsumption.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(3)
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (d1, d2) -> d1,
                        LinkedHashMap::new
                ));
    }

    private static double avgConsumptionCompany(List<EnvironmentalImpact> impacts, int id) {
        return impacts.stream()
                .filter(impact -> impact.getCompany().getId() == id)
                .mapToDouble(EnvironmentalImpact::getVolume)
                .average().orElse(Double.NaN);
    }

    private static double minConsumptionCompany(List<EnvironmentalImpact> impacts, int id) {
        return impacts.stream()
                .filter(impact -> impact.getCompany().getId() == id)
                .mapToDouble(EnvironmentalImpact::getVolume)
                .min().orElse(Double.NaN);
    }
}
