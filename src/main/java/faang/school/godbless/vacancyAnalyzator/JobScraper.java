package faang.school.godbless.vacancyAnalyzator;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

/**
 * @author Evgenii Malkov
 */
public class JobScraper {

  public static Job parseVacancyJsonToJob(String jsonJobData) {
    ObjectMapper objectMapper = new ObjectMapper();
    objectMapper.registerModule(new JavaTimeModule());
    objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
    try {
      return objectMapper.readValue(jsonJobData, Job.class);
    } catch (JsonProcessingException e) {
      throw new RuntimeException("Failed parsing json with Job", e);
    }
  }
}
