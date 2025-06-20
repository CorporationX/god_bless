package school.faang.diary;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.Map;
import java.util.Set;
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

    public static Map<String, Integer> getFinalScoreForStudent(@NonNull Set<Student> students,
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
                .orElseThrow(StudentNotFoundException::new);
    }
}
