package faang.school.godbless.JavaHashMap.task3;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

public class Main {
    private static final List<Student> STUDENTS = new ArrayList<>();
    private static final Map<Student, Integer> STUDENT_NUMBER = new HashMap<>();
    private static int indexCounter = 0;

    public static void main(String[] args) {

        Student kazakov = new Student("Казаков", "IT", 1);
        Student petrov = new Student("Петров", "Эконом", 2);
        Student vasilyev = new Student("Васильев", "Архитектура", 2);
        Student kvasov = new Student("Квасов", "Физика", 4);
        Student poroshin = new Student("Порошин", "Эконом", 1);
        Student virnyakov = new Student("Вирняков", "Архитектура", 3);

        add(kazakov);
        add(petrov);
        add(vasilyev);
        add(kvasov);
        add(poroshin);
        add(virnyakov);

        groupStudentsFacultyAndYear(STUDENTS);
        remove(vasilyev.getName(), vasilyev.getFaculty(), vasilyev.getYear());
        System.out.println("Поиск студента : ");
        findStudents("Эконом", 1);
        printGroupedStudents(STUDENTS);


    }

    private static void add(Student student) {
        STUDENTS.add(indexCounter, student);
        STUDENT_NUMBER.put(student, indexCounter);
        indexCounter++;
    }

    private static void remove(String name, String faculty, int year) {
        Student studentRemove = new Student(name, faculty, year);
        Integer indexStudents = STUDENT_NUMBER.remove(studentRemove);
        if (indexStudents != null) {
            STUDENTS.remove((int) indexStudents);
            indexCounter--;
        }
    }

    public static void findStudents(String faculty, int year) {
        List<Student> foundStudents = new ArrayList<>();
        for (Student student : STUDENTS) {
            if (student.getFaculty().equals(faculty) && student.getYear() == year) {
                foundStudents.add(student);
            }
        }
        for (Student student : foundStudents) {
            System.out.println(student);
        }
    }

    public static void printGroupedStudents(List<Student> students) {
        HashMap<String, List<Student>> groupedStudents = groupStudentsFacultyAndYear(students);
        for (Map.Entry<String, List<Student>> entry : groupedStudents.entrySet()) {
            System.out.println("Группа: " + entry.getKey() + " курс");
            for (Student student : entry.getValue()) {
                System.out.println(student);
            }
            System.out.println();
        }
    }

    private static HashMap<String, List<Student>> groupStudentsFacultyAndYear(List<Student> students) {
        HashMap<String, List<Student>> groupedStudents = new HashMap<>();
        for (Student student : students) {
            String key = student.getFaculty() + ", " + student.getYear();
            List<Student> group = groupedStudents.getOrDefault(key, new ArrayList<>());
            group.add(student);
            groupedStudents.put(key, group);
        }
        return groupedStudents;
    }
}
