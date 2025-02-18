package school.faang.services;

import school.faang.models.Company;
import school.faang.models.CompanyDataLoader;
import school.faang.models.EmissionType;
import school.faang.models.EnvironmentalImpact;

import java.io.IOException;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class EnvironmentalImpactAnalyzer {
    public static void getEnvironmentalImpactByCompanyInLastYear(String filePath, int id) throws IOException {
        validatePath(filePath);
        String companyName = Company.getCompanyNameById(id);
        List<EnvironmentalImpact> impacts = CompanyDataLoader.loadEnvironmentalImpacts(filePath);
        LocalDate start = LocalDate.now().minusDays(365);
        LocalDate end = LocalDate.now();

        final double totalEnvironmentImpact = getTotalEnvironmentalImpact(start, end, impacts);
        System.out.println("Company Name: " + companyName);
        System.out.println("Today's date: " + end);

        for (int i = 0; i < 12; ++i) {
            LocalDate currentMonthStart = start.withDayOfMonth(1);
            LocalDate currentMonthEnd = start.with(TemporalAdjusters.lastDayOfMonth());
            Double currentImpact = getTotalEnvironmentalImpact(currentMonthStart, currentMonthEnd, impacts);
            System.out.printf("%s.%s %f\n", start.getYear(), start.getMonthValue(), currentImpact);
            start = currentMonthEnd.plusDays(1);
        }

        System.out.println("Total: " + totalEnvironmentImpact);
    }

    public static void getMostPollutingCompanies(String filePath) throws IOException {
        validatePath(filePath);
        List<EnvironmentalImpact> impacts = CompanyDataLoader.loadEnvironmentalImpacts(filePath);
        LocalDate start = LocalDate.now().minusDays(365);
        LocalDate end = LocalDate.now();

        Map<String, Double> impactByCompany = StatisticAggregator.getEnvironmentalImpactByCompany(
                        start, end, impacts, EmissionType.GAS_EMISSION, true)
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(3)
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new
                ));
        System.out.println("Company\t\t   TotalGasEmission\t   AvgGasEmission/Month\t\tMinGasEmission/Month");

        for (var entry : impactByCompany.entrySet()) {
            List<Double> impactByMonth = new ArrayList<>(Collections.nCopies(12, 0.0));
            for (EnvironmentalImpact impact : impacts) {
                if (Company.getCompanyNameById(impact.getCompanyId()).equals(entry.getKey())
                        && impact.getDate().isAfter(end.minusMonths(12))) {
                    int index = impact.getDate().getMonthValue() - 1;
                    double volume = impact.getVolume();
                    impactByMonth.set(index, impactByMonth.get(index) == 0
                            ? volume : Math.min(volume, impactByMonth.get(index)));
                }
            }
            System.out.printf("%-15s%-20.2f%-25.2f%-20.2f%n",
                    entry.getKey(), entry.getValue(), entry.getValue() / 12.0, Collections.min(impactByMonth));
        }
        System.out.println();
    }

    public static void getEnvironmentalImpactPerEmployee(String filePath) throws IOException {
        validatePath(filePath);
        List<EnvironmentalImpact> impacts = CompanyDataLoader.loadEnvironmentalImpacts(filePath);
        LocalDate start = LocalDate.now().minusYears(50);
        LocalDate end = LocalDate.now();

        Map<String, Double> impactByCompanies = StatisticAggregator.getEnvironmentalImpactByCompany(
                start, end, impacts, EmissionType.GAS_EMISSION, true);

        System.out.println("Company\t\t\t\tTotalGasEmission\tEmployees\t   GasEmissionPerEmployee");

        for (var entry : impactByCompanies.entrySet()) {
            int employees = Company.getTotalEmployeesByCompanyName(entry.getKey());
            System.out.printf("%-20s%-20.2f%-15d%-20.2f%n",
                    entry.getKey(), entry.getValue(), employees, entry.getValue() / employees);
        }
        System.out.println();
    }

    private static double getTotalEnvironmentalImpact(LocalDate start, LocalDate end,
                                                      List<EnvironmentalImpact> impacts) {
        return StatisticAggregator.getEnvironmentalImpactByCompany(
                        start, end, impacts, EmissionType.GAS_EMISSION, true).values()
                .stream()
                .mapToDouble(Double::doubleValue)
                .sum();
    }

    private static void validatePath(String filePath) {
        if (filePath == null) {
            throw new IllegalArgumentException("File path can't be null.");
        }
    }
}