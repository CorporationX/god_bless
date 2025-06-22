package school.faang.vacancy;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.io.IOException;

/**
 * @author Danil Pudovkin
 * @since 21.06.2025
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class JobScraper {

    private static final ObjectMapper MAPPER = new ObjectMapper();

    public static Job parseJob(String json) {
        try {
            return MAPPER.readValue(json, Job.class);
        } catch (IOException e) {
            throw new IllegalStateException("Can't process json", e);
        }
    }
}
