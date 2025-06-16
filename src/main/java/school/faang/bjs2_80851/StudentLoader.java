package school.faang.bjs2_80851;

import com.google.gson.Gson;

import java.io.*;
import java.util.Arrays;
import java.util.List;

public class StudentLoader {

    public static List<Student> loadStudentsFromResources(String resourceName) throws IOException {
        InputStream resourceStream = StudentLoader.class.getClassLoader().getResourceAsStream(resourceName);
        if (resourceStream == null) {
            throw new FileNotFoundException("Resource not found: " + resourceName);
        }

        try (Reader reader = new InputStreamReader(resourceStream)) {
            Gson gson = new Gson();
            Student[] students = gson.fromJson(reader, Student[].class);
            return Arrays.asList(students);
        }
    }
}
