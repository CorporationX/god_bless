package school.faang.sprint_2.task_47600;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class DataLoader {
    private static final String FILE_PATH = "src/main/resources/sprint_2/task_47600/";

    public static <T> List<T> loadData(String fileName, Class<T> tclass) throws IOException {
        File file = new File(FILE_PATH + fileName);
        ObjectMapper json = new ObjectMapper();
        JavaType classType = json.getTypeFactory().constructCollectionType(List.class, tclass);
        return json.readValue(file, classType);
    }
}
