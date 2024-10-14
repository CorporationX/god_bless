package environmental_monitoring;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StatisticsAggregator extends BaseAnalyzer {
    /**
     * This method aggregates the emissions of companies over a given time period.
     * It sums up the emissions of companies with the same name and type of impact.
     *
     * @param startDate the date from which the aggregation starts
     * @param endDate   the date until which the aggregation ends
     * @param impacts   a list of environmental impacts
     * @param type      the type of impact to be aggregated
     * @return a map where the keys are the names of companies and the values are the aggregated emissions
     */
    public Map<String, Double> aggregateStatistics(LocalDate startDate, LocalDate endDate, List<EnvironmentalImpact> impacts, ImpactType type) {
        Map<String, Double> companyEmissions = new HashMap<>();

        for (EnvironmentalImpact impact : impacts) {
            if (impact.getType().equals(type) && isWithinDateRange(impact.getDate(), startDate, endDate)) {
                String companyName = getCompanyNameById(impact.getCompanyId());
                companyEmissions.merge(companyName, impact.getVolume(), Double::sum);
            }
        }

        return companyEmissions;
    }
}
