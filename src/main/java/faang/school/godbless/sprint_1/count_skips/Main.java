package faang.school.godbless.sprint_1.count_skips;

import java.util.ArrayList;
import java.util.List;

public class Main {

    // если не завернуть в arrayList, то коллекция будет immutable и все упадет с ошибкой
    private static final List<Student> STUDENTS = new ArrayList<>(
            List.of(
                    new Student("Test1", "programming", 1),
                    new Student("Test2", "programming", 1),
                    new Student("Test3", "programming", 1),
                    new Student("Test4", "programming", 2),
                    new Student("Test5", "programming", 2),
                    new Student("Test6", "drawing", 1)
            )
    );

    public static void main(String[] args) {
        printStudents();
        addNewStudent(new Student("NewStudent", "NewFaculty", 1));

        System.out.println();

        printStudents();
        deleteStudent("NewStudent", "NewFaculty", 1);

        System.out.println();

        System.out.println(findAllStudentsByFacultyAndYear("programming", 1));
    }

    public static void addNewStudent(Student student) {
        STUDENTS.add(student);
    }

    /*
    * Вот тут у меня есть несколько вариантов как улучшить:
    * 1) Сделать for через переменную "i" и удалять студента по индексу (так и реализовал)
    * 2) Использовать HashSet вместо ArrayList, так как все студенты у нас уникальны - нам это подойдет.
    *    Время поиска и удаление студента будет O(1)
    */
    public static void deleteStudent(String name, String faculty, int year) {
        Student studentForRemove = new Student(name, faculty, year);
        for (int i = 0; i < STUDENTS.size(); i++) {
            if (STUDENTS.get(i).equals(studentForRemove)) {
                STUDENTS.remove(i);
                break;
            }
        }
    }

    public static List<Student> findAllStudentsByFacultyAndYear(String faculty, int year) {
        List<Student> ans = new ArrayList<>();
        for (Student student : STUDENTS) {
            if (student.getFaculty().equals(faculty) && student.getYear() == year) {
                ans.add(student);
            }
        }
        return ans;
    }

    public static void printStudents() {
        Student.groupStudents(STUDENTS).forEach(((key, value) -> System.out.printf("%s -> %s%n", key, value)));
    }


}
