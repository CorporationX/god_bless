package school.faang.diary;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import school.faang.diary.exception.CourseNotFoundException;
import school.faang.diary.exception.StudentNotFoundException;

import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author Danil Pudovkin
 * @since 20.06.2025
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Operations {

    public static Map<String, Double> getAverageScoreForSchool(@NonNull Set<Student> students) {
        return students.stream()
                .flatMap(student -> student.getSubjects().entrySet().stream())
                .flatMap(entry -> entry.getValue().stream()
                        .map(score -> Map.entry(entry.getKey(), score)))
                .collect(Collectors.groupingBy(
                        Map.Entry::getKey,
                        Collectors.averagingInt(Map.Entry::getValue)
                ));
    }

    public static Map<String, Integer> getFinalScoresForStudent(@NonNull Set<Student> students,
                                                                @NonNull String firstName, @NonNull String lastName) {
        var studentOptional = students.stream()
                .filter(s -> s.getFirstName().equals(firstName) && s.getLastName().equals(lastName))
                .findFirst();
        if (studentOptional.isEmpty()) {
            throw new StudentNotFoundException();
        }
        return studentOptional.get().getSubjects().entrySet().stream()
                .flatMap(entry -> entry.getValue().stream()
                        .map(score -> Map.entry(entry.getKey(), score)))
                .collect(Collectors.groupingBy(
                        Map.Entry::getKey,
                        Collectors.collectingAndThen(
                                Collectors.averagingInt(Map.Entry::getValue),
                                score -> (int) Math.round(score)
                        )
                ));
    }

    public static String getMostHardCourse(@NonNull Set<Student> students) {
        return students.stream()
                .flatMap(student -> student.getSubjects().entrySet().stream())
                .flatMap(entry -> entry.getValue().stream()
                        .map(score -> Map.entry(entry.getKey(), score)))
                .collect(Collectors.groupingBy(
                        Map.Entry::getKey,
                        Collectors.averagingInt(Map.Entry::getValue)
                ))
                .entrySet().stream()
                .min(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElseThrow(CourseNotFoundException::new);
    }

    public static void printStudentsScores(@NonNull Set<Student> students) {
        var sb = new StringBuilder();
        Function<Student, Integer> getFioLength =
                s -> s.getFirstName().length() + 1 + s.getLastName().length();
        var maxFioLength = students.stream()
                .map(getFioLength)
                .max(Integer::compareTo)
                .orElseThrow();
        var subjects = students.stream()
                .flatMap(student -> student.getSubjects().keySet().stream())
                .sorted(String::compareTo)
                .collect(Collectors.toCollection(LinkedHashSet::new));
        // Добавляем строку с названиями столбцов
        var fioField = "ФИО";
        sb.append(fioField).append(" ".repeat(maxFioLength - fioField.length())).append(" |");
        subjects.forEach(course -> sb.append(" ").append(course).append(" |"));
        var percentField = "   %   ";
        sb.append(percentField).append("|");
        var finalScoreField = " Итоговая оценка";
        sb.append(finalScoreField).append("\n");
        // Добавляем оценки для каждого студента
        students.forEach(student -> {
            // Добавляем ФИО
            var spacesAtTheEndOfFio = maxFioLength - getFioLength.apply(student);
            sb.append(student.getFirstName()).append(" ").append(student.getLastName());
            sb.append(" ".repeat(spacesAtTheEndOfFio)).append(" |");
            // Добавляем оценки по каждому предмету
            double[] totalSubjectsScore = new double[2];
            var studentSubjects = student.getSubjects();
            subjects.forEach(subject -> {
                var subjectScores = studentSubjects.get(subject);
                if (subjectScores == null) {
                    sb.append(" ".repeat(subject.length() + 1)).append(" |");
                } else {
                    var subjectAverageScore = subjectScores.stream()
                            .mapToInt(Integer::intValue)
                            .average()
                            .orElseThrow();
                    totalSubjectsScore[0] += subjectAverageScore;
                    totalSubjectsScore[1]++;
                    sb.append(" ".repeat(subject.length() - 2))
                            .append(Math.round(subjectAverageScore * 10.0) / 10.0).append(" |");
                }
            });
            // Добавляем успеваемость в процентах
            var grade = totalSubjectsScore[0] / totalSubjectsScore[1];
            var percentGrade = grade / 5 * 100;
            sb.append(" ".repeat(2)).append(Math.round(percentGrade * 10.0) / 10.0).append(" |");
            // Добавляем итоговую оценку
            sb.append(" ".repeat(finalScoreField.length() - 6)).append(Math.round(grade) * 1.0);
            sb.append("\n");
        });
        System.out.println(sb);
    }
}
