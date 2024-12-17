package school.faang.sprint_2.task_bjs247301;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.experimental.UtilityClass;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@UtilityClass
public class DataParser {
    private final String resourcesDirPath = "sprint_2/task_bjs247301/";

    public <T> List<T> loadData(String fileName, Class<T> clazz) throws IOException {
        String filePath = resourcesDirPath + fileName;
        ObjectMapper mapper = new ObjectMapper();
        try (InputStream inputStream = DataParser.class.getClassLoader().getResourceAsStream(filePath)) {
            if (inputStream == null) {
                throw new IOException("File not found in " + filePath);
            }
            return mapper.readerForListOf(clazz).readValue(inputStream);
        }
    }
}
