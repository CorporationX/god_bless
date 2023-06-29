package faang.school.godbless.jobAnalyzer;

import com.google.gson.Gson;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
public class App {
    public static void main(String[] args) {

        FileReader reader = null;
        try {
            reader = new FileReader("dataBase.json");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        Gson gson = new Gson();
        Job[] jobArray = gson.fromJson(reader, Job[].class);
        List<Job> jobs = List.of(jobArray);

        JobStreamProcessor jobStreamProcessor = new JobStreamProcessor();
        DataAnalyzer dataAnalyzer = new DataAnalyzer();

        List<String> topSkills = dataAnalyzer.getTopSkills(jobs, 5);
        System.out.println("Top Skills: " + topSkills);

        List<String> topPositions = dataAnalyzer.getTopPositions(jobs, 5);
        System.out.println("Top Positions: " + topPositions);

        Map<String, Integer> salaryDistribution = dataAnalyzer.getSalaryDistribution(jobs, 50000);
        System.out.println("Salary Distribution: " + salaryDistribution);

        List<String> topLocations = dataAnalyzer.getTopLocations(jobs, 5);
        System.out.println("Top Locations: " + topLocations);

        LocalDate startDate = LocalDate.of(2023, 6, 25);
        LocalDate endDate = LocalDate.of(2023, 6, 29);
        TrendGranularity granularity = TrendGranularity.DAILY;

        dataAnalyzer.analyzeTrends(jobs, startDate, endDate, granularity);
    }
}
