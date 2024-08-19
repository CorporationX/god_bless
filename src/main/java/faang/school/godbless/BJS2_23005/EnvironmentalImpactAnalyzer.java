package faang.school.godbless.BJS2_23005;

import java.io.File;
import java.time.LocalDate;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EnvironmentalImpactAnalyzer {

    public static void analyseLastYearForIdCompany(File file, int id) {
        LocalDate lastYear = LocalDate.now().minusYears(1L);
        List<EnvironmentalImpact> impacts = CompanyDataLoader.parseCsvToEnvironmentalImpact(file)
                .orElse(new ArrayList<>())
                .stream()
                .filter(impact -> impact.getCompany().getId() == id)
                .toList();

        String companyName = impacts.get(0).getCompany().getName();
        System.out.printf("Company name: %s\nToday's date: %s\nMonth      EnergyConsumption\n", companyName, LocalDate.now());

        Stream.iterate(lastYear, date -> !date.isAfter(LocalDate.now()), date -> date.plusMonths(1L))
                .flatMap(date -> {
                    Map<Integer, Double> map = StatisticsAggregator.mapCompanyIdBySumImpact(
                                    date,
                                    date.plusMonths(1L),
                                    impacts,
                                    TypeEnvironmentalImpact.ENERGY_CONSUMPTION);
                    return Stream.of(new AbstractMap.SimpleEntry<>(date, map.getOrDefault(id, 0D)));
                })
                .forEach(entry -> System.out.printf("%s %.2f%n", entry.getKey(), entry.getValue()));
    }

    public static void analyseTop3CompaniesMaximumConsumption(File file, int year) {
        List<EnvironmentalImpact> impacts = CompanyDataLoader.parseCsvToEnvironmentalImpact(file)
                .orElse(new ArrayList<>())
                .stream()
                .filter(impact -> impact.getDate().getYear() == year)
                .toList();

        Map<Integer, Double> companyIdBySumConsumption = mapCompanyIdBySumConsumption(impacts, year);
        Map<Integer, Double> top3Companies = findTop3Companies(companyIdBySumConsumption);

        System.out.println("Сompany         totalConsumption  avgConsumption/month  minConsumption/month");
        top3Companies.forEach((key, value) -> System.out.printf("%-12s %10.2f %17.2f %21.2f%n",
                key,
                value,
                avgConsumptionCompany(companyIdBySumConsumption, key),
                minConsumptionCompany(companyIdBySumConsumption, key)
        ));
    }

    private static Map<Integer, Double> mapCompanyIdBySumConsumption(List<EnvironmentalImpact> impacts, int year) {
        return StatisticsAggregator.mapCompanyIdBySumImpact(
                        LocalDate.of(year, 1, 1),
                        LocalDate.of(year + 1, 1, 1),
                        impacts,
                        TypeEnvironmentalImpact.ENERGY_CONSUMPTION
                )
                .entrySet().stream()
                .collect(Collectors.groupingBy(
                        Map.Entry::getKey,
                        Collectors.summingDouble(Map.Entry::getValue))
                );
    }

    private static Map<Integer, Double> findTop3Companies(Map<Integer, Double> companyIdBySumConsumption) {
        return companyIdBySumConsumption.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(3)
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (d1, d2) -> d1,
                        LinkedHashMap::new
                ));
    }

    private static double avgConsumptionCompany(Map<Integer, Double> companyIdBySumConsumption, int id) {
        return companyIdBySumConsumption.entrySet().stream()
                .filter(entry -> entry.getKey() == id)
                .mapToDouble(Map.Entry::getValue)
                .average().orElse(Double.NaN);
    }

    private static double minConsumptionCompany(Map<Integer, Double> companyIdBySumConsumption, int id) {
        return companyIdBySumConsumption.entrySet().stream()
                .filter(entry -> entry.getKey() == id)
                .mapToDouble(Map.Entry::getValue)
                .min().orElse(Double.NaN);
    }
}
