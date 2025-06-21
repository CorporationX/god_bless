package school.faang.ecology;

import lombok.RequiredArgsConstructor;
import school.faang.ecology.domain.EnvironmentalImpact;

import java.io.IOException;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

import static school.faang.ecology.domain.EnvironmentalImpactType.GAS_EMISSION;

/**
 * @author Danil Pudovkin
 * @since 21.06.2025
 */
@RequiredArgsConstructor
public class EnvironmentalImpactAnalyzer {

    private final CompanyFakeDatabase database;
    private final CompanyDataLoader loader = new CompanyDataLoader();
    private final StatisticsAggregator aggregator = new StatisticsAggregator();

    public void printAnalyzeForLastYear(String filePath, int companyId) throws IOException {
        var company = database.getById(companyId);
        var impacts = loader.loadFromFile(filePath);
        var endDate = LocalDate.now();
        var startDate = endDate.minusYears(1);
        System.out.printf("Company Name: %s%n", company.getName());
        System.out.printf("Today's day: %s%n", startDate);
        System.out.println("Month    GasEmission");
        var volumesByYearMonth = impacts.stream()
                .filter(impact -> impact.getCompanyId() == companyId)
                .filter(impact -> impact.getDate().isAfter(startDate)
                        && impact.getDate().isBefore(endDate))
                .collect(Collectors.groupingBy(
                        impact -> YearMonth.from(impact.getDate()),
                        Collectors.summingDouble(EnvironmentalImpact::getVolume)
                ));
        volumesByYearMonth.forEach((yearMonth, volume) -> {
            var date = yearMonth.format(DateTimeFormatter.ofPattern("yyyy.MM"));
            System.out.printf("%s  %s%n", date, volume);
        });
        var totalVolumesByCompanyId = aggregator.aggregate(startDate, endDate, impacts, GAS_EMISSION);
        System.out.printf("Total    %s%n", totalVolumesByCompanyId.get(companyId));
    }

    public void printTop3CompaniesWithHighestGasEmissionForLastYear(String filePath,
                                                                    LocalDate date) throws IOException {
        var impacts = loader.loadFromFile(filePath);
        var companyField = "Company";
        var totalField = "TotalGasEmission";
        var averageField = "AvgGasEmission/Month";
        var minField = "MinGasEmission/Month";
        var spacesAfterCompany = 8;
        var spacesBtw = 2;
        var sb = new StringBuilder();
        sb.append(companyField).append(" ".repeat(spacesAfterCompany))
                .append(totalField).append(" ".repeat(spacesBtw))
                .append(averageField).append(" ".repeat(spacesBtw))
                .append(minField).append("\n");
        impacts.stream()
                .filter(impact -> impact.getDate().isBefore(date))
                .collect(Collectors.groupingBy(
                        EnvironmentalImpact::getCompanyId,
                        Collectors.collectingAndThen(Collectors.toSet(), companyImpacts -> {
                            var volumesByYearMonth = companyImpacts.stream()
                                    .collect(Collectors.groupingBy(
                                            impact -> YearMonth.from(impact.getDate()),
                                            Collectors.summingDouble(EnvironmentalImpact::getVolume)
                                    ));

                            var total = volumesByYearMonth.values().stream()
                                    .mapToDouble(Double::doubleValue)
                                    .sum();
                            var average = volumesByYearMonth.values().stream()
                                    .mapToDouble(Double::doubleValue)
                                    .average()
                                    .orElseThrow();
                            var min = volumesByYearMonth.values().stream()
                                    .mapToDouble(Double::doubleValue)
                                    .min()
                                    .orElseThrow();
                            return List.of(
                                    Math.round(total * 100.0) / 100.0,
                                    Math.round(average * 100.0) / 100.0,
                                    Math.round(min * 100.0) / 100.0
                            );
                        })
                )).forEach((companyId, volumes) -> {
                    var company = database.getById(companyId);
                    var companyName = company.getName();
                    var total = volumes.get(0);
                    var average = volumes.get(1);
                    var min = volumes.get(2);
                    sb.append(companyName)
                            .append(" ".repeat(companyField.length() + spacesAfterCompany - companyName.length()))
                            .append(total)
                            .append(" ".repeat(totalField.length() + spacesBtw - String.valueOf(total).length()))
                            .append(average)
                            .append(" ".repeat(averageField.length() + spacesBtw - String.valueOf(average).length()))
                            .append(min)
                            .append(" ".repeat(minField.length() + spacesBtw - String.valueOf(min).length()))
                            .append("\n");
                });
        System.out.println(sb);
    }

    public void printGasEmissionPerEmployeeForLastYear(String filePath) throws IOException {
        var impacts = loader.loadFromFile(filePath);
        var companyField = "Company";
        var totalField = "TotalGasEmission";
        var employeesField = "Employees";
        var perEmpField = "GasEmissionPerEmployee";
        var spacesAfterCompany = 8;
        var spacesBtw = 2;
        var sb = new StringBuilder();
        sb.append(companyField).append(" ".repeat(spacesAfterCompany))
                .append(totalField).append(" ".repeat(spacesBtw))
                .append(employeesField).append(" ".repeat(spacesBtw))
                .append(perEmpField).append("\n");
        var endDate = LocalDate.now();
        var startDate = endDate.minusYears(1);
        impacts.stream()
                .filter(impact -> impact.getDate().isBefore(endDate)
                        && impact.getDate().isAfter(startDate))
                .collect(Collectors.groupingBy(
                        EnvironmentalImpact::getCompanyId,
                        Collectors.collectingAndThen(
                                Collectors.toSet(),
                                companyImpacts -> companyImpacts.stream()
                                        .mapToDouble(EnvironmentalImpact::getVolume)
                                        .sum())
                )).forEach((companyId, total) -> {
                    var company = database.getById(companyId);
                    var companyName = company.getName();
                    var emp = company.getTotalEmployees();
                    var perEmp = Math.round(total / emp * 100.0) / 100.0;
                    sb.append(companyName)
                            .append(" ".repeat(companyField.length() + spacesAfterCompany - companyName.length()))
                            .append(total)
                            .append(" ".repeat(totalField.length() + spacesBtw - String.valueOf(total).length()))
                            .append(emp)
                            .append(" ".repeat(employeesField.length() + spacesBtw - String.valueOf(emp).length()))
                            .append(perEmp)
                            .append(" ".repeat(perEmpField.length() + spacesBtw - String.valueOf(perEmp).length()))
                            .append("\n");
                });
        System.out.println(sb);
    }
}
