package faang.school.godbless.bjs2_5223;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        String vacancyJson1 = """
                {
                  "vacancy": "Java - разработчик",
                  "salary": 180000,
                  "location": "Moscow",
                  "createdAt": "2024-02-03",
                  "requirements": [
                    "Java",
                    "Spring",
                    "Docker"
                  ]
                }""";

        String vacancyJson2 = """
                {
                  "vacancy": "Java - разработчик",
                  "salary": 250000,
                  "location": "St.Petersburg",
                  "createdAt": "2024-03-10",
                  "requirements": [
                    "Java 17",
                    "Spring",
                    "Hibernate",
                    "Docker"
                  ]
                }""";

        String vacancyJson3 = """
                {
                  "vacancy": "Программист Java",
                  "salary": 290000,
                  "location": "Moscow",
                  "createdAt": "2024-03-25",
                  "requirements": [
                    "Java 17",
                    "Spring",
                    "Camunda",
                    "Docker",
                    "Kubernetes"
                  ]
                }""";

        List<Job> jobs = JobStreamProcessor.handleStreamToJob(Stream.of(vacancyJson1, vacancyJson2, vacancyJson3), new JobScraperJsonImpl());
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
    }
}
