package school.faang.sprint_2.task_47167;

import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        JobStreamProcessor jobStreamProcessor = new JobStreamProcessor();
        List<Job> jobs = jobStreamProcessor.processJobStream(Main.class.getResourceAsStream("/vacancies.json"));
        DataAnalyzer dataAnalyzer = new DataAnalyzer(jobs);

        dataAnalyzer.printTopRequirements();
        dataAnalyzer.printTopPositionNames();
        dataAnalyzer.printSalarySpreadWithJobs();
        dataAnalyzer.printTopOfficeLocations();
    }
}
