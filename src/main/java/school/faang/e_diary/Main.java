package school.faang.e_diary;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>(
                List.of(new Student("Иван", "Иванов", Map.of(
                                "Математика", List.of(5, 4, 3, 4),
                                "Химия", List.of(4, 5, 4),
                                "Литература", List.of(3, 3, 4)
                        )),
                        new Student("Илья", "Шатков", Map.of(
                                "Математика", List.of(5, 5, 5, 5),
                                "Химия", List.of(5, 5, 5),
                                "Литература", List.of(5, 5, 5))
                        ),
                        new Student("Вадим", "Петров", Map.of(
                                "Математика", List.of(5, 3, 2, 1),
                                "Химия", List.of(4, 2, 1),
                                "Литература", List.of(2, 3, 2))
                        )));
        System.out.println(String.format("getSubjectAvgGrades: %s", DiaryOperations.getSubjectAvgGrades(students)));
        System.out.println(String.format("getAvgGradesForStudent: %s",
                DiaryOperations.getAvgGradesForStudent(students, "Иван", "Иванов")));
        System.out.println(String.format("getTheLowestGradeSubject: %s", DiaryOperations.getTheLowestGradeSubject(students)));
        System.out.println(String.format("getStudentsGradingTable: %n%s", DiaryOperations.getStudentsGradingTable(students)));
    }
}
