package school.faang.bjs2_80812;

import java.io.IOException;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class EnvironmentalImpactAnalyzer {

    private final CompanyDataLoader dataLoader;
    private final Map<Integer, Company> companyMap;

    public EnvironmentalImpactAnalyzer(CompanyDataLoader loader, List<Company> companies) {
        this.dataLoader = loader;
        this.companyMap = companies.stream()
                .collect(Collectors.toMap(Company::getId, company -> company));
    }

    public void printMonthlyEmissions(String filename, int companyId, LocalDate now) throws IOException {
        LocalDate oneYearAgo = now.minusMonths(12);

        List<EnvironmentalImpact> allImpacts = dataLoader.loadImpacts(filename);

        Map<YearMonth, Double> emissionsByMonth = allImpacts.stream()
                .filter(impact -> impact.getCompanyId() == companyId)
                .filter(impact -> impact.getType() == ImpactType.GAS_EMISSION)
                .filter(impact -> !impact.getDate().isBefore(oneYearAgo) && !impact.getDate().isAfter(now))
                .collect(Collectors.groupingBy(
                        impact -> YearMonth.from(impact.getDate()),
                        Collectors.summingDouble(EnvironmentalImpact::getVolume)
                ));

        String companyName = companyMap.containsKey(companyId)
                ? companyMap.get(companyId).getCompanyName()
                : "Unknown Company";

        System.out.println("Company Name: " + companyName);
        System.out.println("Today's date: " + now.format(DateTimeFormatter.ofPattern("dd.MM.yyyy")));
        System.out.println("Month    GasEmission");

        double total = 0.0;

        List<YearMonth> months = emissionsByMonth.keySet().stream()
                .sorted(Comparator.reverseOrder())
                .toList();

        for (YearMonth ym : months) {
            double volume = emissionsByMonth.get(ym);
            total += volume;
            System.out.printf("%s  %.2f%n", ym, volume);
        }

        System.out.printf("Total    %.2f%n", total);
    }

    public void printTopCompanies(String filename, LocalDate now) throws IOException {
        List<EnvironmentalImpact> impacts = dataLoader.loadImpacts(filename);
        LocalDate oneYearAgo = now.minusMonths(12);

        Map<Integer, Map<YearMonth, Double>> grouped = impacts.stream()
                .filter(e -> e.getType() == ImpactType.GAS_EMISSION)
                .filter(e -> !e.getDate().isBefore(oneYearAgo) && !e.getDate().isAfter(now))
                .collect(Collectors.groupingBy(
                        EnvironmentalImpact::getCompanyId,
                        Collectors.groupingBy(
                                e -> YearMonth.from(e.getDate()),
                                Collectors.summingDouble(EnvironmentalImpact::getVolume)
                        )
                ));

        List<CompanyStats> stats = grouped.entrySet().stream()
                .map(entry -> {
                    int companyId = entry.getKey();
                    Map<YearMonth, Double> monthly = entry.getValue();
                    double total = monthly.values().stream().mapToDouble(Double::doubleValue).sum();
                    double avg = monthly.values().stream().mapToDouble(Double::doubleValue).average().orElse(0.0);
                    double min = monthly.values().stream().mapToDouble(Double::doubleValue).min().orElse(0.0);
                    String name = companyMap
                            .getOrDefault(companyId, new Company(companyId, "Unknown", 0)).getCompanyName();
                    return new CompanyStats(name, total, avg, min);
                })
                .sorted(Comparator.comparingDouble(CompanyStats::getTotalEmission).reversed())
                .limit(3)
                .toList();

        System.out.printf("%-15s %-17s %-22s %-22s%n",
                "Company", "TotalGasEmission", "AvgGasEmission/Month", "MinGasEmission/Month");
        for (CompanyStats s : stats) {
            System.out.printf("%-15s %-17.2f %-22.2f %-22.2f%n",
                    s.getName(), s.getTotalEmission(), s.getAvgEmission(), s.getMinEmission());
        }
    }

    public void printEmissionsPerEmployee(String filename, LocalDate now) throws IOException {
        List<EnvironmentalImpact> impacts = dataLoader.loadImpacts(filename);
        LocalDate oneYearAgo = now.minusMonths(12);

        Map<Integer, Double> totalByCompany = impacts.stream()
                .filter(e -> e.getType() == ImpactType.GAS_EMISSION)
                .filter(e -> !e.getDate().isBefore(oneYearAgo) && !e.getDate().isAfter(now))
                .collect(Collectors.groupingBy(
                        EnvironmentalImpact::getCompanyId,
                        Collectors.summingDouble(EnvironmentalImpact::getVolume)
                ));

        System.out.printf("%-20s %-17s %-10s %-22s%n",
                "Company", "TotalGasEmission", "Employees", "GasEmissionPerEmployee");

        totalByCompany.forEach((companyId, total) -> {
            Company company = companyMap.getOrDefault(companyId, new Company(companyId, "Unknown", 0));
            int employees = company.getTotalEmployees();
            double perEmployee = employees > 0 ? total / employees : 0.0;

            System.out.printf("%-20s %-17.2f %-10d %-22.2f%n",
                    company.getCompanyName(), total, employees, perEmployee);
        });
    }
}
