package school.faang.analyzevacancies;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.ArrayList;
import java.io.InputStream;

@Slf4j
public class Main {
    private static final String FILE_PATH = "vacancies.json";
    private static final List<Job> VACANCIES = new ArrayList<>();
    private static final JobStreamProcessor jobStreamProcessor = new JobStreamProcessor();
    private static final DataAnalyzer dataAnalyzer = new DataAnalyzer();

    public static void main(String[] args) {
        try (InputStream inputStream = Main.class.getClassLoader().getResourceAsStream(FILE_PATH)) {
            VACANCIES.addAll(jobStreamProcessor.processingVacancies(inputStream));
            log.info("Top 5 skills: ");
            dataAnalyzer.findBestSkills(VACANCIES);
            log.info("Top 5 positions: ");
            dataAnalyzer.findBestPositions(VACANCIES);
            log.info("Salaries by vacancies: ");
            dataAnalyzer.distributionSalariesByVacancies(VACANCIES);
            log.info("Top 5 locations: ");
            dataAnalyzer.findBestLocations(VACANCIES);
        } catch (Exception exception) {
            log.error(exception.getMessage(), exception);
        }
    }
}
