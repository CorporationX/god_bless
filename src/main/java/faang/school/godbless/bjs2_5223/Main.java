package faang.school.godbless.bjs2_5223;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Stream;

@Slf4j
public class Main {
    public static void main(String[] args) {

        var pathFile = Objects.requireNonNull(Main.class.getResource("/vacancies.txt")).getFile();

        try (Stream<String> vacancies = Files.lines(Path.of(pathFile))) {
            List<Job> jobs = JobStreamProcessor.handleStreamToJob(vacancies, new JobScraperJsonImpl());
            DataAnalyzer.findTop5Skills(jobs);
            DataAnalyzer.findTop5Positions(jobs);
            DataAnalyzer.findTop5Locations(jobs);

            Set<RangeSalary> rangeSalarySet = new HashSet<>();
            rangeSalarySet.add(new RangeSalary("0-50k",0, 50000));
            rangeSalarySet.add(new RangeSalary("50k-100k",50000, 100000));
            rangeSalarySet.add(new RangeSalary("100k-200k", 100000, 200000));
            rangeSalarySet.add(new RangeSalary("200k-300k", 200000, 300000));
            Map<RangeSalary, Long> rangeSalaryMap = DataAnalyzer.analyzeDistribSalaryByVacations(jobs, rangeSalarySet);

            System.out.println("\nDistribution of salaries by vacancy");
            for (Map.Entry<RangeSalary, Long> entry : rangeSalaryMap.entrySet()) {
                System.out.println(entry.getKey().getName() + " : " + entry.getValue());
            }
        } catch (IOException e) {
           log.error(e.getMessage());
        }

    }
}
