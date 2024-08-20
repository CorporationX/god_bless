package faang.school.godbless.BJS2_22757;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        JobStreamProcessor streamProcessor = new JobStreamProcessor(new JacksonJobScraper());
        List<String> jsonJobs = List.of(
                "{\"jobName\": \"Software Engineer\", \"salary\": 150000, \"location\": \"Moscow\", \"postingDate\": \"2024-08-01\", \"skills\": [\"Python\", \"Django\", \"REST API\"]}",
                "{\"jobName\": \"Data Analyst\", \"salary\": 100000, \"location\": \"Saint Petersburg\", \"postingDate\": \"2024-08-05\", \"skills\": [\"SQL\", \"Excel\", \"Python\"]}",
                "{\"jobName\": \"Frontend Developer\", \"salary\": 120000, \"location\": \"Novosibirsk\", \"postingDate\": \"2024-08-10\", \"skills\": [\"JavaScript\", \"React\", \"HTML\", \"CSS\"]}",
                "{\"jobName\": \"Project Manager\", \"salary\": 180000, \"location\": \"Kazan\", \"postingDate\": \"2024-08-12\", \"skills\": [\"Agile\", \"Scrum\", \"JIRA\"]}",
                "{\"jobName\": \"System Administrator\", \"salary\": 110000, \"location\": \"Yekaterinburg\", \"postingDate\": \"2024-08-03\", \"skills\": [\"Linux\", \"Networking\", \"Bash\"]}",
                "{\"jobName\": \"UX/UI Designer\", \"salary\": 130000, \"location\": \"Rostov-on-Don\", \"postingDate\": \"2024-08-07\", \"skills\": [\"Figma\", \"Sketch\", \"Adobe XD\"]}",
                "{\"jobName\": \"DevOps Engineer\", \"salary\": 160000, \"location\": \"Nizhny Novgorod\", \"postingDate\": \"2024-08-15\", \"skills\": [\"Docker\", \"Kubernetes\", \"CI/CD\"]}",
                "{\"jobName\": \"Mobile Developer\", \"salary\": 140000, \"location\": \"Samara\", \"postingDate\": \"2024-08-09\", \"skills\": [\"Swift\", \"Kotlin\", \"React Native\"]}",
                "{\"jobName\": \"QA Engineer\", \"salary\": 105000, \"location\": \"Omsk\", \"postingDate\": \"2024-08-04\", \"skills\": [\"Selenium\", \"JUnit\", \"TestNG\"]}",
                "{\"jobName\": \"Business Analyst\", \"salary\": 170000, \"location\": \"Vladivostok\", \"postingDate\": \"2024-08-14\", \"skills\": [\"SQL\", \"Power BI\", \"Requirements Analysis\"]}"
        );
        List<Job> jobs = streamProcessor.convertStream(jsonJobs.stream());
        DataAnalyzer analyzer = new DataAnalyzer();
        analyzer.viewMostPopularJobSkills(jobs);
        analyzer.viewMostPopularJobNames(jobs);
        analyzer.viewMostPopularLocation(jobs);
        analyzer.viewJobDistributionBySalary(jobs);
    }
}
