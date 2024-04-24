package faang.school.godbless.StreamApiOptional.JobAnalyzer;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class Main {
    public static int POSITION = 1;
    public static void main(String[] args) {

        DataAnalyzer app = new DataAnalyzer();

        String jsonJob1 = """
                {
                  "name": "Senior Java Software Engineer",
                  "margin": 130000,
                  "location": "Cypress",
                  "createdAt": "2024-02-03",
                  "requirements": [
                    "Java",
                    "English",
                    "Communication Skills",
                    "Spring",
                    "Docker",
                    "Redis"
                  ]
                }""";

        String jsonJob2 = """
                {
                  "name": "Senior Java Software Engineer",
                  "margin": 160000,
                  "location": "Saint-Petersburg",
                  "createdAt": "2023-03-03",
                  "requirements": [
                    "Java",
                    "English",
                    "Communication Skills",
                    "Spring",
                    "Docker",
                    "5 years experience"

                  ]
                }""";

        String jsonJob3 = """
                {
                  "name": "Manager",
                  "margin": 40000,
                  "location": "Bali",
                  "createdAt": "2022-07-03",
                  "requirements": [
                    "Communication Skills",
                    "English",
                    "Spring",
                    "Java"
                  ]
                }""";

        String jsonJob4 = """
                {
                  "name": "Manager",
                  "margin": 60000,
                  "location": "Bali",
                  "createdAt": "2024-03-23",
                  "requirements": [
                    "Communication Skills",
                    "English",
                    "Spring",
                    "Java"
                  ]
                }""";

        String jsonJob5 = """
                {
                  "name": "Marketer",
                  "margin": 90000,
                  "location": "Bali",
                  "createdAt": "2023-02-30",
                  "requirements": [
                    "Communication Skills",
                    "English",
                    "Spring",
                    "5 years experience"
                  ]
                }""";

        String jsonJob6 = """
                {
                  "name": "Manager",
                  "margin": 100000,
                  "location": "Tallinn",
                  "createdAt": "2024-01-10",
                  "requirements": [
                    "Communication Skills",
                    "English",
                    "Google Docs"
                  ]
                }""";

        String jsonJob7 = """
                {
                  "name": "Analyst",
                  "margin": 90000,
                  "location": "Dubai",
                  "createdAt": "2024-01-12",
                  "requirements": [
                    "Communication Skills",
                    "English",
                    "Power BI",
                    "Excel",
                    "5 years experience"
                  ]
                }""";

        String jsonJob8 = """
                {
                  "name": "Senior Java Software Engineer",
                  "margin": 190000,
                  "location": "Dubai",
                  "createdAt": "2023-09-16",
                  "requirements": [
                    "Communication Skills",
                    "English",
                    "5 years experience"
                  ]
                }""";

        String jsonJob9 = """
                {
                  "name": "HR",
                  "margin": 120000,
                  "location": "California",
                  "createdAt": "2023-12-29",
                  "requirements": [
                    "Communication Skills",
                    "English",
                    "React",
                    "Angular"
                  ]
                }""";

        String jsonJob10 = """
                {
                  "name": "HR",
                  "margin": 70000,
                  "location": "Berlin",
                  "createdAt": "2024-01-26",
                  "requirements": [
                    "Communication Skills",
                    "English",
                    "German",
                  ]
                }""";

        List<Job> jobs = JobStreamProcessor.getListOfJobs(Stream.of(jsonJob1, jsonJob2, jsonJob3, jsonJob4, jsonJob5, jsonJob6, jsonJob7, jsonJob8, jsonJob9, jsonJob10));

        System.out.println("Top-5 skills:");
        Map<String, Long> top5SkillsList = app.getTop5Skills(jobs);
        for (Map.Entry<String, Long> skill : top5SkillsList.entrySet()) {
            System.out.println("\t" + POSITION++ + "." + skill.getKey() +
                    " = " + skill.getValue());
        }

        System.out.println();

        System.out.println("Top-5 jobs:");
        POSITION = 1;
        Map<String, Long> top5JobsList = app.getTop5Jobs(jobs);
        for (Map.Entry<String, Long> job : top5JobsList.entrySet()) {
            System.out.println("\t" + POSITION++ + "." + job.getKey() +
                    " = " + job.getValue());
        }

        System.out.println();

        System.out.println("Jobs by salary:");
        POSITION = 1;
        Map<String, String> jobsDistributebBySalary = app.getJobListOrganizedByMargin(jobs);
        for (Map.Entry<String, String> job : jobsDistributebBySalary.entrySet()) {
            System.out.println(POSITION++ + ".Salary between " + job.getKey() + ":\n" +
                      job.getValue() + "\n");
        }

        System.out.println();

        System.out.println("Top-5 locations:");
        POSITION = 1;
        Map<String, Long> top5LocationList = app.getTop5Locations(jobs);
        for (Map.Entry<String, Long> job : top5LocationList.entrySet()) {
            System.out.println("\t" + POSITION++ + "." + job.getKey() +
                    " = " + job.getValue());
        }
    }
}
