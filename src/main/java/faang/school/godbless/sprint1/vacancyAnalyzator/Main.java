package faang.school.godbless.sprint1.vacancyAnalyzator;

import java.util.Arrays;
import java.util.List;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Evgenii Malkov
 */
@Slf4j
public class Main {
  public static void main(String[] args) {
    JobStreamProcessor streamProcessor = new JobStreamProcessor();
    List<Job> jobs = streamProcessor.convertStreamToJobList(Arrays.stream(getJsonDataArray()));

    log.info(String.format("1. Most popular skills: %s", DataAnalyzer.mostPopularSkills(jobs, 1)));
    log.info(String.format("2. Most popular positions: %s", DataAnalyzer.mostPopularPositions(jobs, 2)));
    log.info(String.format("3. Salary range by position: %s", DataAnalyzer.salaryCountVacanciesAnalyze(jobs, 10000)));
    log.info(String.format("4. Most popular location: %s", DataAnalyzer.mostPopularLocation(jobs, 2)));

  }

  private static String[] getJsonDataArray() {
    return new String[] {
        "{\n"
        + "    \"position\": \"Software Engineer\",\n"
        + "    \"skills\": [\"Java\", \"Spring\", \"Hibernate\"],\n"
        + "    \"salary\": 80000,\n"
        + "    \"location\": \"San Francisco\",\n"
        + "    \"postedAt\": \"2023-04-28\"\n"
        + "}",
        "{\n"
        + "    \"position\": \"Data Scientist\",\n"
        + "    \"skills\": [\"Python\", \"Machine Learning\", \"Data Visualization\"],\n"
        + "    \"salary\": 90000,\n"
        + "    \"location\": \"New York\",\n"
        + "    \"postedAt\": \"2023-04-25\"\n"
        + "}",
        "{\n"
        + "    \"position\": \"UI/UX Designer\",\n"
        + "    \"skills\": [\"UI Design\", \"Prototyping\", \"User Research\"],\n"
        + "    \"salary\": 75000,\n"
        + "    \"location\": \"Los Angeles\",\n"
        + "    \"postedAt\": \"2023-05-25\"\n"
        + "}",
        "{\n"
        + "    \"position\": \"Software Engineer\",\n"
        + "    \"skills\": [\"Java\"],\n"
        + "    \"salary\": 75000,\n"
        + "    \"location\": \"New York\",\n"
        + "    \"postedAt\": \"2023-02-23\"\n"
        + "}",
        "{\n"
        + "    \"position\": \"Software Engineer\",\n"
        + "    \"skills\": [\"Hibernate\", \"UI Design\"],\n"
        + "    \"salary\": 75000,\n"
        + "    \"location\": \"New York\",\n"
        + "    \"postedAt\": \"2023-02-25\"\n"
        + "}",
        "{\n"
        + "    \"position\": \"Data Scientist\",\n"
        + "    \"skills\": [\"Hibernate\", \"UI Design\"],\n"
        + "    \"salary\": 90000,\n"
        + "    \"location\": \"San Francisco\",\n"
        + "    \"postedAt\": \"2023-01-25\"\n"
        + "}",
    };
  }
}
