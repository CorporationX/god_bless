package faang.school.godbless.BJS2_22689;

import javax.xml.crypto.Data;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.List;
import java.util.function.Function;

public class Main {
    public static void main(String[] args) throws IOException {

        Path jsonJobs = Path.of("src/main/java/faang/school/godbless/BJS2_22689/jobs.txt");
        List<Job> jobs = JobStreamProcessor.getJobs(Files.lines(jsonJobs));

        Function<Job, String> doSalaryRange = (job) -> {
            int salary = job.salary();
            if (salary > 0 && salary < 50000)
                return "0-50k";
            else if (salary > 50000 && salary < 100000)
                return "50-100k";
            else if (salary > 100000 && salary < 150000)
                return "100-150k";
            else
                return "150k+";
        };

        System.out.println(DataAnalyzer.getTop5SkillsForCandidates(jobs));
        System.out.println(DataAnalyzer.getTop3Positions(jobs));
        System.out.println(DataAnalyzer.getVacanciesBySalaries(jobs, doSalaryRange));
        System.out.println(DataAnalyzer.getTop5Offices(jobs));
        System.out.println(DataAnalyzer.analizeTrends(LocalDate.of(2024, 5, 1),
                LocalDate.of(2024, 8, 17),
                TrendGranularity.WEEK,
                jobs));
    }
}
