package faang.school.godbless.BJS2_19468;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final List<Student> STUDENTS = new ArrayList<>();
    private static final Map<Student, Integer> STUDENT_INDEXES = new HashMap<>();
    private static HashMap<StudentAcademicInfo, List<Student>> GROUPED_STUDENTS;

    public static void main(String[] args) {
        Student anastasia = new Student("Anastasia", "engineering", 4);
        Student alexander = new Student("Alexander", "computer design", 3);
        Student mikhail = new Student("Mikhail", "radio electronics", 2);
        Student maria = new Student("Maria", "engineering", 4);
        addStudent(anastasia);
        addStudent(alexander);
        addStudent(mikhail);
        addStudent(maria);
        removeStudent("Alexander", "computer design", 3);
        GROUPED_STUDENTS = groupStudentsByFacultyAndYear(STUDENTS);
        List<Student> students = searchStudentsByFacultyAndYear("engineering", 4);
        System.out.println("Results of searching students from engineering faculty 4 course:");
        for (Student student : students) {
            System.out.println(student);
        }
        printAllGroupedStudents();
    }

    private static HashMap<StudentAcademicInfo, List<Student>> groupStudentsByFacultyAndYear(List<Student> students) {
        HashMap<StudentAcademicInfo, List<Student>> groupedStudents = new HashMap<>();
        if (students == null) {
            return null;
        }
        for (Student student : students) {
            groupedStudents.computeIfAbsent(new StudentAcademicInfo(student.getFaculty(), student.getYear()),
                    studentAcademicInfo -> new ArrayList<>()).add(student);
        }
        return groupedStudents;
    }

    private static void addStudent(Student student) {
        STUDENTS.add(student);
        addStudentIndex(student);
    }

    private static void addStudentIndex(Student student) {
        STUDENT_INDEXES.put(student, STUDENTS.size() - 1);
    }

    private static void removeStudent(String name, String faculty, int year) {
        int index = STUDENT_INDEXES.get(new Student(name, faculty, year));
        STUDENTS.remove(index);
    }

    private static List<Student> searchStudentsByFacultyAndYear(String faculty, int year) {
        return GROUPED_STUDENTS.get(new StudentAcademicInfo(faculty, year));
    }

    private static void printAllGroupedStudents() {
        for (var students : GROUPED_STUDENTS.entrySet()) {
            System.out.println("Faculty: " + students.getKey().getFaculty() + ", course: " + students.getKey().getYear());
            for (Student student : students.getValue()) {
                System.out.println(student);
            }
        }
    }
}
