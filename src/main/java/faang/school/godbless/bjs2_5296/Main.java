package faang.school.godbless.bjs2_5296;

import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        Student grisha = new Student("Grisha", "Pahomov");
        Map<String, List<Integer>> courses = Map.of("Math", List.of(5, 4, 4, 3, 3, 5),
                "Literature", List.of(5, 4, 5, 4, 4, 5),
                "Chemistry", List.of(3, 2, 4, 5, 5));
        grisha.setCourses(courses);

        Student vanya = new Student("Vanya", "Alekseev");
        Map<String, List<Integer>> coursesVanya = Map.of("Math", List.of(4, 4, 4, 3, 3, 5),
                "Literature", List.of(3, 4, 5, 4, 4, 3),
                "Chemistry", List.of(5, 4, 4, 5, 5));
        vanya.setCourses(coursesVanya);

        List<Student> students = List.of(grisha, vanya);

        StudentService studentService = new StudentService();
        Map<String, Double> avgScoresubjMap = studentService.findAverageScoreBySubject(students);

        for (Map.Entry<String, Double> entry : avgScoresubjMap.entrySet()) {
            System.out.printf("%-15s %.2f %n", entry.getKey(), entry.getValue());
        }

        System.out.println("\nTotal score per subject for student Grisha");
        Map<String, Integer> scoreTotalMap = studentService.calcTotalScorePerSubjForStudent(students, grisha.getFirstName(), grisha.getLastName());
        scoreTotalMap.forEach((key, value) -> System.out.println(key + " : " + value));

        System.out.println("\nFind the most difficult subject");
        System.out.println(studentService.findTheMostDifficultSubject(students));

        System.out.println("\nPrint students with scores");
        String report = students.stream()
                .collect(studentService.getCustomCollector());
        System.out.println(report);
    }
}
