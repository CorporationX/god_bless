package school.faang.bjs2_70746;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.experimental.UtilityClass;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@UtilityClass
public class StudentReader {
    public List<Student> parseStudentsFromJson(String filePath) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        try (InputStream inputStream = StudentReader.class.getClassLoader().getResourceAsStream(filePath)) {
            if (inputStream == null) {
                throw new FileNotFoundException(String.format("Resource %s not found", filePath));
            }
            return objectMapper.readValue(inputStream, new TypeReference<>() {});
        }
    }
}