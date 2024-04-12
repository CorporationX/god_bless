package faang.school.godbless.bjs2_5257;

import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class EnvironmentalImpactAnalyzer {

    private final static DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("yyyy.MM");
    private final CompanyService companyService = new CompanyService();

    public void printEnergyConsumptionByMonth(String fileName, int companyId) {
        String csvEnvImpactSourceFile = new File("").getAbsolutePath().concat(fileName);
        List<EnvironmentalImpact> environmentalImpactList = CompanyDataLoader.readCsvToListEnvImpacts(csvEnvImpactSourceFile);

        LocalDate currentDate = LocalDate.now();
        System.out.println("Company name: " + companyService.findCompanyById(companyId).getCompanyName());
        System.out.println("Today's date: " + currentDate.format(DateTimeFormatter.ofPattern("dd.MM.yyyy")));
        System.out.println("Month    EnergyConsumption");
        IntStream.range(0, 11)
                .forEach(
                        i -> StatisticAggregator.createCompanyStatEnvImpact(currentDate.minusMonths(i).withDayOfMonth(1),
                                        currentDate.minusMonths(i).plusMonths(1).withDayOfMonth(1),
                                        environmentalImpactList, TypeImpact.ENERGY_CONSUMPTION)
                                .entrySet().stream()
                                .filter(entry -> entry.getKey().getId() == companyId)
                                .forEach(
                                        entry -> System.out.println(currentDate.minusMonths(i).format(DATE_FORMAT) + "    " + entry.getValue())
                                )
                );
    }

    public void printTop3EnergyConsumption(String fileName, LocalDate currentDate) {
        String csvEnvImpactSourceFile = new File("").getAbsolutePath().concat(fileName);
        List<EnvironmentalImpact> envImpList = CompanyDataLoader.readCsvToListEnvImpacts(csvEnvImpactSourceFile);

        System.out.println("Company          totalConsumption     avgConsumption/month     minConsumption/month");
        StatisticAggregator.createCompanyStatEnvImpact(currentDate.minusMonths(11).withDayOfMonth(1),
                        currentDate.plusMonths(1).withDayOfMonth(1),
                        envImpList, TypeImpact.ENERGY_CONSUMPTION)
                .entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(3)
                .forEach(entry -> System.out.printf("%-20s %-20s %-25.2f %.2f %n",
                        entry.getKey().getCompanyName(), entry.getValue(), entry.getValue() / 12,
                        envImpList.stream()
                                .filter(envImpact -> envImpact.getCompanyId() == entry.getKey().getId())
                                .filter(envImpact -> envImpact.getType().equals(TypeImpact.ENERGY_CONSUMPTION))
                                .map(EnvironmentalImpact::getVolume)
                                .min(Double::compare).orElse(null)
                ));
    }

    public void printConsumptionPerEmployeeForYear(String fileName, LocalDate currentDate) {
        String csvEnvImpactSourceFile = new File("").getAbsolutePath().concat(fileName);
        List<EnvironmentalImpact> environmentalImpactList = CompanyDataLoader.readCsvToListEnvImpacts(csvEnvImpactSourceFile);

        System.out.println("Company          totalEnergyConsumption     Employees     ConsumptionPerEmployee");
        StatisticAggregator.createCompanyStatEnvImpact(currentDate.minusMonths(11).withDayOfMonth(1),
                        currentDate.plusMonths(1).withDayOfMonth(1),
                        environmentalImpactList, TypeImpact.ENERGY_CONSUMPTION)
                .entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEach(entry -> System.out.printf("%-20s %-24s %-15d %f %n",
                        entry.getKey().getCompanyName(), entry.getValue(), entry.getKey().getTotalEmployees(), entry.getValue() / entry.getKey().getTotalEmployees()
                ));
    }
}
