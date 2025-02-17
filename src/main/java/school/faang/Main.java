package school.faang;

import school.faang.models.Company;
import school.faang.models.CompanyDataLoader;
import school.faang.models.EmissionType;
import school.faang.models.EnvironmentalImpact;
import school.faang.services.EnvironmentalImpactAnalyzer;
import school.faang.services.StatisticAggregator;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public class Main {
    private static final String FILE_PATH = "src/main/resources/company_data.csv";

    public static void main(String[] args) {
        try {
            Company company1 = new Company(1001, "companyName1", 13);
            Company company2 = new Company(1002, "companyName2", 10);
            Company company3 = new Company(1003, "companyName3", 100);

            List<EnvironmentalImpact> impacts =
                    CompanyDataLoader.loadEnvironmentalImpacts(FILE_PATH);
            LocalDate start = LocalDate.now().minusDays(1000);
            LocalDate end = LocalDate.now().plusDays(1);
            System.out.println(StatisticAggregator.getEnvironmentalImpactByCompany(
                    start, end, impacts, EmissionType.AIR_POLLUTION, false));

            EnvironmentalImpactAnalyzer.getEnvironmentalImpactByCompanyInLastYear(FILE_PATH, 1001);
            EnvironmentalImpactAnalyzer.getMostPollutingCompanies(FILE_PATH);
            EnvironmentalImpactAnalyzer.getEnvironmentalImpactPerEmployee(FILE_PATH);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
