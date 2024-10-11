package environmental_monitoring;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StatisticsAggregator {
    public Map<String, Double> aggregateStatistics(String startDate, String endDate, List<EnvironmentalImpact> impacts, ImpactType type) {
        Map<String, Double> companyEmissions = new HashMap<>();

        for (EnvironmentalImpact impact : impacts) {
            if (impact.getType().equals(type) && isWithinDateRange(impact.getDate(), startDate, endDate)) {
                String companyName = getCompanyNameById(impact.getCompanyId());
                companyEmissions.merge(companyName, impact.getVolume(), Double::sum);
            }
        }

        return companyEmissions;
    }

    private boolean isWithinDateRange(String date, String startDate, String endDate) {
        return date.compareTo(startDate) >= 0 && date.compareTo(endDate) <= 0;
    }

    private String getCompanyNameById(int companyId) {
        return "Some Company " + companyId;
    }
}
