package school.faang.electronicdiary;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class StudentLoader {

    public static List<Student> loadStudents(String filePath) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return Arrays.asList(objectMapper.readValue(new File( "src/main/resources/students_test_data.json"), Student[].class));
    }
}
