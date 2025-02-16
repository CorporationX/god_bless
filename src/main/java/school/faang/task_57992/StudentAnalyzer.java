package school.faang.task_57992;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StudentAnalyzer {
    public Map<String, Double> calculateAverageGradePerSubject(List<Student> students) {
        return students.stream()
                .flatMap(student -> student.getCourses().entrySet().stream()) // Преобразуем в Stream<Map.Entry<String, List<Integer>>>
                .collect(Collectors.groupingBy( // Группируем по предметам
                        Map.Entry::getKey, // Название предмета
                        Collectors.flatMapping(entry -> entry.getValue().stream(), // Разворачиваем список оценок
                                Collectors.averagingDouble(Integer::doubleValue)) // Среднее значение по предмету
                ));
    }
}
