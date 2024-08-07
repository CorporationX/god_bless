package faang.school.godbless;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        List<Student> students = List.of(
                new Student("Robert", "A", 1),
                new Student("Dasha", "B", 1),
                new Student("Mikhail", "A", 1),
                new Student("Vlad", "C", 3),
                new Student("Alena", "B", 2)
        );

        Map<Student, List<Student>> map = Student.createMapByFacultyAndYear(students);
        System.out.println(map);
        System.out.println();

        Student.removeStudentToMap(map, new Student("Alena", "B", 2));
        System.out.println(map);
        System.out.println();

        Optional<List<Student>> student = Student.findListByFacultyAndYear(map, "A", 1);
        if (student.isPresent()) {
            System.out.println(student.get());
        } else {
            System.out.println("No student found");
        }
        System.out.println();

        Student.printStudents(map);
    }
}
