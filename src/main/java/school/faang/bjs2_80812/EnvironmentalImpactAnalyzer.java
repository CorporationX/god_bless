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

    private static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("dd.MM.yyyy");

    private final CompanyDataLoader dataLoader;
    private final Map<Integer, Company> companyMap;

    public EnvironmentalImpactAnalyzer(CompanyDataLoader loader, List<Company> companies) {
        this.dataLoader = loader;
        this.companyMap = companies.stream()
                .collect(Collectors.toMap(Company::getId, company -> company));
    }

    public void printMonthlyEmissions(String filename, int companyId) throws IOException {
        LocalDate now = LocalDate.now();
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

        String companyName = companyMap.getOrDefault(companyId, new Company(companyId, "Unknown Company", 0))
                .getCompanyName();

        System.out.println("Company Name: " + companyName);
        System.out.println("Today's date: " + now.format(DATE_FORMAT));
        System.out.println("Month    GasEmission");

        double total = 0.0;

        List<YearMonth> months = emissionsByMonth.keySet().stream()
                .sorted(Comparator.reverseOrder())
                .toList();

        for (YearMonth month : months) {
            double volume = emissionsByMonth.get(month);
            total += volume;
            System.out.printf("%s  %.2f%n", month, volume);
        }

        System.out.printf("Total    %.2f%n", total);
    }

    public void printTopCompanies(String filename) throws IOException {
        LocalDate now = LocalDate.now();
        LocalDate oneYearAgo = now.minusMonths(12);

        List<EnvironmentalImpact> impacts = dataLoader.loadImpacts(filename);

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

        System.out.printf("%-15s %-17s %-22s %-22s%n",
                "Company", "TotalGasEmission", "AvgGasEmission/Month", "MinGasEmission/Month");

        grouped.entrySet().stream()
                .map(entry -> {
                    int companyId = entry.getKey();
                    Map<YearMonth, Double> monthly = entry.getValue();
                    double total = monthly.values().stream().mapToDouble(Double::doubleValue).sum();
                    double avg = monthly.values().stream().mapToDouble(Double::doubleValue).average().orElse(0.0);
                    double min = monthly.values().stream().mapToDouble(Double::doubleValue).min().orElse(0.0);
                    String name = companyMap.getOrDefault(companyId, new Company(companyId, "Unknown", 0))
                            .getCompanyName();
                    return new CompanyStats(name, total, avg, min);
                })
                .sorted(Comparator.comparingDouble(CompanyStats::getTotalEmission).reversed())
                .limit(3)
                .forEach(s -> System.out.printf("%-15s %-17.2f %-22.2f %-22.2f%n",
                        s.getName(), s.getTotalEmission(), s.getAvgEmission(), s.getMinEmission()));
    }

    public void printEmissionsPerEmployee(String filename) throws IOException {
        LocalDate now = LocalDate.now();
        LocalDate oneYearAgo = now.minusMonths(12);

        List<EnvironmentalImpact> impacts = dataLoader.loadImpacts(filename);

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