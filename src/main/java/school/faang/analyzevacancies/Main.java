package school.faang.analyzevacancies;

import lombok.extern.slf4j.Slf4j;

import java.io.InputStream;
import java.util.List;

@Slf4j
public class Main {
    private static final JobStreamProcessor jobStreamProcessor = new JobStreamProcessor();
    private static final String FILE_PATH = "vacancies.json";

    public static void main(String[] args) {
        try (InputStream inputStream = Main.class.getClassLoader().getResourceAsStream(FILE_PATH)) {
            List<Job> listVacancies = jobStreamProcessor.processingVacancies(inputStream);
            log.info("{}", listVacancies.toString());
        } catch (Exception exception) {
            log.error(exception.getMessage(), exception);
        }
    }
}
