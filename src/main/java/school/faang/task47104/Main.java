package school.faang.task47104;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.File;
import java.io.IOException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class Main {
    public static void main(String[] args) {
        ObjectMapper objectMapper = new ObjectMapper();
        JobStreamProcessor jobStreamProcessor = new JobStreamProcessor();
        objectMapper.registerModule(new JavaTimeModule());

        try {
            List<String> batch = new ArrayList<>();
            JsonNode jsonNode = objectMapper.readTree(new File("src/main/java/school/faang/task47104/vacancies.json"));
            Stream<String> jsonStream = StreamSupport.stream(jsonNode.spliterator(), false)
                    .map(JsonNode::toString)
                    .peek(string -> {
                        batch.add(string);

                        Runnable run = () -> {
                            batch.forEach(jsonString -> {
                                try {
                                    objectMapper.writeValueAsString(jsonString);
                                } catch (JsonProcessingException e) {
                                    throw new RuntimeException(e);
                                }
                            });
                            batch.clear();
                        };

                        if (batch.size() == 100) {
                            run.run();
                        }

                        if (!batch.isEmpty()) {
                            run.run();
                        }
                    });

            List<Job> jobs = jobStreamProcessor.dataProcessing(jsonStream);
            DataAnalyzer.topDemandedRequirements(jobs);
            DataAnalyzer.popularPosition(jobs);
            DataAnalyzer.salaryByVacancies(jobs);
            DataAnalyzer.popularLocation(jobs);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
