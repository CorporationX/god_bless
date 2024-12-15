package school.faang.sprint_2.task_bjs247301;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.experimental.UtilityClass;

import java.io.File;
import java.io.IOException;
import java.util.List;

@UtilityClass
public class DataParser {
    private final String dirPath = "src/main/resources/sprint_2/task_bjs247301/";

    public <T> List<T> loadData(String fileName, Class<T> clazz) throws IOException {
        File file = new File(dirPath + fileName);
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readerForListOf(clazz).readValue(file);
    }
}
