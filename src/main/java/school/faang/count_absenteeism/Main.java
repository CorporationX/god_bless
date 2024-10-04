package school.faang.count_absenteeism;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static final HashMap<Student, Integer> INDEX_STUDENT = new HashMap<>();
    public static final List<Student> STUDENTS = new ArrayList<>();

    public static void main(String[] args) {
        add(new Student("Dmitry", new StudentProfile("Humanities", 1)));
        add(new Student("Yaroslav", new StudentProfile("Mathematics", 3)));
        add(new Student("Sergei", new StudentProfile("Humanities", 1)));
        add(new Student("Alexey", new StudentProfile("Humanities", 3)));
        add(new Student("Alena", new StudentProfile("Chemistry", 2)));
        add(new Student("Anastasia", new StudentProfile("Chemistry", 2)));
        add(new Student("Anatoly", new StudentProfile("Chemistry", 2)));
        add(new Student("Ruslan", new StudentProfile("Chemistry", 2)));

        remove("Yaroslav", "Mathematics", 3);
        remove("Dmitry", "Humanities", 1);


        List<Student> testGetStudents = getStudentsByStudentProfile("Chemistry", 2);
        printForTest(testGetStudents);

        printAll(STUDENTS);
    }

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
        INDEX_STUDENT.put(student, STUDENTS.indexOf(student));
    }

    public static void remove(String name, String faculty, int year) {
        Student studentToRemove = new Student(name, new StudentProfile(faculty, year));
        int indexStudent = INDEX_STUDENT.get(studentToRemove);
        if (studentToRemove != null) {
            STUDENTS.remove(indexStudent);
            INDEX_STUDENT.remove(studentToRemove);
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
