package derschrank.sprint02.task12.bjstwo_48025;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.nio.file.*;
import java.util.*;

public class StudentLoader {

    public List<Student> loadStudents() throws IOException {
        // Требование checkstyle: Аббревиатура в имени 'PATH_TO_JSON' должна содержать
        // не более '1' последовательных заглавных букв. [AbbreviationAsWordInName]
        final String pathToJson =
                "src\\main\\java\\derschrank\\sprint02\\task12\\bjstwo_48025\\students_test_data.json";
        return loadStudents(pathToJson);
    }

    public List<Student> loadStudents(String filePath) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(
                new File(filePath),
                new TypeReference<List<Student>>() {
                });
    }
}

