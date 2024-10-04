package school.faang.truancy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    static List<Student> allStudents = new ArrayList<>();

    public static void main(String[] args) {
        Student aleksey = new Student("Aleksey", "IT", 2023);
        Student olga = new Student("Olga", "IT", 2022);
        Student ivan = new Student("Ivan", "IT", 2023);
        Student david = new Student("David", "HR", 2021);

        addNewStudent(aleksey);
        addNewStudent(olga);
        addNewStudent(ivan);
        addNewStudent(david);

        Map<StudentRecord, List<Student>> groupedStudents = addStudents(allStudents);

        System.out.println("All Grouped Students:");
        printAllGroupedStudents(groupedStudents);

        System.out.println("\nStudents in IT, Year 2023:");
        findAllStudentsByCourseAndFaculty(groupedStudents, "IT", 2023);

        System.out.println("\nRemoving student: Ivan");
        removeStudentByName(groupedStudents, "Ivan");

        System.out.println("\nUpdated Grouped Students:");
        printAllGroupedStudents(groupedStudents);

        System.out.println("\nRemoving all students from Mathematics, Year " +
                "2022");
        removeByFacultyAndCourse(groupedStudents, new Student("",
                "Mathematics", 2022));
        printAllGroupedStudents(groupedStudents);
    }

    public static Map<StudentRecord, List<Student>> addStudents(List<Student> listStudents) {
        Map<StudentRecord, List<Student>> result = new HashMap<>();
        for (Student st : listStudents) {
            result.computeIfAbsent(new StudentRecord(st.getFaculty(), st.getYear()),
                    k -> new ArrayList<>()).add(st);
        }
        return result;
    }

    public static void addNewStudent(Student student) {
        allStudents.add(student);
    }

    public static void removeStudentByName(Map<StudentRecord,
            List<Student>> mapForDeleteStudentByName, String name) {
        mapForDeleteStudentByName.forEach((k, v) -> v.removeIf(student ->
                student.getName().equalsIgnoreCase(name)));
    }

    public static void removeByFacultyAndCourse(Map<StudentRecord,
            List<Student>> mapForRemoveStudent, Student student) {
        mapForRemoveStudent.keySet().removeIf(k -> k.getFaculty()
                .equals(student.getFaculty()) &&
                k.getYear() == student.getYear());
    }

    public static void findAllStudentsByCourseAndFaculty(Map<StudentRecord,
            List<Student>> mapForFindStudent, String faculty, int course) {
        mapForFindStudent.entrySet()
                .stream()
                .filter(entry -> entry.getKey().getFaculty().equals(faculty) &&
                        entry.getKey().getYear() == course)
                .forEach(System.out::println);
    }

    public static void printAllGroupedStudents(Map<StudentRecord, List<Student>> mapForShowAllStudents) {
        for (Map.Entry<StudentRecord, List<Student>> entry : mapForShowAllStudents.entrySet()) {
            System.out.println("Faculty: " + entry.getKey().getFaculty() + ", Year: " + entry.getKey().getYear());

            for (Student student : entry.getValue()) {
                System.out.println("   Student Name: " + student.getName());
            }
        }
    }
}
