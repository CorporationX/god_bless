package school.faang.bjs2_70725;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.experimental.UtilityClass;

import java.util.List;

@UtilityClass
public class JobScraper {
    private final ObjectMapper mapper = new ObjectMapper();

    public List<Job> parseJson(String jsonString) {
        try {
            return mapper.readValue(jsonString, new TypeReference<>() {});
        } catch (JsonProcessingException e) {
            throw new IllegalArgumentException(String.format("String %s could not be parsed", jsonString));
        }
    }
}