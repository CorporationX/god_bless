package school.faang.sprint_2.task_46716;

import lombok.NonNull;
import org.apache.commons.collections4.MapUtils;
import school.faang.sprint_2.task_46716.entity.Company;
import school.faang.sprint_2.task_46716.entity.EnvironmentalImpact;
import school.faang.sprint_2.task_46716.entity.ImpactType;
import school.faang.sprint_2.task_46716.repository.CompanyRepository;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

public class EnvironmentalImpactAnalyzer {
    private final CompanyDataLoader companyDataLoader = new CompanyDataLoader();
    private final StatisticsAggregator statisticsAggregator = new StatisticsAggregator();

    public void printCompanyYearGasEmission(@NonNull String fileName,
                                            @NonNull LocalDate currentDate,
                                            int companyId) {
        System.out.println("Company year gas emission:");
        List<EnvironmentalImpact> environmentalImpacts = companyDataLoader.loadEnvironmentalImpactData(fileName);

        String companyName = CompanyRepository.getCompanyById(companyId)
                .orElseThrow(IllegalArgumentException::new)
                .getCompanyName();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM");

        Map<String, List<Double>> companiesImpacts = getYearCompaniesGasEmissionsPerMonth(currentDate,
                environmentalImpacts);

        if (MapUtils.isEmpty(companiesImpacts)) {
            System.out.println("No data on this date");
            return;
        }

        System.out.println("Company Name: " + companyName);
        System.out.println("Current date: " + currentDate.format(formatter));
        System.out.println("Month    GasEmission");

        List<Double> companyImpacts = companiesImpacts.get(companyName);
        int totalGasEmission = 0;
        for (Double companyImpact : companyImpacts) {
            System.out.printf("%s    %s\n", currentDate.format(formatter), companyImpact);
            currentDate = currentDate.minusMonths(1);
            totalGasEmission += companyImpact;
        }
        System.out.println("Total " + totalGasEmission);
    }

    public void printCompaniesWithLargestGasEmission(@NonNull String fileName,
                                                     @NonNull LocalDate currentDate) {
        System.out.println("Companies with largest gas emission:");
        List<EnvironmentalImpact> environmentalImpacts = companyDataLoader.loadEnvironmentalImpactData(fileName);

        Map<String, List<Double>> companiesImpacts = getYearCompaniesGasEmissionsPerMonth(currentDate,
                environmentalImpacts);

        if (MapUtils.isEmpty(companiesImpacts)) {
            System.out.println("No data on this date");
            return;
        }
        System.out.printf("%20s  TotalGasEmission  AvgGasEmission/Month  MinGasEmission/Month\n", "Company");

        companiesImpacts.entrySet()
                .stream()
                .limit(3)
                .forEach(companyImpacts -> {
                    String companyName = companyImpacts.getKey();
                    double totalImpact = companyImpacts.getValue()
                            .stream()
                            .reduce(Double::sum)
                            .orElse(0.0);
                    double averageImpact = totalImpact / environmentalImpacts.size();
                    double minMonthImpact = companyImpacts.getValue()
                            .stream()
                            .min(Double::compareTo)
                            .orElse(0.0);

                    System.out.printf("%20s  %16.2f  %20.2f  %20.2f\n", companyName,
                            totalImpact,
                            averageImpact,
                            minMonthImpact);
                });
    }

    public void printCompaniesGasEmissionsPerEmployee(@NonNull String fileName,
                                                      @NonNull LocalDate currentDate) {
        System.out.println("Companies gas emissions per employee:");
        List<EnvironmentalImpact> environmentalImpacts = companyDataLoader.loadEnvironmentalImpactData(fileName);

        Map<String, Double> companiesImpact = statisticsAggregator.getCompaniesTotalImpact(currentDate.minusMonths(12),
                currentDate,
                environmentalImpacts,
                ImpactType.GAS_EMISSION);

        if (MapUtils.isEmpty(companiesImpact)) {
            System.out.println("No data on this date");
            return;
        }

        System.out.printf("%20s  TotalGasEmission  Employees  GasEmissionPerEmployee\n", "Company");
        for (Map.Entry<String, Double> companyWithImpact : companiesImpact.entrySet()) {
            Company company = CompanyRepository.getCompanies()
                    .stream()
                    .filter(streamCompany -> streamCompany.getCompanyName().equals(companyWithImpact.getKey()))
                    .findFirst()
                    .orElseThrow(NoSuchElementException::new);
            double totalEmission = companyWithImpact.getValue();
            int totalEmployees = company.getTotalEmployees();
            double emissionPerEmployee = totalEmission / totalEmployees;
            System.out.printf("%20s  %16.2f  %9d  %22.2f\n",
                    company.getCompanyName(),
                    totalEmission,
                    totalEmployees,
                    emissionPerEmployee);
        }
    }

    private Map<String, List<Double>> getYearCompaniesGasEmissionsPerMonth(@NonNull LocalDate currentDate,
                                                                            @NonNull List<EnvironmentalImpact>
                                                                                    environmentalImpacts) {
        Map<String, List<Double>> resultMap = new HashMap<>();
        for (int i = 0; i < 12; i++) {
            LocalDate previousDate = currentDate;
            currentDate = currentDate.minusMonths(1);

            statisticsAggregator.getCompaniesTotalImpact(currentDate,
                            previousDate,
                            environmentalImpacts,
                            ImpactType.GAS_EMISSION)
                    .forEach((companyName, companyImpact) -> resultMap.computeIfAbsent(companyName,
                            k -> new ArrayList<>()).add(companyImpact));
        }
        return resultMap;
    }
}
