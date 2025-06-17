package school.faang.bjs2_80885;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        JobStreamProcessor jobStreamProcessor = new JobStreamProcessor();
        DataAnalyzer analyzer = new DataAnalyzer();

        try (InputStream is = Application.class.getClassLoader().getResourceAsStream("vacancies.json")) {
            if (is == null) {
                System.err.println("File not found: vacancies.json");
                return;
            }

            List<Job> jobs = jobStreamProcessor.processJobs(is);

            System.out.println("=== TOP SKILLS ===");
            analyzer.printTopSkills(jobs);

            System.out.println("\n=== TOP POSITIONS ===");
            analyzer.printTopPositions(jobs);

            System.out.println("\n=== SALARY DISTRIBUTION ===");
            analyzer.printSalaryDistribution(jobs);

            System.out.println("\n=== TOP LOCATIONS ===");
            analyzer.printTopLocations(jobs);

        } catch (IOException e) {
            System.err.println("Failed to load or process the file: " + e.getMessage());
        }
    }
}