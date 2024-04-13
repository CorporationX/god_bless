package faang.school.godbless.bjs2_5257;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StatisticAggregator {

    public static final CompanyService companyService = new CompanyService();

    public static Map<Company, Double> createCompanyStatEnvImpact(LocalDate startDate, LocalDate endDate,
                                                                  List<EnvironmentalImpact> impacts,
                                                                  TypeImpact typeImpact) {
        return impacts.stream()
                .filter(envImpact -> envImpact.getType().equals(typeImpact))
                .filter(envImpact -> envImpact.getDate().isAfter(startDate) && envImpact.getDate().isBefore(endDate))
                .collect(Collectors.groupingBy(
                        envImpact -> companyService.findCompanyById(envImpact.getCompanyId()),
                        Collectors.reducing(0.0, EnvironmentalImpact::getVolume, Double::sum)
                ));
    }
}
