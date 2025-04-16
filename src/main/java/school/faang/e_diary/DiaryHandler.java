package school.faang.e_diary;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DiaryHandler {
    public static Map<String, Double> getSubjectAvgGrades(List<Student> students) {
        return students.stream()
                .map(Student::getMarks)
                .flatMap(m -> m.entrySet().stream())
                .filter(m -> !m.getValue().isEmpty())
                .map(entry ->
                        Map.of(entry.getKey(), entry.getValue().stream().mapToInt(num -> num).average().getAsDouble()))
                .flatMap(m -> m.entrySet().stream())
                .collect(Collectors.groupingBy(Map.Entry::getKey, Collectors.averagingDouble(Map.Entry::getValue)));
    }

    public static Map<String, Long> getAvgGradesForStudent(List<Student> students, String name, String lastName) {
        return students.stream()
                .filter(student -> student.getName().equals(name) && student.getLastName().equals(lastName))
                .map(Student::getMarks)
                .flatMap(m -> m.entrySet().stream())
                .filter(m -> !m.getValue().isEmpty())
                .map(entry -> {
                    double avgMark = entry.getValue().stream().mapToInt(num -> num).average().getAsDouble();
                    return Map.of(entry.getKey(), Math.round(avgMark));
                })
                .flatMap(m -> m.entrySet().stream())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    /*
    4️⃣ Реализуйте метод, который принимает список учеников и возвращает название самого сложного предмета — того,
    по которому средняя успеваемость всех учеников ниже всего. Метод возвращает строку с названием предмета.
Пример: если средняя оценка по математике — 4.0, а по химии — 3.5, то химия будет считаться самым сложным предметом.
     */

}
