package countingAbsenteeism;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    private static final Map<String, List<Student>> UNIVERSITY = new HashMap<>();
    private static final List<Student> STUDENTS = new ArrayList<>();

    public static void main(String[] args) {
        Student student11 = new Student("Nick", "Aerospace", 4);
        Student student12 = new Student("Vadim", "Aerospace", 4);
        Student student13 = new Student("Nikita", "Aerospace", 2);
        Student student14 = new Student("Ilya", "Aerospace", 3);
        addStudent(student11);
        addStudent(student12);
        addStudent(student13);
        addStudent(student14);

        Student student21 = new Student("Paul", "Aircraft engines", 1);
        Student student22 = new Student("Andrey", "Aircraft engines", 1);
        Student student23 = new Student("Anya", "Aircraft engines", 2);
        Student student24 = new Student("Victoria", "Aircraft engines", 3);
        addStudent(student21);
        addStudent(student22);
        addStudent(student23);
        addStudent(student24);

        Student student31 = new Student("Stas", "IT", 1);
        Student student32 = new Student("Max", "IT", 2);
        Student student33 = new Student("Dima", "IT", 2);
        Student student34 = new Student("Anton", "IT", 3);
        addStudent(student31);
        addStudent(student32);
        addStudent(student33);
        addStudent(student34);

        removeStudent(student34);

        sortByFacultyAndYear(STUDENTS);
        findAllStudentByFacultyAndYear("IT", 2);
        System.out.println("====================");
        findAllStudentByFacultyAndYear("Aerospace", 4);
        System.out.println("====================");

        printAllStudent();
    }

    public static void sortByFacultyAndYear(List<Student> students) {
        String key;
        List<Student> tmp;
        for (Student student : students) {

            key = student.getFaculty() + student.getYear();
            if (!UNIVERSITY.containsKey(key)) {
                UNIVERSITY.put(key, new ArrayList<>());
            }

            tmp = UNIVERSITY.get(key);
            tmp.add(student);
            UNIVERSITY.put(key, tmp);
        }
    }

    public static void addStudent(Student student) {
        STUDENTS.add(student);
    }

    public static void removeStudent(Student student) {
        STUDENTS.remove(student);
    }

    public static void findAllStudentByFacultyAndYear(String faculty, int year) {
        String key = faculty + year;
        if (!UNIVERSITY.containsKey(key)) {
            throw new NullPointerException("По запросу факультет: '" + faculty + "'\n"
                    + "курс: " + year + "\n"
                    + "Ничего не найдено!");
        }
        for (Student student : UNIVERSITY.get(key)) {
            System.out.println(student);
        }
    }

    public static void printAllStudent() {
        for (Map.Entry<String, List<Student>> entry : UNIVERSITY.entrySet()) {
            System.out.println("Факультет и курс: " + entry.getKey()
                    + "\nСписок студентов: " + entry.getValue()
                    + "\n========================");
        }
    }
}
