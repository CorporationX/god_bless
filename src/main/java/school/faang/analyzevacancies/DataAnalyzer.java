package school.faang.analyzevacancies;

import lombok.extern.slf4j.Slf4j;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@Slf4j
public class DataAnalyzer {
    private static final int LEADERBOARD_SIZE = 5;
    private static final String PRINT_FORMAT =
            "\nPosition: {}, requirement skills: {}, salary: {}, location: {}, date posted: {}";

    public void findBestSkills(List<Job> vacancies) {
        validateList(vacancies);
        vacancies.stream().flatMap(job -> job.getRequirements().stream())
                .collect(Collectors.groupingBy(key -> key, Collectors.counting()))
                .entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(LEADERBOARD_SIZE).forEach(entry ->
                    log.info("Skill: {}, count mentions: {}", entry.getKey(), entry.getValue()));
    }

    public void findBestPositions(List<Job> vacancies) {
        validateList(vacancies);
        vacancies.stream().map(Job::getPosition)
                .collect(Collectors.groupingBy(key -> key, Collectors.counting()))
                .entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(LEADERBOARD_SIZE).forEach(entry ->
                        log.info("Position: {}, count mentions: {}", entry.getKey(), entry.getValue()));
    }

    public void distributionSalariesByVacancies(List<Job> vacancies) {
        validateList(vacancies);
        List<Job> jobs = vacancies.stream().sorted(Comparator.comparing(Job::getSalary)).toList();
        log.info("\nSmall salaries by vacancies: ");
        printVacanciesBySalary(jobs.stream()
                .filter(job -> job.getSalary() >= 50000 && job.getSalary() < 100000).toList());
        log.info("\nMiddle salaries by vacancies:");
        printVacanciesBySalary(jobs.stream()
                .filter(job -> job.getSalary() >= 100000 && job.getSalary() < 150000).toList());
        log.info("\nBig salaries by vacancies:");
        printVacanciesBySalary(jobs.stream()
                .filter(job -> job.getSalary() >= 150000 && job.getSalary() < 200000).toList());
    }

    private void printVacanciesBySalary(List<Job> vacancies) {
        vacancies.forEach(job ->
                log.info(PRINT_FORMAT, job.getPosition(), String.join(", ", job.getRequirements()),
                        job.getSalary(), job.getLocation(), job.getDatePosted()));
    }

    public void findBestLocations(List<Job> vacancies) {
        validateList(vacancies);
        vacancies.stream().map(Job::getLocation)
                .collect(Collectors.groupingBy(key -> key, Collectors.counting()))
                .entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(LEADERBOARD_SIZE).forEach(entry ->
                        log.info("Location: {}, count mentions: {}", entry.getKey(), entry.getValue()));
    }

    private void validateList(List<Job> vacancies) {
        Objects.requireNonNull(vacancies, "Invalid list value");
        if (vacancies.isEmpty()) {
            throw new IllegalArgumentException("List is empty");
        }
    }
}
