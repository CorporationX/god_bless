package bjs2_35333;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class StudentSupplier {
    public static List<Student> getStudents() {
        ObjectMapper mapper = new ObjectMapper();
        File json = new File("src/main/java/bjs2_35333/data.json");
        try {
            Student[] students = mapper.readValue(json, Student[].class);
            return Arrays.asList(students);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return Collections.emptyList();
    }
}

