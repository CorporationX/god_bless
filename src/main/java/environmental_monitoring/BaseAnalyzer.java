package environmental_monitoring;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BaseAnalyzer {
    private static final CompanyDataLoader DATA_LOADER = new CompanyDataLoader();

    /**
     * Reads environmental impacts from a CSV file and groups them by their company ID.
     *
     * @param fileName the name of the CSV file to read from
     * @return a map from company ID to a list of environmental impacts
     */
    public Map<Integer, List<EnvironmentalImpact>> getGroupedByCompany(String fileName) {
        List<EnvironmentalImpact> impacts = DATA_LOADER.loadEnvironmentalImpacts(fileName);
        return impacts.stream().collect(Collectors.groupingBy(EnvironmentalImpact::getCompanyId));
    }

    /**
     * Check if a given date is within a given range.
     *
     * @param date      the date to check
     * @param startDate the start date of the range
     * @param endDate   the end date of the range
     * @return true if date is within the range, false otherwise
     */
    protected boolean isWithinDateRange(LocalDate date, LocalDate startDate, LocalDate endDate) {
        return date.isAfter(startDate) && date.isBefore(endDate);
    }

    /**
     * Given a company ID, returns the name of the company.
     *
     * @param companyId the ID of the company
     * @return the name of the company
     */
    protected String getCompanyNameById(int companyId) {
        return "Some Company " + companyId;
    }
}
