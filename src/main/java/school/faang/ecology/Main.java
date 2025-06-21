package school.faang.ecology;

import java.io.IOException;
import java.time.LocalDate;

/**
 * @author Danil Pudovkin
 * @since 21.06.2025
 */
public class Main {

    public static void main(String[] args) throws IOException {
        var filePath = "src/main/resources/environmental_impact_100.csv";
        var database = new CompanyFakeDatabase();
        var analyzer = new EnvironmentalImpactAnalyzer(database);
        analyzer.printAnalyzeForLastYear(filePath, 101);
        System.out.println();
        analyzer.printTop3CompaniesWithHighestGasEmissionForLastYear(filePath, LocalDate.now());
        analyzer.printGasEmissionPerEmployeeForLastYear(filePath);
    }
}
