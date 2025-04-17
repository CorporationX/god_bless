package school.faang.e_diary;

import lombok.experimental.UtilityClass;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@UtilityClass
public class DiaryOperations {
    public Map<String, Double> getSubjectAvgGrades(List<Student> students) {
        return students.stream()
                .map(Student::getMarks)
                .flatMap(m -> m.entrySet().stream())
                .filter(entry -> !entry.getValue().isEmpty())
                .map(entry ->
                        Map.of(entry.getKey(),
                                entry.getValue().stream()
                                        .mapToInt(num -> num)
                                        .average()
                                        .getAsDouble()))
                .flatMap(m -> m.entrySet().stream())
                .collect(Collectors.groupingBy(Map.Entry::getKey, Collectors.averagingDouble(Map.Entry::getValue)));
    }

    public Map<String, Long> getAvgGradesForStudent(List<Student> students, String name, String lastName) {
        return students.stream()
                .filter(student -> student.getName().equals(name) && student.getLastName().equals(lastName))
                .map(Student::getMarks)
                .flatMap(m -> m.entrySet().stream())
                .filter(entry -> !entry.getValue().isEmpty())
                .map(entry -> {
                    double avgMark = entry.getValue().stream()
                            .mapToInt(num -> num)
                            .average()
                            .getAsDouble();
                    return Map.of(entry.getKey(), Math.round(avgMark));
                })
                .flatMap(m -> m.entrySet().stream())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    public String getTheLowestGradeSubject(List<Student> students) {
        return students.stream()
                .map(Student::getMarks)
                .flatMap(m -> m.entrySet().stream())
                .filter(entry -> !entry.getValue().isEmpty())
                .map(entry ->
                        Map.of(entry.getKey(),
                                entry.getValue().stream()
                                        .mapToInt(num -> num)
                                        .average()
                                        .getAsDouble()))
                .flatMap(m -> m.entrySet().stream())
                .collect(Collectors.groupingBy(Map.Entry::getKey, Collectors.averagingDouble(Map.Entry::getValue)))
                .entrySet().stream()
                .min(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .get();
    }

    /*
    Дополнительная задача:
Напишите метод, который выводит в консоль таблицу с итоговой успеваемостью всех учеников. В таблице должны быть такие колонки:
ФИО (имя и фамилия ученика),
Итоговые оценки по каждому предмету,
Процент успеваемости по всем предметам,
Итоговая оценка по 5-балльной шкале.

ищем средний бал без округления для каждого ученика за предмет
Map<Student, Map<String, Double>>
     */

    public String getStudentsGradingTable(List<Student> students) {
        Map<Student, Map<String, Double>> studentsToAvgMarks = students.stream()
                .map(student -> {
                    Map<String, Double> subjectToAvgMark = student.getMarks()
                            .entrySet().stream()
                            .filter(entry -> !entry.getValue().isEmpty())
                            .map(entry -> Map.of(entry.getKey(), entry.getValue().stream().mapToInt(num -> num).average().getAsDouble()))
                            .flatMap(m -> m.entrySet().stream())
                            .collect(Collectors.groupingBy(Map.Entry::getKey, Collectors.averagingDouble(Map.Entry::getValue)));
                    return Map.of(student, subjectToAvgMark);
                })
                .flatMap(m -> m.entrySet().stream())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        Map<Student, Map<String, Double>> studentToSubjectPerformance = studentsToAvgMarks.entrySet().stream()
                .filter(entry -> !entry.getValue().isEmpty())
                .map(entry -> {
                    Map<String, Double> mapOfSubjectPerformance = entry.getValue().entrySet().stream()
                            .map(subjToAvgMark -> Map.of(subjToAvgMark.getKey(), 100 * (subjToAvgMark.getValue() / 5)))
                            .flatMap(modifiedEntry -> modifiedEntry.entrySet().stream())
                            .collect(Collectors.groupingBy(Map.Entry::getKey, Collectors.averagingDouble(Map.Entry::getValue)));
                    return Map.of(entry.getKey(), mapOfSubjectPerformance);
                })
                .flatMap(m -> m.entrySet().stream())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        Map<Student, Long> studentToAverageForAllMarks = studentsToAvgMarks.entrySet().stream()
                .filter(entry -> !entry.getValue().isEmpty())
                .map(entry -> {
                    double averageForAllMarks = entry.getValue().entrySet().stream()
                            .map(subjectToAvgMark -> subjectToAvgMark.getValue())
                            .mapToDouble(mark -> mark)
                            .average()
                            .getAsDouble();
                    return Map.of(entry.getKey(), Math.round(averageForAllMarks));
                })
                .flatMap(m -> m.entrySet().stream())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        System.out.println("studentsToAvgMarks = " + studentsToAvgMarks);
        //System.out.println("studentToSubjectPerformance = " + studentToSubjectPerformance);
        //System.out.println("studentToAverageForAllMarks = " + studentToAverageForAllMarks);

        StringBuilder sb = new StringBuilder();
        String format = "%-15s | %11s | %11s | %5s | %6s | %16s%n";
        sb.append(String.format(format, "ФИО", "Математика", "Литература", "Химия", "%", "Итоговая оценка"));

        return sb.toString();
    }
}
