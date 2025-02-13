package school.faang.electronicdiary;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@Slf4j
public class Main {
    private static final double TRANSFORMER_VALUE = 100.0;
    private static final StudentDatabase STUDENT_DATABASE = new StudentDatabase();

    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper();
        try (InputStream inputStream = Main.class.getClassLoader().getResourceAsStream("students_data.json")) {
            if (inputStream == null) {
                throw new FileNotFoundException("File not found!");
            }

            List<Student> students = mapper.readValue(inputStream, new TypeReference<>() {
            });

            log.info("\n{}", printPrettyDouble(STUDENT_DATABASE.findAverageGradesOnSubjects(students)));
            log.info("\n{}", printPrettyInteger(STUDENT_DATABASE.findAverageGradesStudent(
                    students, "Олег", "Сидоров")));
            log.info("{}\n", STUDENT_DATABASE.findMostHardestSubject(students));

            printStudents(students);
        } catch (Exception exception) {
            log.error(exception.getMessage(), exception);
        }
    }

    private static void printStudents(List<Student> students) {
        students.forEach(student -> {
            log.info("|| {} {} ||", student.getFirstName(), student.getLastName());
            student.getSubjects().forEach((subject, grades) ->
                    log.info("     {} - {}", subject, Math.round(grades.stream().map(Integer::doubleValue)
                            .reduce(0.0, Double::sum) / grades.size())));
        });
    }

    private static String printPrettyDouble(Map<String, Double> map) {
        validateMap(map);
        return map.entrySet().stream()
                .map(entry -> entry.getKey() + ": " +
                        transformDouble(entry.getValue())).collect(Collectors.joining("\n"));
    }

    private static String printPrettyInteger(Map<String, Integer> map) {
        validateMap(map);
        return map.entrySet().stream()
                .map(entry -> entry.getKey() + ": " +
                        entry.getValue()).collect(Collectors.joining("\n"));
    }

    private static void validateMap(Map<String, ?> map) {
        Objects.requireNonNull(map);
    }

    private static double transformDouble(double value) {
        return Math.round(value * TRANSFORMER_VALUE) / TRANSFORMER_VALUE;
    }
}
