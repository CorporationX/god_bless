package school.faang.streams.electronicDiary;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StudentService {
    public static void main(String[] args) {
        Student student = new Student("a", "b", Map.of("Math", List.of(5, 4, 3), "rus", List.of(2, 3)));
        Student student2 = new Student("a", "b", Map.of("Math", List.of(2, 2, 2)));

        List<Student> students = List.of(student, student2);
        System.out.println(averageGradeForEachSubject(List.of(student, student2)));
        System.out.println(finalAssessmentOfTheStudentInTheSubject(students, "a", "b"));
        System.out.println(findTheMostDifficultSubject(students));
    }


    public static Map<String, Double> averageGradeForEachSubject(List<Student> studentList) {
        List<String> subjects = new ArrayList<>();
        Map<String, Double> avgForSubject = new HashMap<>();

        studentList.forEach(student -> student.getCourses().forEach((key, value) -> subjects.add(key)));
        subjects.forEach(subject -> {
            double avg = studentList.stream()
                    .filter(student -> student.getCourses().containsKey(subject))
                    .flatMap(student -> student.getCourses().get(subject).stream())
                    .collect(Collectors.averagingInt(Integer::intValue));
            avgForSubject.put(subject, avg);
        });
        return avgForSubject;
    }

    public static Map<String, Integer> finalAssessmentOfTheStudentInTheSubject(List<Student> studentList, String firstName, String lastName) {
        return studentList.stream()
                .filter(student -> student.getFirstName().equals(firstName) && student.getLastName().equals(lastName))
                .findFirst()
                .map(student -> student.getCourses().entrySet().stream()
                        .collect(Collectors.toMap(
                                Map.Entry::getKey,
                                entry -> (int) Math.round(entry.getValue().stream().mapToInt(Integer::intValue).average().orElse(0)))
                        )).orElse(Collections.emptyMap());
    }

    public static String findTheMostDifficultSubject(List<Student> studentList) {
        Map<String, Double> averageGradeForEachSubject = averageGradeForEachSubject(studentList);
        return averageGradeForEachSubject.entrySet().stream()
                .min(Comparator.comparingDouble(Map.Entry::getValue))
                .map(Map.Entry::getKey)
                .orElse("Недостаточно данных");
    }

    public static void printAssessmentOfStudents(List<Student> studentList) {
        studentList.stream().forEach(student -> {

        });
    }








}
