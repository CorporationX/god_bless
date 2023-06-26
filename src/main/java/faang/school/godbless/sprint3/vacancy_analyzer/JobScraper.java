package faang.school.godbless.sprint3.vacancy_analyzer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class JobScraper {
    private final ObjectMapper mapper;

    public JobScraper() {
        mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
    }

    public Job jsonToPojo(String jsonString) {
        try {
            return mapper.readValue(jsonString, Job.class);
        } catch (JsonProcessingException e) {
            log.error("Ошибка преобразования " + e.getMessage());
        }
        return null;
    }

    public String pojoToJson(Job job) {
        try {
            return mapper.writeValueAsString(job);
        } catch (JsonProcessingException e) {
            log.error("Ошибка преобразования " + e.getMessage());
        }
        return null;
    }
}
