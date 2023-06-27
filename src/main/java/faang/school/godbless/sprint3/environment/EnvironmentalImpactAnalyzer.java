package faang.school.godbless.sprint3.environment;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Random;
import java.util.stream.IntStream;

public class EnvironmentalImpactAnalyzer {
    private final CompanyDataLoader dataLoader;
    private final StatisticsAggregator statisticsAggregator;

    public EnvironmentalImpactAnalyzer() {
        dataLoader = new CompanyDataLoader();
        statisticsAggregator = new StatisticsAggregator();
    }

    public void printEnergyConsumptionByMonthsForCompany(String filename, String company) {
        List<EnvironmentalImpact> impactList = dataLoader.load(filename);

        System.out.println("Company Name: " + company);
        System.out.println("Today's date is " + LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy.MM.dd")));

        double total = getEnergyConsumptionByMonthsForCompany(impactList, company)
                .entrySet().stream()
                .peek(this::printMonthStatistics)
                .map(Map.Entry::getValue)
                .filter(Objects::nonNull)
                .reduce(.0, Double::sum);

        System.out.println("Total consumption: " + total);
    }

    public void printEnergyConsumptionByCompanies(String filename, LocalDate currentDate) {
        List<EnvironmentalImpact> impactList = dataLoader.load(filename);

        Map<String, Double> generalStatisticsForYear = getGeneralStatisticsForPeriod(
                impactList, currentDate.minusYears(1), currentDate);

        System.out.printf("%-12s%-20s%-25s%-20s\n",
                "Company", "totalConsumption", "avgConsumption/month", "minConsumption/month");

        for (String company : generalStatisticsForYear.keySet()) {
            System.out.printf("%-12s%-20.2f%-25.2f%-20.2f\n",
                    company,
                    generalStatisticsForYear.get(company),
                    generalStatisticsForYear.get(company) / 12,
                    getMinConsumptionForCompanyPerMonth(impactList, company)
            );
        }
    }

    public void printStatisticsForEmployeePerYear(String filename, LocalDate currentDate, Company companyName) {
        List<EnvironmentalImpact> impactList = dataLoader.load(filename);

        Map<String, Double> generalStatisticsForYear = getGeneralStatisticsForPeriod(
                impactList, currentDate.minusYears(1), currentDate);

        System.out.printf("%-12s%-25s%-12s%-20s\n",
                "Company", "TotalEnergyConsumption", "Employees", "ConsumptionPerEmployee");
        for (String company : generalStatisticsForYear.keySet()) {

            System.out.printf("%-12s%-25.2f%-12d%-20.2f\n",
                    company,
                    generalStatisticsForYear.get(company),
                    getCompanyFromRepo(company).getTotalEmployees(),
                    (double) getCompanyFromRepo(company).getTotalEmployees() / companyName.getTotalEmployees());
        }
    }

    private Company getCompanyFromRepo(String company) {
        Random random = new Random();
        return new Company(random.nextInt(1, 5), company, random.nextInt(1000, 10000));
    }

    private double getMinConsumptionForCompanyPerMonth(List<EnvironmentalImpact> impactList, String company) {
        return getEnergyConsumptionByMonthsForCompany(impactList, company)
                .values().stream()
                .filter(Objects::nonNull)
                .min(Comparator.naturalOrder())
                .orElse(0.0);
    }

    private Map<String, Double> getEnergyConsumptionByMonthsForCompany(
            List<EnvironmentalImpact> impactList, String company) {

        Map<String, Double> companyStatisticByMonth = new LinkedHashMap<>();

        for (LocalDate date : getYearByMonths(LocalDate.now())) {
            companyStatisticByMonth.put(
                    getStringFormatForMonth(date.plusMonths(1)),
                    getGeneralStatisticsForPeriod(impactList, date, date.plusMonths(1)).get(company)
            );
        }
        return companyStatisticByMonth;
    }

    private Map<String, Double> getGeneralStatisticsForPeriod(
            List<EnvironmentalImpact> impactList, LocalDate startDate, LocalDate endDate) {
        return statisticsAggregator.getImpactStatistics(
                impactList,
                EnvironmentalImpact.Type.ENERGY_CONSUMPTION,
                startDate,
                endDate
        );
    }

    private List<LocalDate> getYearByMonths(LocalDate currentDate) {
        return IntStream.rangeClosed(1, 12)
                .mapToObj(currentDate::minusMonths)
                .toList();
    }

    private void printMonthStatistics(Map.Entry<String, Double> statistics) {
        System.out.printf("%s\t%.2f\n",
                statistics.getKey(),
                statistics.getValue() == null ? 0.0 : statistics.getValue());
    }

    private String getStringFormatForMonth(LocalDate date) {
        return date.format(DateTimeFormatter.ofPattern("yyyy.MM"));
    }
}
