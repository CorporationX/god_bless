package school.faang.electronic_devil;

import com.google.gson.Gson;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
@Getter
@EqualsAndHashCode
@ToString
public class Student {
    private final String firstName;
    private final String lastName;
    private final Map<String, List<Integer>> subjects;

    public static List<Student> loadStudents(String filePath) throws IOException {
        Path path = Paths.get(filePath);
        if (!Files.exists(path)) {
            throw new FileNotFoundException("File not found: " + path.toAbsolutePath());
        }

        Gson gson = new Gson();
        try (Reader reader = Files.newBufferedReader(path)) {
            Student[] students = gson.fromJson(reader, Student[].class);
            return Arrays.asList(students);
        }
    }
}
