package school.faang.task225.student;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class StudentLoader {

    public static List<Student> loadStudents(String filePath) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            File file = new File(filePath);
            List<Student> students = objectMapper.readValue(file, new TypeReference<>() {
            });
            return students;
        } catch (IOException e) {
            System.out.println("Файл не наиден ");
            e.printStackTrace();
            throw new IOException();
        }
    }
}
