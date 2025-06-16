package school.faang.bjs2_80821;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;
import java.time.Month;
import java.util.*;
import java.util.stream.Collectors;

public class EnvironmentalImpactAnalyzer {
    private final CompanyDataLoader dataLoader;
    private final StatisticsAggregator statisticsAggregator;


    public EnvironmentalImpactAnalyzer(
            CompanyDataLoader dataLoader,
            StatisticsAggregator statisticsAggregator
    ) {
        this.dataLoader = dataLoader;
        this.statisticsAggregator = statisticsAggregator;
    }


    public void printMonthlyReport(String path, long companyId) {
        List<EnvironmentalImpact> environmentalImpacts = dataLoader.parseEnvImpactFile(
                path
        );

        List<Month> months = List.of(
                Month.of(1), Month.of(2), Month.of(3), Month.of(4),
                Month.of(5), Month.of(6), Month.of(7), Month.of(8),
                Month.of(9), Month.of(10), Month.of(11), Month.of(12)
        );

        Map<Month, List<EnvironmentalImpact>> groupedData = statisticsAggregator
                .aggregateEnvironmentalImpactsByCompanyAndMonth(
                        LocalDate.now().minusYears(3),
                        LocalDate.now(),
                        environmentalImpacts,
                        ExposureType.GAS_EMISSION,
                        companyId
                );
        months.stream().sorted(Comparator.comparingInt(Month::getValue)).forEach(month -> {
            Double sum = groupedData.getOrDefault(month, new ArrayList<>()).stream()
                    .mapToDouble(EnvironmentalImpact::getVolume).sum();
            System.out.printf("%s: %s\n", month, sum);

        });
    }


    public Map<String, Stats> analyzeTopEnvironmentalImpacts(
            String path,
            LocalDate startDate,
            LocalDate endDate
    ) {
        List<EnvironmentalImpact> environmentalImpacts = dataLoader.parseEnvImpactFile(
                path
        );

        Map<String, List<EnvironmentalImpact>> groupedData = statisticsAggregator
                .aggregateEnvironmentalImpactsByCompanies(
                        startDate,
                        endDate,
                        environmentalImpacts,
                        ExposureType.GAS_EMISSION
                );
        Map<String, Stats> statsByCompany = new HashMap<>();

        groupedData.forEach((key, list) -> {
            Map<Month, Double> stats = list.stream()
                    .collect(Collectors.groupingBy(
                            env -> Month.from(env.getDate()),
                            Collectors.summingDouble(EnvironmentalImpact::getVolume)
                    ));
            double total = stats.values().stream().mapToDouble(Double::doubleValue).sum();
            double avg = total / 12.0;
            double min = stats.values().stream().mapToDouble(Double::doubleValue).min().orElse(0.0);
            Stats s = new Stats(total, avg, min);
            statsByCompany.put(key, s);
        });
        System.out.printf(
                "%-15s %15s %20s %20s%n",
                "Company", "TotalGasEmission", "AvgGasEmission/Month", "MinGasEmission/Month"
        );
        LinkedHashMap<String, Stats> top = statsByCompany.entrySet().stream()
                .sorted((
                                a,
                                b
                        ) -> Double.compare(b.getValue().getTotal(), a.getValue().getTotal())
                )
                .limit(3)
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (first, second) -> second,
                        LinkedHashMap::new
                ));
        top.forEach((name, s) -> {
            System.out.printf("%-15s %15.2f %20.2f %20.2f%n",
                    name, s.total, s.avg, s.min);
        });
        return top;
    }

    public void printPerEmployeeEmission(
            String path,
            LocalDate startDate,
            LocalDate endDate,
            List<Company> companies,
            ExposureType type
    ) {
        List<EnvironmentalImpact> all = dataLoader.parseEnvImpactFile(path);

        Map<Integer, Double> totalByCompany = statisticsAggregator
                .aggregateEnvironmentalImpactsByCompanyAndType(startDate, endDate, all, type);

        System.out.printf("%-15s %20s%n", "Company", "EmissionPerEmployee");

        companies.forEach(company -> {
            Double total = totalByCompany.getOrDefault(company.getId(), 0.0);
            double perEmp = company.getTotalEmployees() > 0
                    ? total / company.getTotalEmployees()
                    : 0.0;
            System.out.printf("%-15s %20.2f%n", company.getCompanyName(), perEmp);
        });
    }

    @Getter
    @AllArgsConstructor
    public static class Stats {
        private double total;
        private double avg;
        private double min;
    }

}
