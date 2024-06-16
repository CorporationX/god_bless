package faang.school.godbless.electronic_diary;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Diary diary = new Diary();
        Map<String, List<Integer>> student1Courses = Map.of(
                "Math", List.of(5, 5, 5, 5, 5, 5, 5, 5, 1, 2),
                "Literature", List.of(4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5),
                "Chemistry", List.of(4, 4, 4, 4, 4, 4, 4, 4, 4, 2));
        Map<String, List<Integer>> student2Courses = Map.of(
                "Math", List.of(5, 5, 5, 5, 5, 5, 5, 5, 2, 2),
                "Literature", List.of(5, 5, 5, 5, 5, 5, 5, 5, 5, 4),
                "Chemistry", List.of(5, 5, 5, 5, 5, 4, 4, 4, 4, 4));
        List<String> courseList = List.of("Math", "Literature", "Chemistry");
        Student student1 = new Student("Vanya", "Alexeev", student1Courses);
        Student student2 = new Student("Dasha", "Ivanova", student2Courses);
        List<Student> studentList = List.of(student1, student2);

        diary.gradeCourseGradesTable(studentList, courseList);
        System.out.println(diary.getStudentFinalGrades(student1));
        System.out.println(diary.getStudentFinalGrades(student2));

        System.out.println(diary.getHardestCourse(studentList));
    }
}
