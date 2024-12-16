package school.faang.sprint_2.task_47666;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class StudentLoader {

    public static List<Student> loadStudent(String filePath) throws IOException {
        File file = new File(filePath);
        ObjectMapper json = new ObjectMapper();
        return json.readValue(file, new TypeReference<List<Student>>() {});
    }
}
