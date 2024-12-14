package school.faang.countabsenteeism;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class StudentService {
    public static HashMap<StudentProfile, ArrayList<Student>> groupingStudents(List<Student> students) {
        HashMap<StudentProfile, ArrayList<Student>> groupedStudents = new HashMap<>();
        for (Student student : students) {
            groupedStudents.computeIfAbsent(student.getStudentProfile(), profile -> new ArrayList<>())
                    .add(student);
        }
        return groupedStudents;
    }

    public static void add(Student student, List<Student> students) {
        students.add(student);
    }

    public static void remove(String name, String faculty, int year, List<Student> students) {
        Student studentToRemove = new Student(name, new StudentProfile(faculty, year));
        int indexStudent = students.indexOf(studentToRemove);
        if (studentToRemove != null) {
            students.remove(indexStudent);
        }
    }

    public static ArrayList<Student> getStudentsByStudentProfile(String faculty, int year, List<Student> students) {
        ArrayList<Student> studentsByStudentProfile = new ArrayList<>();
        for (Student student : students) {
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
