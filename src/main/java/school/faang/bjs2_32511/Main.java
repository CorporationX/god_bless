package school.faang.bjs2_32511;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final Logger LOG = LoggerFactory.getLogger(Main.class);

    private Main() {
    }

    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();

        Student student1 = new Student("Дэвид", "Физика", 3);
        Student student2 = new Student("Мария", "Химия", 2);
        Student student3 = new Student("Рассел", "Робототехника", 4);
        Student student4 = new Student("Альберт", "Физика", 3);

        students.add(student1);
        students.add(student2);
        students.add(student3);
        students.add(student4);

        System.out.println(sortStudent(students));
    }

    public static Map<String, Integer> sortStudent(List<Student> students) {
        HashMap<String, Integer> sortedStudents = new HashMap<>();

        for (Student student : students) {
            sortedStudents.putIfAbsent(student.getFaculty(), student.getYear());
        }

        return sortedStudents;
    }
}
