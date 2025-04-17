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
                        )));
        System.out.println(DiaryOperations.getSubjectAvgGrades(students));
        System.out.println(DiaryOperations.getAvgGradesForStudent(students, "Иван", "Иванов"));
        System.out.println(DiaryOperations.getTheLowestGradeSubject(students));
        System.out.println(DiaryOperations.getStudentsGradingTable(students));
    }
}
