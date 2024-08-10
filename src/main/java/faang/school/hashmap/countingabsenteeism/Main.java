package faang.school.hashmap.countingabsenteeism;

import java.util.*;

public class Main {

    static private final Set<Student> setStudent = new HashSet<>();
    static private final HashMap<List<String>, List<String>> mapStudent = new HashMap<>();

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

        for (Map.Entry<List<String>, List<String>> student : addStudentsMap(setStudent).entrySet()) {
            System.out.println(student);
        }

        deleteStudent(ivan);

        printAllStudentFacultyEndYear("Сhemical", 1);
        printAllStudentFacultyEndYear("Сhemical", 0);
        printAllStudentFacultyEndYear(null, 1);

        for (Student studentSet : setStudent) {
            System.out.println(studentSet);
        }
    }

    private static HashMap<List<String>, List<String>> addStudentsMap(Set<Student> studentSet) {
        if (studentSet != null) {
            for (Student student : studentSet) {
                ArrayList<String> kay = new ArrayList<>();
                kay.add(student.getFaculty());
                kay.add(String.valueOf(student.getYear()));
                mapStudent.computeIfAbsent(kay, k -> new LinkedList<>()).add(student.getName());
            }
        }
        return mapStudent;
    }

    private static void addNewStudent(Student student) {
        if (student != null) {
            setStudent.add(student);
        }
    }

    private static void deleteStudent(Student student) {
        if (student != null) {
            setStudent.remove(student);
        }
    }

    private static void printAllStudentFacultyEndYear(String faculty, int year) {
        if (faculty != null && !(faculty.isBlank())) {
            if (year != 0) {
                for (Student student : setStudent) {
                    if (student.getFaculty().equals(faculty) && student.getYear() == year) {
                        System.out.println(student);
                    }
                }
            } else System.out.println("Курс студента не может быть 0");

        } else System.out.println("Введите факультет студента");
    }
}
