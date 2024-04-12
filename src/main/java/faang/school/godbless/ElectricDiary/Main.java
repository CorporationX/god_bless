package faang.school.godbless.ElectricDiary;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static faang.school.godbless.ElectricDiary.Course.*;

public class Main {
    public static void main(String[] args) {
        StudentService service = new StudentService();

        List<Student> students = getStudents();

        Map<Course, Double> out1 = service.getAverageMarksForEachCourse(students);
        System.out.println("getAverageMarksForEachCourse: ");
        out1.forEach((key, val) -> System.out.printf("%s  %f\n", key, val));

        Map<Course, Integer> out2 = service.getFinalMarksForEachCourseForStudent(students, "Alice", "Smith");
        System.out.println("\ngetFinalMarksForEachCourseForStudent: ");
        out2.forEach((key, val) ->  System.out.printf("%s  %d\n", key, val));

        Course out3 = service.getHardestCourse(students);
        System.out.println("\ngetHardestCourse: " + out3);

        String out4 = service.getStudentsTable(students);
        System.out.println(out4);
    }

    private static List<Student> getStudents() {
        Student student1 = new Student("Alice", "Smith", Map.of(
                MATH, Arrays.asList(5, 2),
                ENGLISH, Arrays.asList(3, 4),
                SCIENCE, Arrays.asList(4, 5),
                HISTORY, Arrays.asList(5, 2),
                ART, Arrays.asList(3, 3)
        ));
        Student student2 = new Student("Bob", "Johnson", Map.of(
                MATH, Arrays.asList(2, 3),
                ENGLISH, Arrays.asList(4, 5),
                SCIENCE, Arrays.asList(3, 4),
                HISTORY, Arrays.asList(5, 2),
                ART, Arrays.asList(4, 4)
        ));
        Student student3 = new Student("Paul", "Walker", Map.of(
                MATH, Arrays.asList(3, 4),
                ENGLISH, Arrays.asList(5, 2),
                SCIENCE, Arrays.asList(4, 5),
                HISTORY, Arrays.asList(2, 3),
                ART, Arrays.asList(5, 5)
        ));
        Student student4 = new Student("David", "Brown", Map.of(
                MATH, Arrays.asList(4, 5),
                ENGLISH, Arrays.asList(2, 3),
                SCIENCE, Arrays.asList(5, 2),
                HISTORY, Arrays.asList(3, 4),
                ART, Arrays.asList(2, 2)
        ));
        Student student5 = new Student("Emma", "Jones", Map.of(
                MATH, Arrays.asList(3, 3),
                ENGLISH, Arrays.asList(4, 4),
                SCIENCE, Arrays.asList(2, 2),
                HISTORY, Arrays.asList(3, 3),
                ART, Arrays.asList(4, 4)
        ));

        return List.of(student1, student2, student3, student4, student5);
    }
}
