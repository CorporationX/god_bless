package school.faang.bjs2_72049;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Slf4j
public class JsonStudentDataLoader implements StudentDataLoader {
    private final String filePath;

    public JsonStudentDataLoader(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public List<Student> loadStudents() {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            File file = new File(filePath);
            StudentJson[] studentJsons = objectMapper.readValue(file, StudentJson[].class);

            return Arrays.stream(studentJsons)
                    .map(student -> new Student(student.firstName, student.lastName, student.subjects))
                    .toList();
        } catch (Exception e) {
            log.error("Ошибка считывания данных!", e);
            return List.of();
        }
    }

    private static class StudentJson {
        public String firstName;
        public String lastName;
        public Map<String, List<Integer>> subjects;
    }
}
