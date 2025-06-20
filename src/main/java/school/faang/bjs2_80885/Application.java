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
            analyzer.getTopSkills(jobs, 5)
                    .forEach((skill, count) -> System.out.printf("%s: %d%n", skill, count));

            System.out.println("\n=== TOP POSITIONS ===");
            analyzer.getTopPositions(jobs, 5)
                    .forEach((position, count) -> System.out.printf("%s: %d%n", position, count));

            System.out.println("\n=== SALARY DISTRIBUTION ===");
            analyzer.getSalaryDistribution(jobs)
                    .forEach((range, count) -> System.out.printf("%s: %d%n", range, count));

            System.out.println("\n=== TOP LOCATIONS ===");
            analyzer.getTopLocations(jobs, 5)
                    .forEach((location, count) -> System.out.printf("%s: %d%n", location, count));

        } catch (IOException e) {
            System.err.println("Failed to load or process the file: " + e.getMessage());
        }
    }
}