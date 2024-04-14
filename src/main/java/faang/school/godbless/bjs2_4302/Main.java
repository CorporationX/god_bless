package faang.school.godbless.bjs2_4302;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        Student student1 = new Student("Ivan", "Economy", 3);
        Student student2 = new Student("Tanya", "Economy", 3);
        Student student3 = new Student("Sveta", "Architecture", 1);
        Student student4 = new Student("Denis", "Design", 2);
        Student student5 = new Student("Petr", "Design", 2);

        students.add(student1);
        students.add(student2);
        students.add(student3);
        students.add(student4);
        students.add(student5);

        //Create students group
        Map<String, List<Student>> studentsGroup = groupStudentsByFaculty(students);

        //Add new Student
        addNewStudent(studentsGroup, new Student("Severus", "Potions", 7));
        printStudents(studentsGroup);

        //Remove Student
        removeStudent(studentsGroup, "Tanya", "Economy", 3);
        System.out.println("\nStudents after removing");
        printStudents(studentsGroup);

        //Search students by faculty and year
        System.out.println("\nStudents from Economy faculty and 3 year");
        searchStudentsByFaculty(studentsGroup, "Economy", 3).forEach(System.out::println);
    }

    public static Map<String, List<Student>> groupStudentsByFaculty(List<Student> students) {
        Map<String, List<Student>> groups = new HashMap<>();
        for (Student student : students) {
            groups.computeIfAbsent(student.getFaculty() + student.getYear(), key -> new ArrayList<>()).add(student);
        }
        return groups;
    }

    public static void addNewStudent(Map<String, List<Student>> group, Student student) {
        group.computeIfAbsent(student.getFaculty() + student.getYear(), key -> new ArrayList<>()).add(student);
    }

    public static void removeStudent(Map<String, List<Student>> group, String name, String faculty, int year) {
        group.computeIfPresent(faculty + year, (key, value) -> {
            value.remove(new Student(name, faculty, year));
            return value;
        });
    }

    public static List<Student> searchStudentsByFaculty(Map<String, List<Student>> group, String faculty, int year) {
        return group.get(faculty + year);
    }

    public static void printStudents(Map<String, List<Student>> group) {
        for (Map.Entry<String, List<Student>> entry : group.entrySet()) {
            System.out.println(entry.getKey());
            entry.getValue().forEach(System.out::println);
        }
    }
}
