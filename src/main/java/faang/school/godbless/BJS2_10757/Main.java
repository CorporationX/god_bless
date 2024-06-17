package faang.school.godbless.BJS2_10757;

import com.google.gson.Gson;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Gson gson = new Gson();

        String job_1 = gson.toJson(new Job(JobNames.DEVELOPER, List.of(Skills.SKILL_1, Skills.SKILL_2), 155000, Locations.BERLIN, LocalDateTime.now().toString()));
        String job_2 = gson.toJson(new Job(JobNames.DEVELOPER, List.of(Skills.SKILL_2, Skills.SKILL_2), 145000, Locations.NEW_YORK, LocalDateTime.now().toString()));
        String job_3 = gson.toJson(new Job(JobNames.DEVELOPER, List.of(Skills.SKILL_3, Skills.SKILL_2), 125000, Locations.NEW_YORK, LocalDateTime.now().toString()));
        String job_4 = gson.toJson(new Job(JobNames.HR, List.of(Skills.SKILL_4, Skills.SKILL_2), 105000, Locations.NEW_YORK, LocalDateTime.now().toString()));
        String job_5 = gson.toJson(new Job(JobNames.HR, List.of(Skills.SKILL_5, Skills.SKILL_2), 95000, Locations.NEW_YORK, LocalDateTime.now().toString()));
        String job_6 = gson.toJson(new Job(JobNames.HR, List.of(Skills.SKILL_1, Skills.SKILL_2), 85000, Locations.ROME, LocalDateTime.now().toString()));
        String job_7 = gson.toJson(new Job(JobNames.QA, List.of(Skills.SKILL_2, Skills.SKILL_3), 95000, Locations.ROME, LocalDateTime.now().toString()));
        String job_8 = gson.toJson(new Job(JobNames.QA, List.of(Skills.SKILL_3, Skills.SKILL_2), 115000, Locations.MOSCOW, LocalDateTime.now().toString()));
        String job_9 = gson.toJson(new Job(JobNames.DEVOPS, List.of(Skills.SKILL_4, Skills.SKILL_3), 116000, Locations.SOCHI, LocalDateTime.now().toString()));
        String job_10 = gson.toJson(new Job(JobNames.DEVOPS, List.of(Skills.SKILL_5, Skills.SKILL_3), 118000, Locations.LONDON, LocalDateTime.now().toString()));

        List<String> jobsInJson = new ArrayList<>();

        jobsInJson.add(job_1);
        jobsInJson.add(job_2);
        jobsInJson.add(job_3);
        jobsInJson.add(job_4);
        jobsInJson.add(job_5);
        jobsInJson.add(job_6);
        jobsInJson.add(job_7);
        jobsInJson.add(job_8);
        jobsInJson.add(job_9);
        jobsInJson.add(job_10);

        JobStreamProcessor jobStreamProcessor = new JobStreamProcessor();
        List<Job> jobs = jobStreamProcessor.parseJobs(jobsInJson.stream());

        DataAnalyzer dataAnalyzer = new DataAnalyzer();
        dataAnalyzer.findTopFiveSkills(jobs);
        System.out.println("*********************************************************");
        dataAnalyzer.findTopFiveJobNames(jobs);
        System.out.println("*********************************************************");
        dataAnalyzer.findTopFiveJobLocations(jobs);
        System.out.println("*********************************************************");
        System.out.println(dataAnalyzer.analyzeSalary(jobs));

    }
}
