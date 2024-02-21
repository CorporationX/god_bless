package faang.school.godbless;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StudentService {
    public Map<String, Double> calculateAvg (List<Student> students) {
        return students.stream()
                .flatMap(student -> student.getCourses().entrySet().stream())
                .collect(Collectors.toMap(Map.Entry::getKey, entry -> entry.getValue()
                                .stream()
                                .mapToInt(Integer::intValue)
                                .average()
                                .orElse(0.0))
                );
    }
}
