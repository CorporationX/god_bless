package faang.school.godbless.university;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    private static List<Student> students = new ArrayList<>();
    private static Map<Pair, List<Student>> groupStudents = new HashMap<>();

    public static void main(String[] args) {

        addStudent(new Student("Mark", "CS", 4));
        addStudent(new Student("Michael", "Biology", 1));
        addStudent(new Student("Leonardo", "CS", 2));
        addStudent(new Student("Sandra", "CS", 2));
        addStudent(new Student("Dan", "CS", 2));

        removeStudent("Sandra", "CS", 2);
        getGroupsByFacultyAndYear();
        printAllStudents();
        findAllStudentsByGroup("CS", 2);
    }

    public static void printAllStudents() {
        groupStudents.entrySet().forEach(System.out::println);
    }

    public static void addStudent(Student student) {
        Pair pair = new Pair(student.getFaculty(), student.getYear());
        if (groupStudents.containsKey(pair)) {
            students = groupStudents.get(pair);
        } else {
            students = new ArrayList<>();
        }
        students.add(student);
        groupStudents.put(pair, students);
    }

    public static void removeStudent(String name, String faculty, int year) {
        Pair pair = new Pair(faculty, year);
        Student student = new Student(name, faculty, year);
        if (groupStudents.containsKey(pair)) {
            groupStudents.remove(pair, student);
        }
    }

    //Вывод списка всех студентов сгруппированных по факультетам и курсам
    public static void getGroupsByFacultyAndYear() {

        for (Map.Entry<Pair, List<Student>> entry : groupStudents.entrySet()) {
            if (groupStudents.containsKey(entry.getKey())) {
                System.out.println("Faculty: " + entry.getKey());
                for (Student student : groupStudents.get(entry.getKey())) {
                    System.out.println(student);
                }
                System.out.println();
            }
        }
    }

    //Поиск всех студентов определённого факультета и курса
    public static void findAllStudentsByGroup(String faculty, int year) {

        Pair pair = new Pair(faculty, year);
        if (groupStudents.containsKey(pair)) {
            List<Student> tempList = groupStudents.get(pair);
            for (Student student : tempList) {
                System.out.println(student);
            }
        }
    }
}