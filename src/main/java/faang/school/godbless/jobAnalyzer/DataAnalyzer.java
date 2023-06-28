package faang.school.godbless.jobAnalyzer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.time.LocalDate;
public class DataAnalyzer {
    public List<String> getTopSkills(List<Job> jobs, int topCount) {
        Map<String, Integer> skillsCount = new HashMap<>();

        for (Job job : jobs) {
            for (String skill : job.getRequirements()) {
                skillsCount.put(skill, skillsCount.getOrDefault(skill, 0) + 1);
            }
        }

        return skillsCount.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .limit(topCount)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    public List<String> getTopPositions(List<Job> jobs, int topCount) {
        Map<String, Integer> positionsCount = new HashMap<>();

        for (Job job : jobs) {
            positionsCount.put(job.getPosition(), positionsCount.getOrDefault(job.getPosition(), 0) + 1);
        }

        return positionsCount.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .limit(topCount)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    public Map<String, Integer> getSalaryDistribution(List<Job> jobs, int salaryRange) {
        Map<String, Integer> salaryDistribution = new TreeMap<>();
        int minSalary = Integer.MAX_VALUE;
        int maxSalary = Integer.MIN_VALUE;

        for (Job job : jobs) {
            int salary = (int) job.getSalary();
            minSalary = Math.min(minSalary, salary);
            maxSalary = Math.max(maxSalary, salary);

            int rangeStart = (salary / salaryRange) * salaryRange;
            int rangeEnd = rangeStart + salaryRange;

            String salaryRangeLabel = rangeStart + " - " + rangeEnd;
            salaryDistribution.put(salaryRangeLabel, salaryDistribution.getOrDefault(salaryRangeLabel, 0) + 1);
        }

        String maxRangeLabel = maxSalary + " and above";
        salaryDistribution.put(maxRangeLabel, salaryDistribution.getOrDefault(maxRangeLabel, 0));

        return salaryDistribution;
    }

    public List<String> getTopLocations(List<Job> jobs, int topCount) {
        Map<String, Integer> locationsCount = new HashMap<>();

        for (Job job : jobs) {
            locationsCount.put(job.getLocation(), locationsCount.getOrDefault(job.getLocation(), 0) + 1);
        }

        return locationsCount.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .limit(topCount)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    public void analyzeTrends(List<Job> jobs, LocalDate startDate, LocalDate endDate, TrendGranularity granularity) {
        Map<LocalDate, Integer> jobCountByDate = new HashMap<>();
        Map<String, Integer> skillCount = new HashMap<>();

        LocalDate currentDate = startDate;
        while (!currentDate.isAfter(endDate)) {
            int jobCount = countJobsOnDate(jobs, currentDate);
            jobCountByDate.put(currentDate, jobCount);

            analyzeSkills(jobs, currentDate, skillCount);


            switch (granularity) {
                case DAILY:
                    currentDate = currentDate.plusDays(1);
                    break;
                case WEEKLY:
                    currentDate = currentDate.plusWeeks(1);
                    break;
                case MONTHLY:
                    currentDate = currentDate.plusMonths(1);
                    break;
            }
        }

        System.out.println("Job Count by Date: " + jobCountByDate);
        System.out.println("Skill Count: " + skillCount);
    }

    private int countJobsOnDate(List<Job> jobs, LocalDate date) {
        return (int) jobs.stream()
                .filter(job -> job.getDateAdded().equals(date))
                .count();
    }

    private void analyzeSkills(List<Job> jobs, LocalDate date, Map<String, Integer> skillCount) {
        jobs.stream()
                .filter(job -> job.getDateAdded().equals(date))
                .flatMap(job -> job.getRequirements().stream())
                .forEach(skill -> skillCount.put(skill, skillCount.getOrDefault(skill, 0) + 1));
    }

}
