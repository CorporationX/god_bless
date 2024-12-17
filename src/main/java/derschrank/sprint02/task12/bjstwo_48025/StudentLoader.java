package derschrank.sprint02.task12.bjstwo_48025;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.nio.file.*;
import java.util.*;

public class StudentLoader {

    public List<Student> loadStudents() throws IOException {
        final String PATH_TO_JSON = "src\\main\\java\\derschrank\\sprint02\\task12\\bjstwo_48025\\students_test_data.json";
        return loadStudents(PATH_TO_JSON);
    }

    public List<Student> loadStudents(String filePath) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(
                new File(filePath),
                new TypeReference<List<Student>>() {
                });
    }
}

