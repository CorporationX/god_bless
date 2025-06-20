package school.faang.diary;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Set;

/**
 * @author Danil Pudovkin
 * @since 20.06.2025
 */
public class Main {

    public static void main(String[] args) {
        var objectMapper = new ObjectMapper();
        Set<Student> students;
        try {
            students = objectMapper.readValue(
                    Paths.get("src/main/resources/students_test_data.json").toFile(),
                    new TypeReference<>() {
                    }
            );
        } catch (IOException e) {
            throw new IllegalStateException("Can't process resource", e);
        }

        var averageScoreForSchool = Operations.getAverageScoreForSchool(students);
        System.out.println(averageScoreForSchool);

        var finalScoreForStudent = Operations.getFinalScoreForStudent(students, "Олег", "Сидоров");
        System.out.println(finalScoreForStudent);

        var mostHardCourse = Operations.getMostHardCourse(students);
        System.out.println(mostHardCourse);
    }
}
