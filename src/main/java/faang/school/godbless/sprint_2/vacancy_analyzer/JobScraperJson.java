package faang.school.godbless.sprint_2.vacancy_analyzer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;

public class JobScraperJson extends JobScraper {
    @Override
    public Job readValue(String data) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(data, Job.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}