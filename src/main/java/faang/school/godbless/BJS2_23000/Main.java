package faang.school.godbless.BJS2_23000;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        String json1 = "{ \"name\": \"Software Engineer\", \"requirements\": [\"Java\", \"Spring Framework\", \"SQL\"," +
                " \"REST APIs\"], \"salary\": 120000, \"location\": \"New York, NY\", \"dateAddition\": \"2024-08-15T10:15:30\" }";
        String json2 = "{ \"name\": \"Data Analyst\", \"requirements\": [\"Python\", \"Pandas\", \"SQL\", \"Java\", \"Data Visualization\"]," +
                " \"salary\": 90000, \"location\": \"San Francisco, CA\", \"dateAddition\": \"2024-07-30T09:45:00\" }";
        String json3 = "{ \"name\": \"Project Manager\", \"requirements\": [\"Agile Methodology\", \"Java\", \"Team Leadership\", \"Jira\"," +
                " \"Communication Skills\"], \"salary\": 110000, \"location\": \"Chicago, IL\", \"dateAddition\": \"2024-08-10T14:30:00\" }";
        String json4 = """
                {
                    "name": "Software Engineer",
                    "requirements": ["Python", "Django", "API Development"],
                    "salary": 115000,
                    "location": "Austin, TX",
                    "dateAddition": "2024-08-12T11:00:00"
                }""";
        String json5 = """
                {
                    "name": "UX Designer",
                    "requirements": ["User Research", "Wireframing", "Prototyping"],
                    "salary": 95000,
                    "location": "Seattle, WA",
                    "dateAddition": "2024-08-05T10:15:30"
                }""";
        String json6 = """
                {
                    "name": "Software Engineer",
                    "requirements": ["JavaScript", "React", "Node.js"],
                    "salary": 125000,
                    "location": "San Jose, CA",
                    "dateAddition": "2024-08-20T09:30:00"
                }""";
        String json7 = """
                {
                    "name": "Data Scientist",
                    "requirements": ["Machine Learning", "R", "Big Data"],
                    "salary": 240000,
                    "location": "Boston, MA",
                    "dateAddition": "2024-08-08T13:45:00"
                }""";
        String json8 = """
                {
                    "name": "Marketing Manager",
                    "requirements": ["SEO", "Content Strategy", "Social Media Management"],
                    "salary": 203000,
                    "location": "Los Angeles, CA",
                    "dateAddition": "2024-07-25T15:00:00"
                }""";
        String json9 = """
                {
                    "name": "Business Analyst",
                    "requirements": ["Requirements Gathering", "Business Process Modeling", "Data Analysis"],
                    "salary": 85000,
                    "location": "Philadelphia, PA",
                    "dateAddition": "2024-07-25T16:00:00"
                }""";
        String json10 = """
                {
                    "name": "Software Engineer",
                    "requirements": ["C#", ".NET", "Azure"],
                    "salary": 256000,
                    "location": "Atlanta, GA",
                    "dateAddition": "2024-07-25T12:00:00"
                }""";

        Stream<String> jobsStream = Stream.of(json1, json2, json3, json4, json5, json6, json7, json8, json9, json10);
        List<Job> parseJobs = JobScraper.parseJsonToJobs(jobsStream);

        System.out.println(DataAnalyzer.findTopNMostPopularSkills(parseJobs, 2));
        System.out.println();

        System.out.println(DataAnalyzer.findTopNMostPopularPositions(parseJobs, 1));
        System.out.println(DataAnalyzer.mapSalaryRangeByCount(parseJobs));
        System.out.println(DataAnalyzer.findTop5MostPopularLocations(parseJobs));

        System.out.println(DataAnalyzer.analyzeTrends(
                parseJobs,
                LocalDate.of(2024, 6, 12),
                LocalDate.now(),
                new JobDifferencePerDay())
        );
    }
}
