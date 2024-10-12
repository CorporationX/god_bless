package environmental_monitoring;

import lombok.AllArgsConstructor;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
public class EnvironmentalImpactAnalyzer extends BaseAnalyzer{
    private CompanyDataLoader dataLoader;
    private static final int COUNT_MONTHS = 12;
    private static final LocalDate TODAY = LocalDate.parse("2023.02.15", DateFormatter.FULL_DATE_SEPARATED_BY_A_DOT);
    private static final LocalDate LAST_YEAR = LocalDate.parse("2022.02.15", DateFormatter.FULL_DATE_SEPARATED_BY_A_DOT);

    /**
     * Analyze the emissions of a company given its id.
     *
     * @param fileName  the name of the file containing the environmental impacts
     * @param companyId the id of the company to analyze
     */
    public void analyzeEmissions(String fileName, int companyId) {
        List<EnvironmentalImpact> impacts = dataLoader.loadEnvironmentalImpacts(fileName);
        String companyName = getCompanyNameById(companyId);

        Map<String, Double> monthlyEmissions = new HashMap<>();
        for (EnvironmentalImpact impact : impacts) {
            if (impact.getCompanyId() == companyId && isWithinDateRange(impact.getDate(), LAST_YEAR, TODAY)) {
                int monthKey = impact.getDate().getMonth().getValue();
                int year = impact.getDate().getYear();
                monthlyEmissions.merge(String.format("%04d.%02d", year, monthKey), impact.getVolume(), Double::sum);
            }
        }

        double totalEmissions = 0.0;
        System.out.println("Company Name: " + companyName);
        System.out.println("Today's date: " + TODAY);
        System.out.println("Month    GasEmission");
        for (int i = 0; i < COUNT_MONTHS; i++) {
            int year =TODAY.minusMonths(i).getYear();
            LocalDate dateWithOutFormat = LocalDate.of(year, TODAY.minusMonths(i).getMonth(), TODAY.getDayOfMonth());
            String date = dateWithOutFormat.format(DateFormatter.DATE_WITH_YEAR_AND_MONTH);
            double emissions = monthlyEmissions.getOrDefault(date, 0.0);
            System.out.printf("%s  %.2f%n", date, emissions);
            totalEmissions += emissions;
        }
        System.out.printf("Total    %.2f%n", totalEmissions);
    }
}
