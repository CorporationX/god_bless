package faang.school.godbless.bjs219358;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static List<Student> students = new ArrayList<>();

    public static void main(String[] args) {
        students.add(new Student("Mark", "Economics", 2022));
        students.add(new Student("Ivan", "IT", 2023));
        students.add(new Student("Zurab", "Management", 2024));
        students.add(new Student("Erik", "Economics", 2022));
        students.add(new Student("Vladimir", "Management", 2024));

        addStudent(new Student("Olga", "IT", 2023));
        removeStudent(new Student("Olga", "IT", 2023));
        System.out.println(getStudents(new CompositeKey("Management", 2024)));
        System.out.println(groupStudents(students));
    }

    public static void addStudent(Student student) {
        students.add(student);
    }

    public static void removeStudent(Student student) {
        students.remove(student);
    }

    public static List<Student> getStudents(CompositeKey compositeKey) {
        Map<CompositeKey, List<Student>> studentByKey = groupStudents(students);
        return studentByKey.get(compositeKey);
    }

    public static Map<CompositeKey, List<Student>> groupStudents(List<Student> students) {
        Map<CompositeKey, List<Student>> groupedStudents = new HashMap<>();
        for (Student student : students) {
            CompositeKey studentKey = new CompositeKey(student.getFaculty(), student.getYear());
            if (groupedStudents.containsKey(studentKey)) {
                groupedStudents.get(studentKey).add(student);
            } else {
                List<Student> studentList = new ArrayList<>();
                studentList.add(student);
                groupedStudents.put(studentKey, studentList);
            }
        }
        return groupedStudents;
    }

}
