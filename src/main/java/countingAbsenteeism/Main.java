package countingAbsenteeism;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    private static final Map<String, List<Student>> UNIVERSITY = new HashMap<>();
    private static final List<Student> STUDENTS = new ArrayList<>();

    public static void main(String[] args) {
        Student student11 = new Student("Nick", "Aerospace", 1);
        Student student12 = new Student("Vadim", "Aerospace", 2);
        Student student13 = new Student("Nikita", "Aerospace", 3);
        Student student14 = new Student("Ilya", "Aerospace", 4);
        addStudent(student11);
        addStudent(student12);
        addStudent(student13);

        Student student21 = new Student("Paul", "Aircraft engines", 1);
        Student student22 = new Student("Andrey", "Aircraft engines", 2);
        Student student23 = new Student("Anya", "Aircraft engines", 3);
        Student student24 = new Student("Victoria", "Aircraft engines", 4);
        addStudent(student21);
        addStudent(student22);
        addStudent(student23);


        Student student31 = new Student("Stas", "IT", 1);
        Student student32 = new Student("Max", "IT", 2);
        Student student33 = new Student("Dima", "IT", 3);
        Student student34 = new Student("Anton", "IT", 4);
        addStudent(student31);
        addStudent(student32);
        addStudent(student33);
        printAllStudent();

        System.out.println("\n\nДобавляем списокм\n\n");
        STUDENTS.add(student14);
        STUDENTS.add(student24);
        STUDENTS.add(student34);
        groupByFacultyAndYear(STUDENTS);
        printAllStudent();

        System.out.println("\n\nУдаляем студента\n\n");
        printStudentListByFacultyAndYear(findAllStudentByFacultyAndYear("IT", 4));
        removeStudent(student34);
        printStudentListByFacultyAndYear(findAllStudentByFacultyAndYear("IT", 4));

    }

    public static void groupByFacultyAndYear(List<Student> students) {
        for (Student student : students) {
            addStudent(student);
        }
    }

    public static void addStudent(Student student) {
        String key = createKey(student.getFaculty(), student.getYear());
        if (!UNIVERSITY.containsKey(key)) {
            UNIVERSITY.put(key, new ArrayList<>());
        }
        UNIVERSITY.get(key).add(student);

    }

    public static void removeStudent(Student student) {
        UNIVERSITY.get(createKey(student.getFaculty(), student.getYear())).remove(student);
    }

    public static List<Student> findAllStudentByFacultyAndYear(String faculty, int year) {
        return UNIVERSITY.get(createKey(faculty, year));
    }

    public static void printAllStudent() {
        for (Map.Entry<String, List<Student>> entry : UNIVERSITY.entrySet()) {
            System.out.println("Факультет и курс: " + entry.getKey()
                    + "\nСписок студентов: " + entry.getValue()
                    + "\n========================");
        }
    }

    public static void printStudentListByFacultyAndYear(List<Student> students) {
        for (Student student : students) {
            System.out.println("Iмя студента: " + student.getName() +
                    "\nКурс : " + student.getYear() +
                    "\nФакультет: " + student.getFaculty());
        }
    }

    private static String createKey(String faculty, int year) {
        return faculty + year;
    }
}
