package faang.school.hashmap.countingabsenteeism;

import java.util.*;

public class Main {

    private static final Set<Student> studentsList = new HashSet<>();
    private static final Map<List<String>, List<String>> students = new HashMap<>();

    public static void main(String[] args) {
        Student alex = new Student("Alex", "Biographical", 2);
        Student oleg = new Student("Oleg", "Сhemical", 1);
        Student ivan = new Student("Ivan", "Сhemical", 1);
        Student max = new Student("Max", "Physical", 2);
        Student anna = new Student("Anna", "Physical", 2);

        addNewStudent(alex);
        addNewStudent(oleg);
        addNewStudent(ivan);
        addNewStudent(max);
        addNewStudent(anna);

        for (Map.Entry<List<String>, List<String>> student : groupStudentsByYearAndFaculty(studentsList).entrySet()) {
            System.out.println(student);
        }

        deleteStudent(null);

        printAllStudentFacultyEndYear("Сhemical", 1);
        printAllStudentFacultyEndYear("Сhemical", 0);
        printAllStudentFacultyEndYear(null, 1);

        for (Student studentSet : studentsList) {
            System.out.println(studentSet);
        }
    }

    private static Map<List<String>, List<String>> groupStudentsByYearAndFaculty(Set<Student> studentSet) {
        if (studentSet != null) {
            for (Student student : studentSet) {
                List<String> key = new ArrayList<>();
                key.add(student.getFaculty());
                key.add(String.valueOf(student.getYear()));
                students.computeIfAbsent(key, k -> new LinkedList<>()).add(student.getName());
            }
        }
        return students;
    }

    private static void addNewStudent(Student student) {
        if (student != null) {
            studentsList.add(student);
        }
    }

    private static void deleteStudent(Student student) {
        studentsList.remove(student);
    }

    private static void printAllStudentFacultyEndYear(String faculty, int year) {
        if (faculty != null) {
            if (!(faculty.isBlank())) {
                if (year != 0) {
                    for (Student student : studentsList) {
                        if (student.getFaculty().equals(faculty) && student.getYear() == year) {
                            System.out.println(student);
                        }
                    }
                } else {
                    throw new IllegalArgumentException("Курс студента не может быть 0");
                }
            } else {
                throw new IllegalArgumentException("Введите факультет студента");
            }
        } else {
            throw new IllegalArgumentException("Введите факультет студента");
        }
    }
}
