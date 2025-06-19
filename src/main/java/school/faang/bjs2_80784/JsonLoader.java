package school.faang.bjs2_80784;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.InputStream;
import java.util.List;

public class JsonLoader {
    private static final ObjectMapper mapper = new ObjectMapper()
            .registerModule(new JavaTimeModule());

    public static <T> List<T> loadListFromResource(
            String resourceName, TypeReference<List<T>> typeRef) throws Exception {

        try (InputStream inputStream = JsonLoader.class.getClassLoader().getResourceAsStream(resourceName)) {
            if (inputStream == null) {
                throw new IllegalArgumentException("Resource not found: " + resourceName);
            }

            return mapper.readValue(inputStream, typeRef);
        }
    }
}
