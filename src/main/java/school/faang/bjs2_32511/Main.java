package school.faang.bjs2_32511;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final Logger LOG = LoggerFactory.getLogger(Main.class);
    private static final List<Student> STUDENTS = new ArrayList<>();

    public static void main(String[] args) {
        Student student1 = new Student("Дэвид", "Физика", 3);
        Student student2 = new Student("Мария", "Химия", 2);
        Student student3 = new Student("Рассел", "Робототехника", 4);
        Student student4 = new Student("Альберт", "Физика", 3);
        Student student5 = new Student("Марк", "Робототехника", 2);

        addNewStudent(student1);
        addNewStudent(student2);
        addNewStudent(student3);
        addNewStudent(student4);
        addNewStudent(student5);
        addNewStudent(student5);

        deleteStudent(student3);
        deleteStudent(student3);

        searchStudents("Физика", 3);

        printListOfSortedStudents();
    }

    private static void addNewStudent(Student student) {
        if (STUDENTS.contains(student)) {
            LOG.warn("Указанный студент уже присутствует в списке");
        } else {
            STUDENTS.add(student);
            LOG.info("Студент добавлен в список студентов");
        }
    }

    private static void deleteStudent(Student student) {
        if (!STUDENTS.contains(student)) {
            LOG.warn("Указанный студент отсутствует в списке");
        } else {
            STUDENTS.remove(student);
            LOG.info("Студент " + student.getName() + " удален из списка студентов");
        }
    }

    private static List<Student> searchStudents(String faculty, int year) {
        LOG.info("Поиск студентов на факультете " + faculty + " " + year + " курса...");

        List<Student> sortedStudents = new ArrayList<>();

        for (Student student : STUDENTS) {
            if (student.getFaculty().equals(faculty) && student.getYear() == year) {
                sortedStudents.add(student);
            }
            return sortedStudents;
        }
        LOG.warn("На указанном факультете и курсе не учится ни одного студента");
        return sortedStudents;
    }

    private static void printListOfSortedStudents() {
        for (Map.Entry<Map<String, Integer>, List<Student>> student : sortStudents().entrySet()) {
            LOG.info("\nФакультет и курс: " + student.getKey() + "\nСтуденты: " + student.getValue());
        }
    }

    private static Map<Map<String, Integer>, List<Student>> sortStudents() {
        Map<Map<String, Integer>, List<Student>> sortedStudents = new HashMap<>();
        for (Student student : STUDENTS) {
            sortedStudents.putIfAbsent(Map.of(student.getFaculty(), student.getYear()), List.of(student));
        }

        return sortedStudents;
    }
}
