package school.faang.Diary;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StudentService {

    public static Map<String, Double> getAverageGradesBySubject(List<Student> students) {
        return students.stream().flatMap(student -> student.getSubjects().entrySet().stream())
                .collect(Collectors.groupingBy(Map.Entry::getKey, Collectors.
                        flatMapping(e -> e.getValue().stream(), Collectors.averagingDouble(Double::valueOf))));
    }

    public static Map<String, Integer> getFinalGrades(List<Student> students, String fullName) {
        return students.stream().filter(student -> student.getFullName().equals(fullName)).findFirst()
                .map(student -> student.getSubjects().entrySet().stream().collect(
                        Collectors.toMap(Map.Entry::getKey, entry -> (int) Math.round(entry.getValue().stream()
                                                .mapToInt(Integer::intValue)
                                                .average()
                                                .orElse(0.0)))))
                .orElse(new HashMap<>());
    }

    public static String getMostDifficultSubject(List<Student> students) {
        return getAverageGradesBySubject(students).entrySet().stream().min(Map.Entry.comparingByValue()).map(Map.Entry::getKey).orElse("");
    }

    public static List<Student> loadStudentsFromJson(String filePath) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(Paths.get(filePath).toFile(), new TypeReference<>() {
        });
    }

}
