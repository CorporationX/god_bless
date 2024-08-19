package faang.school.godbless.AnalysisVacantion;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> jsonStrings = new ArrayList<>();

        jsonStrings.add("{\"name\": \"Software Engineer\", \"location\": \"croatia\", \"requirements\": [\"Java\", \"Spring Boot\", \"REST API\"], \"salary\": 120000, \"addDate\": \"2024-08-19T18:15:30\"}");
        jsonStrings.add("{\"name\": \"Data Analyst\", \"location\": \"russia\", \"requirements\": [\"Java\", \"Python\", \"Data Visualization\"], \"salary\": 95000, \"addDate\": \"2024-08-19T18:15:30\"}");
        jsonStrings.add("{\"name\": \"developer\", \"location\": \"usa\", \"requirements\": [\"Project Management\", \"Python\", \"Scrum\"], \"salary\": 110000, \"addDate\": \"2024-08-19T18:15:30\"}");
        jsonStrings.add("{\"name\": \"developer\", \"location\": \"usa\", \"requirements\": [\"Figma\", \"Spring Boot\", \"Python\"], \"salary\": 85000, \"addDate\": \"2024-08-19T18:15:30\"}");

        JobStreamProcessor jobStreamProcessor = new JobStreamProcessor();
        List<Job> jobs = jobStreamProcessor.process(jsonStrings.stream());

        DataAnalyzer dataAnalyzer = new DataAnalyzer();
        dataAnalyzer.topFiveSkills(jobs).forEach(System.out::println);
        dataAnalyzer.topFiveVacantNames(jobs).forEach(System.out::println);
        dataAnalyzer.topFiveVacantOffices(jobs).forEach(System.out::println);
        dataAnalyzer.salaryRange(jobs).forEach((range, count) -> System.out.println(range + ": " + count));
    }
}

