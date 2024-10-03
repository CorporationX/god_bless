package school.faang.countingAbsence;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final List<Student> students = new ArrayList<>();

    public static void main(String[] args) {
        Student potter = new Student("Harry Potter", "Puffendui", 1);
        Student yuji = new Student("Yuji Itadori", "Magic", 2);
        Student nobara = new Student("Nobara Kugisaki", "Magic", 2);
        Student gojo = new Student("Satoru gojo", "Magic", 3);

        addStudent(potter);
        addListOfStudents(List.of(yuji, nobara, gojo));
        printAllStudents();
        removeStudent("Harry Potter", "Puffendui", 1);
        printAllStudents();
        findByFacultyAndYear("Magic", 2);
        printGroupedStudents();
    }

    private static void addStudent(Student student) {
        students.add(student);
    }

    private static void addListOfStudents(List<Student> studentsList) {
        students.addAll(studentsList);
    }

    private static void removeStudent(String name, String faculty, int year) {
        Student studentToRemove = new Student(name, faculty, year);
        for (int i = 0; i < students.size(); i++) {
            Student tempStudent = students.get(i);
            if (tempStudent.getName().equals(studentToRemove.getName())
                    && tempStudent.getFaculty().equals(studentToRemove.getFaculty())
                    && tempStudent.getYear() == studentToRemove.getYear()) {
                students.remove(i);
                break;
            }
        }
    }

    private static void findByFacultyAndYear(String faculty, int year) {
        List<Student> groupedStudents = new ArrayList<>();
        for (Student student : students) {
            if (student.getFaculty().equals(faculty)
                    && student.getYear() == year) {
                groupedStudents.add(student);
            }
        }
        System.out.println(groupedStudents);
    }

    private static Map<String, List<Student>> studentsFacultyInfo(List<Student> students) {
        Map<String, List<Student>> groupedStudents = new HashMap<>();
        for (Student student : students) {
            String key = student.getFaculty() + student.getYear();
            groupedStudents.computeIfAbsent(key, k -> new ArrayList<>()).add(student);
        }
        return groupedStudents;
    }

    private static void printGroupedStudents() {
        System.out.println(studentsFacultyInfo(students));
    }

    private static void printAllStudents() {
        System.out.println(students);
    }
}
