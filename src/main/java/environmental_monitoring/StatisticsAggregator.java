package environmental_monitoring;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StatisticsAggregator {
    /**
     * This method aggregates the emissions of companies over a given time period.
     * It sums up the emissions of companies with the same name and type of impact.
     *
     * @param startDate the date from which the aggregation starts
     * @param endDate the date until which the aggregation ends
     * @param impacts a list of environmental impacts
     * @param type the type of impact to be aggregated
     * @return a map where the keys are the names of companies and the values are the aggregated emissions
     */
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

    /**
     * Check if a given date is within a given range.
     *
     * @param date      the date to check
     * @param startDate the start date of the range
     * @param endDate   the end date of the range
     * @return true if date is within the range, false otherwise
     */
    private boolean isWithinDateRange(String date, String startDate, String endDate) {
        return date.compareTo(startDate) >= 0 && date.compareTo(endDate) <= 0;
    }

    /**
     * Given a company ID, returns the name of the company.
     *
     * @param companyId the ID of the company
     * @return the name of the company
     */
    private String getCompanyNameById(int companyId) {
        return "Some Company " + companyId;
    }
}
