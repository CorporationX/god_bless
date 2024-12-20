package school.faang.bjs247244;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        JobStreamProcessor jobStreamProcessor = new JobStreamProcessor();
        List<Job> jobs = null;

        try (Stream<String> jsonStream = Files.lines(Paths.get("god_bless/vacancies.json"))) {
            jobs = jobStreamProcessor.getProcessJobs(jsonStream);
        } catch (IOException ex) {
            throw new RuntimeException("An error occurred during execution!" + ex);
        }

        if (jobs != null) {
            DataAnalyzer dataAnalyzer = new DataAnalyzer();
            List<String> topSkills = dataAnalyzer.getTopSkills(jobs);
            System.out.println("************ топ-5 наиболее востребованных навыков ******************************");
            topSkills.forEach(System.out::println);


            List<String> topItemNames = dataAnalyzer.getTopItemNames(jobs);
            System.out.println("************ топ-5 популярных названий позиций **********************************");
            topItemNames.forEach(System.out::println);

            Map<String, List<Job>> getSalaryDistribByVacancy = dataAnalyzer.getSalaryDistribByVacancy(jobs);

            System.out.println("************ распределения зарплат по вакансиям, группируя их по диапазонам ****");
            getSalaryDistribByVacancy.forEach((range, vacancyList) -> {
                System.out.println("Salary Range: " + range);
                vacancyList.forEach(System.out::println);
                System.out.println();
            });


            List<String> topOfficeLocations = dataAnalyzer.getTopOfficeLocations(jobs);
            System.out.println("************ топ-5 популярных местоположений офисов *****************************");
            topOfficeLocations.forEach(System.out::println);

        } else {
            throw new RuntimeException("The list of job is null!");
        }
    }
}
