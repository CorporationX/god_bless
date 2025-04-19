package school.faang.bjs2_70755;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import static school.faang.bjs2_70755.CompanyService.getCompanyById;

@RequiredArgsConstructor
@Slf4j
public class EnvironmentalImpactAnalyzer {
    private final CompanyDataLoader companyDataLoader;
    private final StatisticsAggregator statisticsAggregator;

    public void analyzeMonthlyEmissions(String fileName,
                                        long companyId,
                                        LocalDate now,
                                        EnvironmentalImpactType type) {
        List<EnvironmentalImpact> impactList = companyDataLoader.readDataFromScv(fileName);

        Map<YearMonth, Double> monthlyEmissions =
                statisticsAggregator.getEmissionsWithCompanyId(now.minusYears(1),
                        now, impactList, type, companyId);

        printAnalyzeMonthlyEmissions(companyId, now, monthlyEmissions);
    }

    public void analyzeTopThreeCompanies(String fileName, LocalDate now, EnvironmentalImpactType type, int limit) {
        List<EnvironmentalImpact> impactList = companyDataLoader.readDataFromScv(fileName);

        Map<Company, Map<YearMonth, Double>> emissionsByCompanyAndMonth =
                statisticsAggregator.getEmissions(now.minusYears(1), now, impactList, type);

        printAnalyzeTopCompanies(emissionsByCompanyAndMonth, limit);
    }

    public void analyzeEmissionsPerOneEmployee(String fileName,
                                               LocalDate now,
                                               EnvironmentalImpactType type) {
        List<EnvironmentalImpact> impactList = companyDataLoader.readDataFromScv(fileName);

        Map<Company, Double> companyTotalEmissions =
                statisticsAggregator.getTotalEmissions(now.minusYears(1),
                        now, impactList, type);

        printEmissionsPerOneEmployee(companyTotalEmissions);

    }

    private void printAnalyzeMonthlyEmissions(long companyId,
                                              LocalDate now,
                                              Map<YearMonth, Double> monthlyEmissions) {
        String companyName = getCompanyById(companyId).companyName().toString();

        StringBuilder out = new StringBuilder("\n");
        out.append("Company Name: ").append(companyName).append("\n");
        out.append("Today's date: ").append(now).append("\n");
        out.append("Month\tGasEmission\n");

        monthlyEmissions.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(entry -> out.append(entry.getKey()).append("\t")
                        .append(String.format("%.2f", entry.getValue())).append("\n"));

        double total = monthlyEmissions.values().stream()
                .mapToDouble(Double::doubleValue)
                .sum();

        out.append("Total\t").append(String.format("%.2f", total));

        log.info(out.toString());
    }

    private void printAnalyzeTopCompanies(Map<Company, Map<YearMonth, Double>> emissionsByCompany, int limit) {
        StringBuilder out = new StringBuilder(String.format("\n%-15s %-17s %-23s %-23s%n",
                "Company", "TotalGasEmission", "AvgGasEmission/Month", "MinGasEmission/Month"));
        List<CompanyEmissionStats> statsList = emissionsByCompany.entrySet().stream()
                .map(entry -> {
                    double total = entry.getValue()
                            .values()
                            .stream()
                            .mapToDouble(Double::doubleValue)
                            .sum();
                    double avg = total / 12;
                    double min = entry.getValue()
                            .values()
                            .stream()
                            .mapToDouble(Double::doubleValue)
                            .min()
                            .orElse(0);

                    CompanyName companyName = entry.getKey().companyName();

                    return new CompanyEmissionStats(companyName, total, avg, min);
                })
                .sorted(Comparator.comparingDouble(CompanyEmissionStats::total).reversed())
                .limit(limit)
                .toList();

        statsList.forEach(stats -> out.append(String.format("%-15s %-17.2f %-23.2f %-23.2f%n",
                stats.companyName(), stats.total(), stats.average(), stats.min())));

        log.info(out.toString());
    }

    private void printEmissionsPerOneEmployee(Map<Company, Double> companyTotalEmissions) {
        StringBuilder out = new StringBuilder(String.format(
                "\n%-15s %-17s %-20s %-23s%n",
                "Company", "TotalGasEmission", "Employees", "GasEmissionPerEmployee"
        ));

        companyTotalEmissions.forEach((company, totalEmission) -> {
            int totalEmployees = company.totalEmployees();
            double emissionPerEmployee = totalEmission / totalEmployees;

            out.append(String.format(
                    "%-15s %-17.2f %-20d %-23.2f%n",
                    company.companyName(), totalEmission, totalEmployees, emissionPerEmployee
            ));
        });

        log.info(out.toString());
    }
}
