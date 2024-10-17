package school.faang.electronicdiary;

import com.google.gson.Gson;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class StudentLoader {

    public static List<Student> loadStudents(String filePath) throws IOException {
        Gson gson = new Gson();
        try (Reader reader = Files.newBufferedReader(Paths.get("src/main/resources/students_test_data.json"))) {
            Student[] students = gson.fromJson(reader, Student[].class);
            return Arrays.asList(students);
        }
    }
}
