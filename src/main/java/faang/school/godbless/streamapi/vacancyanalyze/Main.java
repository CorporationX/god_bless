package faang.school.godbless.streamapi.vacancyanalyze;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.List;
import java.util.function.Function;

public class Main {

    public static void main(String[] args) throws IOException {
        Path jsonJobs = Path.of("src/main/java/faang/school/godbless/streamapi/vacancyanalyze/jobs.json");

        List<Job> jobs = JobStreamProcessor.getJobs(Files.lines(jsonJobs));

        Function<Job, String> doSalaryRange = (job) -> {
            int salary = job.salary();

            if (salary > 0 && salary < 50000) {
                return "0-50k";
            } else if (salary > 50000 && salary < 100000) {
                return "50-100k";
            } else if (salary > 100000 && salary < 150000) {
                return "100-150k";
            } else {
                return "150k+";
            }
        };

        System.out.println(DataAnalyzer.getTopSkills(jobs));

        System.out.println(DataAnalyzer.getTopPositions(jobs));

        System.out.println(DataAnalyzer.getVacanciesBySalaries(jobs, doSalaryRange));

        System.out.println(DataAnalyzer.getTopOffices(jobs));

        System.out.println(DataAnalyzer.analizeTrends(LocalDate.of(2024, 5, 1),
                LocalDate.of(2024, 8, 17),
                TrendGranularity.WEEK,
                jobs));
    }

}
