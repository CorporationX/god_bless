package school.faang.counting_absenteeism;

import java.util.*;

public class Main {
    private static final String DELIMITER = " ";

    public static void main(String[] args) {

        var student = new Student("Harry Potter", "Magic ", "Magic-Grade");

        var students = new ArrayList<>(Arrays.asList(
                new Student("Vlad", "IT ", "Fourth-Grade"),
                new Student("Natasha", "IT ", "Seventh-Grade"),
                new Student("Ilya", "IT ", "First-Grade"),
                new Student("Shon", "Gym ", "Second-Grade"),
                new Student("Neo", "Gym ", "Second-Grade"),
                new Student("Wan", "Gym ", "Fifth-Grade"),
                new Student("Tatiana", "Art ", "Third-Grade"),
                new Student("Ksenia", "Art ", "Fifth-Grade")
        ));
        var testMap = listToMap(students);

        System.out.println("Add Student: " + addToList(student, testMap) + " was added\n");

        System.out.println("Find Students By faculty and course:");
        System.out.println(findStudents(student, testMap) + "\n");

        System.out.println("Remove student: " + removeStudent(student, testMap) + " was removed\n");

        print(testMap);
    }

    private static Map<String, List<Student>> listToMap(List<Student> students) {
        var studentsMap = new HashMap<String, List<Student>>();
        students.forEach(student -> studentsMap.computeIfAbsent(buildKey(student), v -> new ArrayList<>()).add(student));
        return studentsMap;
    }

    private static Student addToList(Student student, Map<String, List<Student>> students) {
        students.computeIfAbsent(buildKey(student), v -> new ArrayList<>()).add(student);
        return student;
    }

    private static Student removeStudent(Student studentToRemove, Map<String, List<Student>> students) {
        students.entrySet().removeIf(entry -> entry.getValue().removeIf(student ->
                student.name().equals(studentToRemove.name()) &&
                        student.faculty().equals(studentToRemove.faculty()) &&
                        student.year().equals(studentToRemove.year())));
        return studentToRemove;
    }

    private static List<Student> findStudents(Student student, Map<String, List<Student>> students) {
        return students.get(buildKey(student));
    }

    private static String buildKey(Student student) {
        return student.faculty() + DELIMITER + student.year();
    }

    private static void print(Map<String, List<Student>> students) {
        students.forEach((facultyYear, studentsList) -> {
            System.out.println("Faculty Course: " + facultyYear);
            studentsList.forEach(System.out::println);
        });
    }
}
