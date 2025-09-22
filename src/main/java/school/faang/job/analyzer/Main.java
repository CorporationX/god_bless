package school.faang.job.analyzer;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class Main {
    public static void main(String[] args) throws IOException {
        try {
            JobStreamProcessor jobStreamProcessor = new JobStreamProcessor();

            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode rootNode = objectMapper.readTree(new File("src/main/java/school/faang/job/analyzer/input.json"));
            Stream<String> stream = StreamSupport.stream(rootNode.spliterator(), false)
                    .map(JsonNode::toString);

            List<Job> jobsFromFile = jobStreamProcessor.parseFromJson(stream);
            DataAnalyzer dataAnalyzer = new DataAnalyzer();
            System.out.println(dataAnalyzer.getTopNecessarySkills(jobsFromFile));
            System.out.println(dataAnalyzer.getTopLocations(jobsFromFile));
            System.out.println(dataAnalyzer.getTopPosition(jobsFromFile));
            System.out.println(dataAnalyzer.groupingSalariesRanges(jobsFromFile));
        } catch (IOException ioException) {
            System.out.println(ioException.getMessage());
        }

    }
}
