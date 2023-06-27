package faang.school.godbless.sprint3.environment;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.IntStream;

public class EnvironmentalImpactAnalyzer {
    private final CompanyDataLoader dataLoader;
    private final StatisticsAggregator statisticsAggregator;

    public EnvironmentalImpactAnalyzer() {
        dataLoader = new CompanyDataLoader();
        statisticsAggregator = new StatisticsAggregator();
    }

    public void printEnergyConsumptionByMonthsForComapny(String filename, String company) {
        List<EnvironmentalImpact> impactList = dataLoader.load(filename);

        System.out.println("Company Name: " + company);
        System.out.println("Today's date is " + LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy.MM.dd")));

        LocalDate endDate;
        double total = 0;

        for (LocalDate startDate : getYearByMonths(LocalDate.now())) {
            endDate = startDate.plusMonths(1);

            String date = endDate.format(DateTimeFormatter.ofPattern("yyyy.MM"));

             total = statisticsAggregator.getImpactStatistics(
                    impactList,
                    EnvironmentalImpact.Type.ENERGY_CONSUMPTION,
                    startDate,
                    endDate
                    )
                    .entrySet().stream()
                    .filter(e -> e.getKey().equals(company))
                    .map(Map.Entry::getValue)
                    .peek(value -> System.out.printf("%s\t%.2f\n", date, value))
                    .reduce(total, Double::sum);
        }

        System.out.println("Total consumption: " + total);
    }

    public void printEnergyConsumptionByCompanies(String filename, LocalDate currentDate) {
        List<EnvironmentalImpact> impactList = dataLoader.load(filename);

        Map<String, Double> generalStatisticsForYear = statisticsAggregator.getImpactStatistics(
                impactList,
                EnvironmentalImpact.Type.ENERGY_CONSUMPTION,
                currentDate.minusYears(1),
                currentDate);

        List<Map<String, Double>> statisticsForCompanyByMonths = new ArrayList<>();
        LocalDate endDate;

        for (LocalDate startDate : getYearByMonths(currentDate)) {
            endDate = startDate.plusMonths(1);

            statisticsForCompanyByMonths.add(statisticsAggregator.getImpactStatistics(
                    impactList,
                    EnvironmentalImpact.Type.ENERGY_CONSUMPTION,
                    startDate,
                    endDate)
            );
        }

        Map<String, Double> minForCompanyPerMonth = new LinkedHashMap<>();

        for (String company : generalStatisticsForYear.keySet()) {
            minForCompanyPerMonth.put(
                    company,
                    statisticsForCompanyByMonths.stream()
                            .flatMap(map -> map.entrySet().stream())
                            .filter(entry -> Objects.equals(company, entry.getKey()))
                            .map(Map.Entry::getValue)
                            .min(Comparator.naturalOrder())
                            .orElse(0.0)
            );
        }

        System.out.printf("%-12s%-20s%-25s%-20s\n",
                "Company", "totalConsumption", "avgConsumption/month", "minConsumption/month");

        for (String company : generalStatisticsForYear.keySet()) {
            System.out.printf("%-12s%-20.2f%-25.2f%-20.2f\n",
                    company,
                    generalStatisticsForYear.get(company),
                    generalStatisticsForYear.get(company) / 12,
                    minForCompanyPerMonth.get(company)
            );
        }
    }

    private List<LocalDate> getYearByMonths(LocalDate currentDate) {
        return IntStream.rangeClosed(1, 12)
                .mapToObj(currentDate::minusMonths)
                .toList();
    }
}
