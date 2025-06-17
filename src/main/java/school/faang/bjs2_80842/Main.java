package school.faang.bjs2_80842;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@Slf4j
public class Main {
    private static final String SOURCE_PATH = "src/main/resources";
    private static final String FILE_PATH = "/bjs2_80842/students_test_data.json";
    private static StudentManager studentManager = new StudentManager();
    private static final String FIRST_NAME = "Алексей";
    private static final String LAST_NAME = "Волков";

    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            List<Student> students = mapper.readValue(new File(SOURCE_PATH + FILE_PATH),
                                                      new TypeReference<>() {});
            System.out.println(students);

            Map<String, Double> avgGradeSubjects = studentManager.avgGradeBySubjects(students);
            for (var entry : avgGradeSubjects.entrySet()) {
                log.info("{} : {}", entry.getKey(), String.format("%.2f", entry.getValue()));
            }

            Map<String, Integer> finalGrades = studentManager.finalGradesForStudent(students, FIRST_NAME, LAST_NAME);
            for (var entry : finalGrades.entrySet()) {
                log.info("{} : {}", entry.getKey(), entry.getValue());
            }

            String difficultSubject = studentManager.findDifficultSubject(students);
            log.info("Самый сложный предмет: {}", difficultSubject);

        } catch (FileNotFoundException e) {
            log.error("Файл не найден: ", e);
        } catch (IOException e) {
            log.error("Ошибка ввода-вывода: ", e);
        }

    }
}
