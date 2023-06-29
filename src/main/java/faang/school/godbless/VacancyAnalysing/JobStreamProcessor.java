package faang.school.godbless.VacancyAnalysing;

import java.io.File;
import java.util.List;
import java.util.Objects;

public class JobStreamProcessor {
    private JobScraper jobScraper;

    public JobStreamProcessor(JobScraper jobScraper) {
        this.jobScraper = jobScraper;
    }

    public List<Job> parse(File fileJsonName) {
        return jobScraper.transformJsonToJob(fileJsonName)
                .stream()
                .filter(Objects::nonNull)
                .peek(System.out::println)
                .toList();
    }

    public static void main(String[] args) {
        File file = new File("src/main/java/faang/school/godbless/VacancyAnalysing/vacancies.json");
        List<Job> parse = new JobStreamProcessor(new JobScraper()).parse(file);
        Job job = parse.get(0);
        System.out.println(job);
    }
}
