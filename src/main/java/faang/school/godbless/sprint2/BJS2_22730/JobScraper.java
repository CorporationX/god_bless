package faang.school.godbless.sprint2.BJS2_22730;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public class JobScraper {

    public static Job jsonToJobConverter(String jsonString) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.registerModule(new JavaTimeModule());
            mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

            return mapper.readValue(jsonString, Job.class);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}