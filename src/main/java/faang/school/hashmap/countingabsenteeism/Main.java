package faang.school.hashmap.countingabsenteeism;

import java.util.*;

public class Main {

    static private final Set<Student> setStudent = new HashSet<>();
    static private final HashMap<List, List> mapStudent = new HashMap<>();

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

        HashMap<List, List> mapStudent = addStudentsMap(setStudent);

        for (Map.Entry<List, List> student : mapStudent.entrySet()) {
            System.out.println(student);
        }

        deleteStudent(ivan);

        printAllStudentFacultyEndYear("Сhemical", 1);
        printAllStudentFacultyEndYear("Сhemical", 0);
        printAllStudentFacultyEndYear("", 1);

        for (Student studentSet : setStudent) {
            System.out.println(studentSet);
        }
    }

    private static HashMap<List, List> addStudentsMap(Set<Student> studentSet) {
        if (studentSet != null) {
            for (Student student : studentSet) {
                ArrayList<String> kay = new ArrayList<>();
                kay.add(student.getFaculty());
                kay.add(String.valueOf(student.getYear()));
                mapStudent.computeIfAbsent(kay, k -> new LinkedList()).add(student.getName());
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
        if (!(faculty.isBlank() || year != 0)) {
            for (Student student : setStudent) {
                if (student.getFaculty().equals(faculty) && student.getYear() == year) {
                    System.out.println(student);
                }
            }
        } else {
            System.out.println("Введите факультет и курс студента");
        }
    }
}
