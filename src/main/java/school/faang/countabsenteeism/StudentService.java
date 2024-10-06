package school.faang.countabsenteeism;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static school.faang.countabsenteeism.Main.STUDENTS;

public class StudentService {
    public static HashMap<StudentProfile, ArrayList<Student>> groupingStudents(List<Student> students) {
        HashMap<StudentProfile, ArrayList<Student>> groupedStudents = new HashMap<>();
        for (Student student : students) {
            groupedStudents.computeIfAbsent(student.getStudentProfile(), profile -> new ArrayList<>())
                    .add(student);
        }
        return groupedStudents;
    }

    public static void add(Student student) {
        STUDENTS.add(student);
    }

    public static void remove(String name, String faculty, int year) {
        Student studentToRemove = new Student(name, new StudentProfile(faculty, year));
        int indexStudent = STUDENTS.indexOf(studentToRemove);
        if (studentToRemove != null) {
            STUDENTS.remove(indexStudent);
        }
    }

    public static ArrayList<Student> getStudentsByStudentProfile(String faculty, int year) {
        ArrayList<Student> studentsByStudentProfile = new ArrayList<>();
        for (Student student : STUDENTS) {
            if (student.getStudentProfile().getFaculty().equals(faculty)
                    && student.getStudentProfile().getYear() == year) {
                studentsByStudentProfile.add(student);
            }
        }
        return studentsByStudentProfile;
    }

    public static void printAll(List<Student> students) {
        Map<StudentProfile, ArrayList<Student>> groupedStudents = groupingStudents(students);
        for (var entry : groupedStudents.entrySet()) {
            System.out.println(entry.getKey() + " " +
                    entry.getValue());
        }
    }

    public static void printForTest(List<Student> students) {
        for (Student student : students) {
            System.out.println(student);
        }
    }
}
