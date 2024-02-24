package LinkID_analizator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<String> jsonJobs = Arrays.asList(
                "{\"jobTitle\":\"Data Scientist\",\"requirementsSkill\":[\"Java\",\"Spring\",\"SQL\"],\"salary\":80000,\"location\":\"Moscow\",\"vacancyDate\":\"2024-02-14\"}",
                "{\"jobTitle\":\"Java Developer\",\"requirementsSkill\":[\"Python\",\"SQL\",\"Statistics\"],\"salary\":100000,\"location\":\"Berlin\",\"vacancyDate\":\"2024-02-13\"}",
                "{\"jobTitle\":\"UI/UX Designer\",\"requirementsSkill\":[\"Java\",\"Adobe Creative Suite\"],\"salary\":70000,\"location\":\"Moscow\",\"vacancyDate\":\"2023-01-12\"}",
                "{\"jobTitle\":\"Java Developer\",\"requirementsSkill\":[\"Java\",\"Spring\"],\"salary\":240000,\"location\":\"Moscow\",\"vacancyDate\":\"2023-01-12\"}",
                "{\"jobTitle\":\"Java Developer\",\"requirementsSkill\":[\"Java\",\"Spring\"],\"salary\":140000,\"location\":\"New York\",\"vacancyDate\":\"2024-01-12\"}",
                "{\"jobTitle\":\"UI/UX Designer\",\"requirementsSkill\":[\"Java\",\"Spring\"],\"salary\":65000,\"location\":\"Berlin\",\"vacancyDate\":\"2024-01-12\"}",
                "{\"jobTitle\":\"Data Engineer\",\"requirementsSkill\":[\"Python\",\"SQL\",\"Hadoop\"],\"salary\":90000,\"location\":\"New York\",\"vacancyDate\":\"2023-05-20\"}",
                "{\"jobTitle\":\"Frontend Developer\",\"requirementsSkill\":[\"JavaScript\",\"React\",\"CSS\"],\"salary\":110000,\"location\":\"San Francisco\",\"vacancyDate\":\"2024-03-15\"}",
                "{\"jobTitle\":\"Backend Developer\",\"requirementsSkill\":[\"Java\",\"Spring\",\"RESTful API\"],\"salary\":130000,\"location\":\"Seattle\",\"vacancyDate\":\"2023-08-10\"}",
                "{\"jobTitle\":\"Product Manager\",\"requirementsSkill\":[\"Agile\",\"Market Research\",\"Project Management\"],\"salary\":150000,\"location\":\"Boston\",\"vacancyDate\":\"2023-12-05\"}",
                "{\"jobTitle\":\"Machine Learning Engineer\",\"requirementsSkill\":[\"Python\",\"TensorFlow\",\"Deep Learning\"],\"salary\":170000,\"location\":\"Chicago\",\"vacancyDate\":\"2024-02-28\"}",
                "{\"jobTitle\":\"Data Analyst\",\"requirementsSkill\":[\"SQL\",\"Excel\",\"Statistics\"],\"salary\":80000,\"location\":\"Los Angeles\",\"vacancyDate\":\"2023-10-22\"}",
                "{\"jobTitle\":\"Full Stack Developer\",\"requirementsSkill\":[\"Java\",\"JavaScript\",\"React\",\"Spring\"],\"salary\":160000,\"location\":\"Austin\",\"vacancyDate\":\"2024-04-18\"}",
                "{\"jobTitle\":\"DevOps Engineer\",\"requirementsSkill\":[\"Linux\",\"Docker\",\"Kubernetes\"],\"salary\":140000,\"location\":\"Denver\",\"vacancyDate\":\"2023-11-30\"}",
                "{\"jobTitle\":\"Cyber Security Analyst\",\"requirementsSkill\":[\"Cybersecurity\",\"Network Security\",\"SIEM\"],\"salary\":120000,\"location\":\"Washington D.C.\",\"vacancyDate\":\"2024-01-10\"}",
                "{\"jobTitle\":\"Software Engineer\",\"requirementsSkill\":[\"Java\",\"Python\",\"C++\"],\"salary\":180000,\"location\":\"San Diego\",\"vacancyDate\":\"2024-06-25\"}"
        );

        JobScraper jobScraper = new JobScraper() {
            @Override
            public Stream<Job> parseJobs(String source) {
                return null;
            }
        };
        JobStreamProcessor jobStreamProcessor = new JobStreamProcessor();
        List<Job> jobList = JobStreamProcessor.process(jsonJobs.stream());
        System.out.println(DataAnalyzer.getTopJobTitles(jobList));
        System.out.println(DataAnalyzer.getTopSkill(jobList));
        System.out.println(DataAnalyzer.getSalaryDistribution(jobList));
        System.out.println(DataAnalyzer.getTopJobTitles(jobList));
        System.out.println(DataAnalyzer.getTopLocations(jobList));
    }
}
