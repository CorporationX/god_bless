package faang.school.godbless.BJS2_23005;

import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        File file = new File("src/main/resources/info.csv");
        Optional<List<EnvironmentalImpact>> impacts = CompanyDataLoader.parseCsvToEnvironmentalImpact(file);
        List<EnvironmentalImpact> impactList = impacts.orElse(new ArrayList<>());
        System.out.println(impactList);
        System.out.println();

        System.out.println(StatisticsAggregator.sumImpactByCompanyAndType(
                LocalDate.of(2023, 8, 3),
                LocalDate.now(),
                impactList,
                TypeEnvironmentalImpact.ENERGY_CONSUMPTION
        ));
        System.out.println();

        EnvironmentalImpactAnalyzer.analyseLastYearForIdCompany(file, 104);
    }
}
