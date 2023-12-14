package faang.school.godbless.stream_api.electronic_diary;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        Student student1 = new Student("Salikhov", "Nariman", Map.of("Math", List.of(2, 3, 4), "History", List.of(2, 3, 4)));
        Student student2 = new Student("Nurdilda", "Asset", Map.of("Math", List.of(4, 5, 5), "History", List.of(2, 4, 4)));
        Student student3 = new Student("Mirmanov", "Ernar", Map.of("Math", List.of(3, 5, 4), "History", List.of(5, 2, 2)));


        List<Student> students = List.of(student1, student2, student3);

        System.out.println(getAverage(students));

        System.out.println(calculateTotalMark(students));

        System.out.println(getDifficultCourse(students));


    }


    static Map<String, Double> getAverage(List<Student> students) {
        return students.stream()
                .flatMap(student -> student.getCourses().entrySet().stream())
                .collect(Collectors.groupingBy(entry -> entry.getKey(),
                        Collectors.averagingDouble(entry -> entry.getValue().stream().mapToInt(Integer::intValue).average().orElse(0))));
    }

    static Map<Student, Map<String, Long>> calculateTotalMark(List<Student> students) {
        return students.stream().collect(Collectors.toMap(student -> student, student -> student.getCourses().entrySet().stream()
                .map(entry -> new AbstractMap.SimpleEntry<>(entry.getKey(), Math.round(entry.getValue().stream().mapToInt(Integer::intValue).average().orElse(0.0))))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue))));
    }

    static String getDifficultCourse(List<Student> students) {
        return students.stream()
                .flatMap(student -> student.getCourses().entrySet().stream())
                .collect(Collectors.groupingBy(entry -> entry.getKey(),
                        Collectors.averagingDouble(entry -> entry.getValue().stream().mapToInt(Integer::intValue).average().orElse(0))))
                .entrySet().stream().min(Comparator.comparingDouble(Map.Entry::getValue)).get().getKey();
    }


}


@Data
@AllArgsConstructor
class Student {
    private String firstName;
    private String lastName;
    private Map<String, List<Integer>> courses;


    @Override
    public String toString() {
        return "Student{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}