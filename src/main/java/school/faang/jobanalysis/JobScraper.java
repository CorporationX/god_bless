package school.faang.jobanalysis;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class JobScraper {
    public Stream<Job> parseJobs(String json) {
        List<Job> jobList = new ArrayList<>();
        try {
            JsonNode jsonArray = new ObjectMapper().readTree(json);

            for (JsonNode jsonNode : jsonArray) {
                List<String> requirementsList = new ArrayList<>();
                JsonNode requirementsArray = jsonNode.path("requirements");

                for (JsonNode requirement : requirementsArray) {
                    requirementsList.add(requirement.asText());
                }

                String datePostedStr = jsonNode.path("datePosted").asText();
                Optional<LocalDate> datePosted = datePostedStr.isEmpty() ?
                        Optional.empty() : Optional.of(LocalDate.parse(datePostedStr
                        , DateTimeFormatter.ISO_DATE));

                Job job = Job.builder()
                        .position(jsonNode.path("position").asText())
                        .requirements(requirementsList)
                        .salary(jsonNode.path("salary").asInt())
                        .location(jsonNode.path("location").asText())
                        .datePosted(datePosted.orElse(null))
                        .build();

                jobList.add(job);
            }
        } catch (IOException e) {
            System.err.println("Ошибка при парсинге JSON: " + e.getMessage());
        }
        return jobList.stream();
    }
}
