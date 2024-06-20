package faang.school.godbless.eco_monitoring;

import lombok.AllArgsConstructor;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@AllArgsConstructor
public class EnvironmentalImpactAnalyzer {
    private Database database;
    private CompanyDataLoader companyDataLoader;
    private StatisticsAggregator statisticsAggregator;

    public void analyzeCompanyEnvironmentalImpactDuringYear(String pathToCsv,
                                                            int companyId,
                                                            EnvironmentalImpactType impactType) {
        Map<LocalDate, Double> companyEnergyConsumptionDuringYear =
                getTotalEnvironmentalImpactOfCompanyDuringYear(pathToCsv, companyId,
                        impactType);

        String companyName = database.getIdAndCompanyMap().get(companyId).getCompanyName();
        double environmentalImpactDuringTheYear = companyEnergyConsumptionDuringYear.values()
                .stream()
                .mapToDouble(Double::doubleValue)
                .sum();

        System.out.println("Company Name: " + companyName);
        System.out.println("Today's Date: " + LocalDate.now());
        System.out.printf("Month:      %s:\n", impactType.getFullTypeName());
        companyEnergyConsumptionDuringYear.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .forEach(entry -> {
                    System.out.println(String.format("%-12s", entry.getKey()) + entry.getValue());
                });
        System.out.println("Total:      " + environmentalImpactDuringTheYear);
    }

    public void analyzeTopNCompaniesByEnvironmentalImpact(String pathToCsv,
                                                          LocalDate currentDate,
                                                          int top,
                                                          EnvironmentalImpactType impactType) {
        final int MONTH_IN_YEAR = 12;
        List<EnvironmentalImpact> environmentalImpactList = companyDataLoader.loadData(pathToCsv);

        Map<Integer, Double> companyIdAndTotalEnvironmentalImpactMap = statisticsAggregator.aggregateData(
                currentDate.minusMonths(MONTH_IN_YEAR),
                currentDate,
                environmentalImpactList,
                impactType);

        Map<Integer, Double> topCompaniesWithHighestEnvironmentalImpact =
                companyIdAndTotalEnvironmentalImpactMap.entrySet()
                        .stream().sorted(Map.Entry.<Integer, Double>comparingByValue().reversed())
                        .limit(top)
                        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        Map<Integer, Double> companyIdAndMinimumEnvironmentalImpactMap = new HashMap<>();
        topCompaniesWithHighestEnvironmentalImpact.keySet()
                .forEach(companyId -> {
                    Map<LocalDate, Double> companyEnvironmentalImpactDuringYear =
                            getTotalEnvironmentalImpactOfCompanyDuringYear(pathToCsv, companyId, impactType);

                    companyEnvironmentalImpactDuringYear.entrySet()
                            .stream()
                            .min(Map.Entry.comparingByValue())
                            .map(Map.Entry::getValue)
                            .ifPresent(environmentalImpact -> companyIdAndMinimumEnvironmentalImpactMap
                                    .put(companyId, environmentalImpact));
                });

        System.out.printf("Company         total%-11s  avg%-11s/month  min%-11s/month\n",
                impactType.getShortTypeName(), impactType.getShortTypeName(), impactType.getShortTypeName());
        topCompaniesWithHighestEnvironmentalImpact.forEach((companyId, totalEnergyConsumption) -> {
            String companyName = database.getIdAndCompanyMap().get(companyId).getCompanyName();
            System.out.printf("%-16s%-18s%-22s%-20s\n",
                    companyName,
                    totalEnergyConsumption,
                    totalEnergyConsumption / MONTH_IN_YEAR,
                    companyIdAndMinimumEnvironmentalImpactMap.get(companyId));
        });
    }

    public void analyzeEnvironmentalImpactPerEmployee(String pathToCsv,
                                                      LocalDate currentDate,
                                                      EnvironmentalImpactType impactType) {
        List<EnvironmentalImpact> environmentalImpactList = companyDataLoader.loadData(pathToCsv);

        Map<Integer, Double> companyIdAndTotalEnvironmentalImpactMap = statisticsAggregator.aggregateData(
                currentDate.minusMonths(12),
                currentDate,
                environmentalImpactList,
                impactType);

        System.out.printf("Company            Total%-18s Employees %-11sPerEmployee\n",
                impactType.getFullTypeName(), impactType.getShortTypeName());
        companyIdAndTotalEnvironmentalImpactMap.forEach((companyId, energyConsumption) -> {
            Company company = database.getIdAndCompanyMap().get(companyId);
            String companyName = company.getCompanyName();
            int numberOfEmployees = company.getTotalEmployees();
            double totalEnergyConsumption = companyIdAndTotalEnvironmentalImpactMap.get(companyId);
            System.out.printf("%-19s%-24s%-10s%-22s\n",
                    companyName,
                    totalEnergyConsumption,
                    numberOfEmployees,
                    totalEnergyConsumption / numberOfEmployees);
        });
    }

    public Map<LocalDate, Double> getTotalEnvironmentalImpactOfCompanyDuringYear(
            String pathToCsv,
            int companyId,
            EnvironmentalImpactType environmentalImpactType) {
        String companyName = database.getIdAndCompanyMap().get(companyId).getCompanyName();
        if (companyName == null) {
            throw new IllegalArgumentException("Could not find company by this ID");
        }

        List<EnvironmentalImpact> environmentalImpactList = companyDataLoader.loadData(pathToCsv);

        Map<LocalDate, Double> environmentalImpactDuringTheYear = new HashMap<>();
        for (int month = 0; month < 12; month++) {
            LocalDate localDate = LocalDate.now().minusMonths(month);

            int SCALE_OF_ONE_MONTH = 1;

            double totalEnergyConsumptionOfMonth = DateStream.getEnvironmentalImpactsInRange(environmentalImpactList,
                            localDate.minusMonths(SCALE_OF_ONE_MONTH), localDate)
                    .filter(impact -> impact.getType().equals(environmentalImpactType))
                    .filter(impact -> impact.getCompanyId() == companyId)
                    .mapToDouble(EnvironmentalImpact::getVolume)
                    .sum();

            environmentalImpactDuringTheYear.put(localDate, totalEnergyConsumptionOfMonth);
        }
        return environmentalImpactDuringTheYear;
    }
}
