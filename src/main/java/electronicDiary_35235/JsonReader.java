package electronicDiary_35235;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.NonNull;

import java.io.*;

import java.nio.charset.StandardCharsets;
import java.util.List;

public class JsonReader {
    public List<Student> readJson(@NonNull String fileName) {
        ObjectMapper objectMapper = new ObjectMapper();
        try(BufferedReader br= new BufferedReader (new InputStreamReader( new FileInputStream(fileName), StandardCharsets.UTF_8))) {
            return objectMapper.readValue(br, new TypeReference<>() {
            });
        } catch (IOException e) {
            e.printStackTrace();
            throw new IllegalArgumentException("File not found");
        }


    }
}
