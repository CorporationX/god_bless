package school.faang.t06;

import java.util.*;

public class Main {
    private static final List<Student> STUDENTS = new ArrayList<>();
    private static final Map<Map.Entry<String, Integer>, List<Student>> GROUPED_STUDENTS = new HashMap<>();
    private static final Map<Student, Integer> INDEX_STUDENTS = new HashMap<>();

    public static void main(String[] args) {

        addStudent(new Student("Masha", "it", 1));
        addStudent(new Student("Sasha", "it", 2));
        addStudent(new Student("Vasya", "gum", 1));
        addStudent(new Student("ADel", "gum", 3));
        addStudent(new Student("Tom", "it", 1));

        System.out.println("Все студенты:");
        printAllGroupedStudents();

        System.out.println("Студенты факультета it, 1 курс:");
        List<Student> infoFirstYear = findStudents("it", 1);
        infoFirstYear.forEach(System.out::println);

        removeStudent("ADel", "gum", 3);
        System.out.println("\nПосле удаления ADel:");
        printAllGroupedStudents();

        addStudent(new Student("Addotic", "gum", 5));
        System.out.println("\nПосле добавления нового студента:");
        printAllGroupedStudents();
    }

    public static void addStudent(Student student) {
        STUDENTS.add(student);
        INDEX_STUDENTS.put(student, STUDENTS.size() - 1);
        updateGroupedStudents();
    }

    private static void removeStudent(String name, String faculty, int year) {
        Student key = new Student(name, faculty, year);
        Integer index = INDEX_STUDENTS.remove(key);
        if (index != null) {
            STUDENTS.remove(index.intValue());
            updateIndexes(index);
            updateGroupedStudents();
        }
    }

    public static List<Student> findStudents(String faculty, int year) {
        return GROUPED_STUDENTS.getOrDefault(Map.entry(faculty, year), new ArrayList<>());
    }

    public static void printAllGroupedStudents() {
        for (Map.Entry<Map.Entry<String, Integer>, List<Student>> entry : GROUPED_STUDENTS.entrySet()) {
            System.out.println("Faculty: " + entry.getKey().getKey() + ", Year: " + entry.getKey().getValue());
            for (Student student : entry.getValue()) {
                System.out.println("  " + student);
            }
            System.out.println();
        }
    }

    private static void updateIndexes(int removedIndex) {
        for (int i = removedIndex; i < STUDENTS.size(); i++) {
            Student student = STUDENTS.get(i);
            INDEX_STUDENTS.put(student, i);
        }
    }

    private static void updateGroupedStudents() {
        GROUPED_STUDENTS.clear();
        for (Student student : STUDENTS) {
            Map.Entry<String, Integer> key = Map.entry(student.getFaculty(), student.getYear());
            GROUPED_STUDENTS.computeIfAbsent(key, k -> new ArrayList<>()).add(student);
        }
    }
}
