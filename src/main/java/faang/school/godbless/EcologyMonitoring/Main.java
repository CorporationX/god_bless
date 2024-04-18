package faang.school.godbless.EcologyMonitoring;

import java.io.File;
import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        File file = new File("/Users/macbookpro/Desktop/god_bless/src/main/java/faang/school/godbless/EcologyMonitoring/test.csv");

        EnvironmentalImpactAnalyzer analyzer = getEnvironmentalImpactAnalyzer();

        analyzer.analyzeCompanyEnvironmentImpact(file, 101);
        System.out.println();
        analyzer.analyzeTopThreeEnvironmentImpactCompanies(file, LocalDate.now());
        System.out.println();
        analyzer.analyzeTopThreeEnvironmentalImpactsPerEmployee(file, LocalDate.now());
    }

    private static EnvironmentalImpactAnalyzer getEnvironmentalImpactAnalyzer() {
        Company company1 = new Company(101, "ABC Inc.", 150);
        Company company2 = new Company(102, "XYZ Corp.", 200);
        Company company3 = new Company(103, "LMN Co.", 80);
        Company company4 = new Company(104, "DEF Ltd.", 300);
        Company company6 = new Company(106, "UVW Industries", 180);
        Company company7 = new Company(107, "JKL Group", 220);
        Company company8 = new Company(108, "RST Corporation", 120);
        Company company9 = new Company(109, "MNO Ltd.", 270);
        Company company10 = new Company(110, "QRS Inc.", 190);

        return new EnvironmentalImpactAnalyzer(List.of(company1, company2, company3, company4,
                company6, company7, company8, company9, company10));
    }
}
