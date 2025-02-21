package school.faang.BJS2_58002;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        Map<String, List<Integer>> subjectAndGrades1 = Map.of(
                "Литература", List.of(5, 2, 5, 3, 4, 3),
                "Физика", List.of(4, 5, 2, 3, 2, 3, 5, 3, 5, 5)
        );
        Student student1 = new Student("Олег", "Сидоров", subjectAndGrades1);
        Map<String, List<Integer>> subjectAndGrades2 = Map.of(
                "Физика", List.of(4, 2, 3, 3, 2, 3),
                "Французский", List.of(4, 3, 3, 4, 5, 3, 5, 3, 5)
        );
        Student student2 = new Student("Андрей", "Тихонов", subjectAndGrades2);
        List<Student> students = List.of(student1, student2);

        System.out.printf("Средняя оценка по школе за каждый предмет:\n%s\n",
                StudentGradeService.getAverageGradesBySubject(students));

        System.out.printf("Итоговая оценка по каждому предмету для %s %s:\n%s\n",
                "Олег", "Сидоров", StudentGradeService.getFinalGradesBySubject(students, "Олег", "Сидоров"));

        System.out.printf("Название самого сложного предмета:\n%s",
                StudentGradeService.getMostDifficultSubject(students));
    }
}
