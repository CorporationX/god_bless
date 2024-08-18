package faang.school.godbless.BJS2_23005;

import java.io.File;
import java.time.LocalDate;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class EnvironmentalImpactAnalyzer {

    public static void analyseLastYearForIdCompany(File file, int id) {
        LocalDate lastYear = LocalDate.now().minusYears(1L);
        List<EnvironmentalImpact> impacts = CompanyDataLoader.parseCsvToEnvironmentalImpact(file)
                .orElse(new ArrayList<>())
                .stream()
                .filter(impact -> impact.getCompanyId() == id)
                .toList();

        Stream.iterate(lastYear, date -> !date.isAfter(LocalDate.now()), date -> date.plusMonths(1L))
                .flatMap(date -> {
                    Map<Integer, Double> map = StatisticsAggregator.sumImpactByCompanyAndType(
                                    date,
                                    date.plusMonths(1L),
                                    impacts,
                                    TypeEnvironmentalImpact.ENERGY_CONSUMPTION);
                    return Stream.of(new AbstractMap.SimpleEntry<>(date, map.getOrDefault(id, 0D)));
                })
                .forEach(entry -> System.out.printf("%s %.2f%n", entry.getKey(), entry.getValue()));
    }
}
