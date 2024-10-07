package absence;

import java.util.*;

public class Main {
    private static List<Student> studentDB = new ArrayList<>();

    public static void main(String[] args) {
        addNewStudent(new Student("Sarah", "Economics", 3));
        addNewStudent(new Student("John", "Economics", 3));
        addNewStudent(new Student("Sam", "CS", 4));
        addNewStudent(new Student("Amy", "Literature", 2));

        Map<Student, List<Student>> courseMates = getPeerStudents(studentDB);
        for (Map.Entry<Student, List<Student>> entry : courseMates.entrySet()) {
            System.out.println(entry.getKey().getFaculty() + ": " + entry.getValue());
        }

        removeStudent(new Student("Sarah", "Economics", 3));

        addNewStudent(new Student("Sarah", "Economics", 3));

        for (Student student : search("Economics", 3)) {
            System.out.println(student.getName());
        }

        printAllStudents();
    }

    public static Map<Student, List<Student>> getPeerStudents(List<Student> students) {
        Map<Student, List<Student>> studentsByFacultyAndYear = new HashMap<>();
        for (Student student : students) {
            Student studentKey = new Student(student.getName(), student.getFaculty(), student.getYear());
            studentsByFacultyAndYear.putIfAbsent(student, new ArrayList<>());
            studentsByFacultyAndYear.get(studentKey).add(student);
        }
        return studentsByFacultyAndYear;
    }

    public static void addNewStudent(Student student) {
        studentDB.add(student);
    }

    public static void removeStudent(Student student) {
        Iterator<Student> iterator = studentDB.iterator();
        while (iterator.hasNext()) {
            Student st = iterator.next();
            if (st.equalsByAllFields(student)) {
                iterator.remove();
            }
        }
    }

    public static List<Student> search(String faculty, int year) {
        List<Student> students = new ArrayList<>();
        for (Student student : studentDB) {
            if (student.getFaculty().equals(faculty) && student.getYear() == year) {
                students.add(student);
            }
        }
        return students;
    }

    public static void printAllStudents() {
        Map<Student, List<Student>> groupedStudents = getPeerStudents(studentDB);
        for (Map.Entry<Student, List<Student>> entry : groupedStudents.entrySet()) {
            System.out.println(entry.getKey().getFaculty() + " " + entry.getValue());
        }
    }
}
