package faang.school.godbless;

import java.util.*;
import java.util.stream.Collectors;

public class ElectronicDiaryService {
    public Map<String,Double> getAverageGradesPerSubject(List<Student> students){
        return students.stream()
                .flatMap(student -> student.getCourses().entrySet().stream())
                .collect(Collectors.groupingBy(
                        Map.Entry::getKey,
                        Collectors.averagingDouble(entry -> entry.getValue().stream()
                                .mapToInt(Integer::intValue)
                                .average()
                                .orElse(0.0)
                        )
                ));
    }

    public Map<String, Integer> getFinalGradesForStudent(List<Student> students, String firstName, String lastName) {
        return students.stream()
                .filter(student -> student.getFirstName().equals(firstName) && student.getLastName().equals(lastName))
                .findFirst()
                .map(student -> student.getCourses().entrySet().stream()
                        .collect(Collectors.toMap(
                                Map.Entry::getKey,
                                entry -> (int) Math.round(entry.getValue().stream()
                                        .mapToInt(Integer::intValue)
                                        .average()
                                        .orElse(0.0))
                        ))
                )
                .orElse(Collections.emptyMap());
    }

    public String findHardestSubject(List<Student> students) {
        return getAverageGradesPerSubject(students).entrySet().stream()
                .min(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse("No subjects found");
    }


}
