package school.faang.task_47252;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<Student> students = List.of(
                new Student("Alice", "Johnson", Map.of(
                        "Math", List.of(5, 4, 4),
                        "Russian", List.of(3, 5, 4),
                        "Informatics", List.of(5, 5, 4),
                        "History", List.of(4, 3),
                        "PE", List.of(5, 5),
                        "Chemistry", List.of(4, 4),
                        "Physics", List.of(5, 4)
                )),
                new Student("Bob", "Smith", Map.of(
                        "Math", List.of(3, 4, 4),
                        "Russian", List.of(4, 3, 4),
                        "Informatics", List.of(5, 4, 3),
                        "History", List.of(3, 3),
                        "PE", List.of(4, 4),
                        "Chemistry", List.of(3, 4),
                        "Physics", List.of(4, 4)
                )),
                new Student("Charlie", "Brown", Map.of(
                        "Math", List.of(5, 5, 4),
                        "Russian", List.of(4, 4, 3),
                        "Informatics", List.of(4, 3, 4),
                        "History", List.of(5, 4),
                        "PE", List.of(5, 5),
                        "Chemistry", List.of(4, 5),
                        "Physics", List.of(5, 5)
                )),
                new Student("Diana", "Evans", Map.of(
                        "Math", List.of(4, 4, 3),
                        "Russian", List.of(5, 4, 4),
                        "Informatics", List.of(4, 4, 4),
                        "History", List.of(4, 3),
                        "PE", List.of(5, 4),
                        "Chemistry", List.of(3, 4),
                        "Physics", List.of(4, 4)
                )),
                new Student("Ethan", "Green", Map.of(
                        "Math", List.of(3, 3, 3),
                        "Russian", List.of(3, 3, 4),
                        "Informatics", List.of(4, 3, 4),
                        "History", List.of(3, 4),
                        "PE", List.of(4, 3),
                        "Chemistry", List.of(4, 3),
                        "Physics", List.of(3, 3)
                )),
                new Student("Fiona", "Hall", Map.of(
                        "Math", List.of(4, 5, 4),
                        "Russian", List.of(5, 4, 4),
                        "Informatics", List.of(5, 5, 5),
                        "History", List.of(5, 5),
                        "PE", List.of(5, 4),
                        "Chemistry", List.of(4, 5),
                        "Physics", List.of(5, 5)
                )),
                new Student("George", "Irwin", Map.of(
                        "Math", List.of(3, 3, 4),
                        "Russian", List.of(4, 4, 4),
                        "Informatics", List.of(4, 4, 4),
                        "History", List.of(3, 4),
                        "PE", List.of(4, 4),
                        "Chemistry", List.of(4, 4),
                        "Physics", List.of(4, 4)
                )),
                new Student("Hannah", "Jones", Map.of(
                        "Math", List.of(5, 4, 5),
                        "Russian", List.of(4, 5, 4),
                        "Informatics", List.of(5, 5, 5),
                        "History", List.of(5, 5),
                        "PE", List.of(5, 5),
                        "Chemistry", List.of(5, 5),
                        "Physics", List.of(5, 5)
                )),
                new Student("Ian", "King", Map.of(
                        "Math", List.of(4, 4, 3),
                        "Russian", List.of(3, 4, 3),
                        "Informatics", List.of(4, 3, 4),
                        "History", List.of(3, 3),
                        "PE", List.of(4, 3),
                        "Chemistry", List.of(3, 4),
                        "Physics", List.of(4, 4)
                )),
                new Student("Julia", "Lewis", Map.of(
                        "Math", List.of(5, 5, 5),
                        "Russian", List.of(5, 5, 5),
                        "Informatics", List.of(5, 5, 5),
                        "History", List.of(5, 5),
                        "PE", List.of(5, 5),
                        "Chemistry", List.of(5, 5),
                        "Physics", List.of(5, 5)
                ))
        );

        StudentsManager studentsManager = new StudentsManager();
        System.out.println("Средние оценки по школе " + studentsManager.averageGradePerSchool(students));
        System.out.println("Наиболее сложные предмет для учеников "
                + studentsManager.findMostDifficultSubject(students));
        System.out.println("Успеваемость конкретного ученкиа "
                + studentsManager.getFinalGradesForStudent(students, "George", "Irwin"));
        studentsManager.printPerformanceTable(students);
    }
}
