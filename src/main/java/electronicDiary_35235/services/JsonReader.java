package electronicDiary_35235.services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import electronicDiary_35235.entity.Student;
import lombok.NonNull;

import java.io.*;

import java.util.List;

public class JsonReader {
    public List<Student> readJsonFromFile(@NonNull String fileName) {
        ObjectMapper objectMapper = new ObjectMapper();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)))) {
            return objectMapper.readValue(br, new TypeReference<>() {
            });
        } catch (IOException e) {
            e.printStackTrace();
            throw new IllegalArgumentException("File not found");
        }


    }
}
