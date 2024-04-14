package faang.school.godbless.electronic_diary;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        StudentPerformanceService studentPerformanceService = new StudentPerformanceService();
        System.out.println(studentPerformanceService.avgMarkForEachSubject(getStudents()));
        System.out.println(studentPerformanceService.findFinalMarksByStudent(getStudents(), "test5", "test5"));
        System.out.println(studentPerformanceService.getHardestSubject(getStudents()));
        studentPerformanceService.printInfoAboutEachStudent(getStudents());
    }

    public static List<Student> getStudents() {
        return List.of(
                new Student("test1", "test1", Map.of(
                        CourseType.MATH, List.of(4, 5),
                        CourseType.LANGUAGE, List.of(5, 5)
                )),
                new Student("test2", "test2", Map.of(
                        CourseType.MATH, List.of(4, 5, 3, 2),
                        CourseType.PE, List.of(5, 5, 4, 5, 5)
                )),
                new Student("test3", "test3", Map.of(
                        CourseType.MATH, List.of(4, 5),
                        CourseType.LANGUAGE, List.of(5, 5),
                        CourseType.PE, List.of(5, 5)
                )),
                new Student("test4", "test4", Map.of(
                        CourseType.LANGUAGE, List.of(3, 4, 5)
                )),
                new Student("test5", "test5", Map.of(
                        CourseType.MATH, List.of(4, 5),
                        CourseType.LANGUAGE, List.of(5, 5),
                        CourseType.MUSIC, List.of(3, 3, 3)
                )),
                new Student("test6", "test6", Map.of(
                        CourseType.MATH, List.of(4, 5),
                        CourseType.PE, List.of(5, 4, 5, 4, 5)
                )),
                new Student("test7", "test7", Map.of(
                        CourseType.MATH, List.of(4, 5),
                        CourseType.LANGUAGE, List.of(5, 5)
                ))
        );
    }
}