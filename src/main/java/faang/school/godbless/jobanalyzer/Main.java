package faang.school.godbless.jobanalyzer;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Stream;

@Slf4j
public class Main {

    private static JobStreamProcessor scarper = new JobStreamProcessor();
    private static DataAnalyzer dataAnalyzer = new DataAnalyzer();

    public static void main(String[] args) {
        List<Job> actualVacancies = null;

        try (Stream<String> vacancies = Files.lines(Path.of("./src/main/resources//vacancies.txt"))) {
            actualVacancies = scarper.process(vacancies);
        } catch (IOException e) {
            log.error(e.getMessage());
        }


        System.out.println(dataAnalyzer.getMostFoundSkills(actualVacancies, 3));
    }
}
