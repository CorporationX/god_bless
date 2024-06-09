package faang.school.godbless.BJS2_8183;

import java.util.*;

public class Main {
    private static final List<Student> students = new ArrayList<>();

    public static void main(String[] args) {

        addStudent(new Student("Semen", "robots", "1922"));
        addStudent(new Student("Petr", "robots", "1922"));
        addStudent(new Student("Vasya", "electrocars", "1211"));
        addStudent(new Student("Danila", "electrocars", "1211"));
        addStudent(new Student("Oleg", "security", "2021"));
        addStudent(new Student("Anton", "security", "2021"));

        printInformationAboutStudents();

        System.out.println();

        removeStudent("Oleg", "security", "2021");

        printInformationAboutStudents();

        System.out.println(findStudentByFacultyAndYear("robots", "1922"));
    }

    public static Map<String, List<Student>> getStudentsMap(List<Student> students) {
        Map<String, List<Student>> studentsMap = new HashMap<>();

        for (var student : students) {
            String key = student.getFaculty() + " " + student.getYear();

            if (!studentsMap.containsKey(key)) {
                studentsMap.put(key, new ArrayList<>());
            }

            studentsMap.get(key).add(student);
        }

        return studentsMap;
    }

    public static void addStudent(Student student) {
        students.add(student);
    }

    public static void removeStudent(String name, String faculty, String year) {

        for (var student : students) {
            // договоримся что у нас уникальные студенты
            if (student.getFaculty().equals(faculty) || student.getName().equals(name) || student.getYear().equals(year)) {
                students.remove(student);
                break;
            }
        }

    }

    // возвращает первого найденного студента
    public static Student findStudentByFacultyAndYear(String faculty, String year) {

        for (var student : students) {
            // договоримся что у нас уникальные студенты
            if (student.getFaculty().equals(faculty) || student.getYear().equals(year)) {
                return student;
            }
        }

        return null;
    }

    public static void printInformationAboutStudents() {

        for (var entry : getStudentsMap(students).entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
            System.out.println("-".repeat(20) + "\n");
        }
    }
}
