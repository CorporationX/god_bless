package faang.school.godbless.EcologyMonitoring;

import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class EnvironmentalImpactAnalyzer {
    private final CompanyDataLoader dataLoader = new CompanyDataLoader();
    private final List<Company> companies;

    public EnvironmentalImpactAnalyzer(List<Company> companies) {
        this.companies = companies;
    }

    public void analyzeCompanyEnvironmentImpact(File file, int companyId) {
        Company company = getCompanyByFilter(comp -> comp.getId() == companyId);
        LocalDate currentDate = LocalDate.now();

        System.out.printf("Company Name: %s\n", company.getCompanyName());
        System.out.printf("Today's date: %s\n", currentDate.format(DateTimeFormatter.ofPattern("dd.MM.yyyy")));
        System.out.println("Month\tEnergyConsumption");

        List<EnvironmentalImpact> impacts = dataLoader.readCSVFile(file).stream()
                .filter(impact -> impact.getCompanyId() == companyId)
                .toList();

        LocalDate start = currentDate.minusYears(1).withDayOfMonth(1);

        double sum = 0.0;
        Map<String, DoubleSummaryStatistics> aggregatedStatistics;
        int monthCount = 0;
        while (monthCount < 12) {
            LocalDate finalStart = start.plusMonths(monthCount);
            LocalDate finalEnd = start.plusMonths(++monthCount);
            aggregatedStatistics = StatisticsAggregator.aggregateEnvironmentalImpactsByCompanyAndType(finalStart, finalEnd, impacts, ImpactType.ENERGY_CONSUMPTION);
            aggregatedStatistics.forEach((key, value) -> System.out.printf("%s\t%f\n", finalStart.format(DateTimeFormatter.ofPattern("yyyy.MM")), value.getSum()));

            sum += aggregatedStatistics.getOrDefault(company.getCompanyName(), new DoubleSummaryStatistics()).getSum();
        }
        System.out.printf("Total:\t%f\n", sum);
    }

    public void analyzeTopThreeEnvironmentImpactCompanies(File file, LocalDate currentDate) {
        System.out.println("Сompany\ttotalConsumption\tavgConsumption/month\tminConsumption/month");

        LocalDate end = currentDate.withDayOfMonth(1).minusDays(1);
        LocalDate start = currentDate.minusYears(1).withDayOfMonth(1);

        List<EnvironmentalImpact> impacts = dataLoader.readCSVFile(file).stream()
                .filter(impact -> impact.getDate().isAfter(start))
                .filter(impact -> impact.getDate().isBefore(end))
                .toList();

        Map<String, DoubleSummaryStatistics> aggregatedStatistics = StatisticsAggregator.aggregateEnvironmentalImpactsByCompany(start, end, impacts);
        aggregatedStatistics.entrySet().stream()
                .sorted(Map.Entry.comparingByValue((o1, o2) -> (int) (o2.getMax() - o1.getMax())))
                .limit(3)
                .forEach(entry -> System.out.printf("%s\t%f\t%f\t%f\n", entry.getKey(), entry.getValue().getSum(), entry.getValue().getAverage(), entry.getValue().getMin()));
    }

    public void analyzeTopThreeEnvironmentalImpactsPerEmployee(File file, LocalDate currentDate) {
        System.out.println("Сompany\tTotalEnergyConsumption\tEmployees\tConsumptionPerEmployee");

        LocalDate end = currentDate.withDayOfMonth(1).minusDays(1);
        LocalDate start = currentDate.minusYears(1).withDayOfMonth(1);

        List<EnvironmentalImpact> impacts = dataLoader.readCSVFile(file).stream()
                .filter(impact -> impact.getDate().isAfter(start))
                .filter(impact -> impact.getDate().isBefore(end))
                .toList();

        Map<String, DoubleSummaryStatistics> aggregatedStatistics = StatisticsAggregator.aggregateEnvironmentalImpactsByCompany(start, end, impacts);

        Map<Company, Double> topThree = aggregatedStatistics.entrySet().stream()
                .sorted(Map.Entry.comparingByValue((o1, o2) -> (int) (o2.getMax() - o1.getMax())))
                .limit(3)
                .collect(Collectors.toMap(entry -> getCompanyByFilter(comp -> comp.getCompanyName().equals(entry.getKey())), entry -> entry.getValue().getSum()))
                .entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(3)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (x, y) -> y, LinkedHashMap::new));

        topThree.forEach((key, value) -> System.out.printf("%s\t%f\t%d\t%f\n", key.getCompanyName(), value, key.getTotalEmployees(), value / key.getTotalEmployees()));
    }

    private Company getCompanyByFilter(Predicate<Company> filter) {
        return companies.stream()
                .filter(filter)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Компания не найдена"));
    }
}
