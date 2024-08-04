package faang.school.godbless.BJS2_19349;

import java.util.*;

public class Main {
    static List<Student> students = new ArrayList<>();

    public static void main(String[] args) {
        Student vasya = new Student("Vasya", "Biomechanical", 2002);
        Student ivan = new Student("Ivan", "Biomechanical", 2002);
        Student michael = new Student("Michael", "Theoretical mechanics", 2020);
        Student ekaterina = new Student("Ekaterina", "Theoretical mechanics", 2020);
        Student petya = new Student("Petya", "Theoretical physics", 1992);
        Student maria = new Student("Maria", "Sociology", 2020);
        Student vera = new Student("Vera", "Biomechanical", 2020);

        addStudent(vasya);
        addStudent(petya);
        addStudent(ivan);
        addStudent(michael);
        addStudent(vera);
        addStudent(ekaterina);
        addStudent(maria);

        printAllStudents(students);
        System.out.println("------------");
        removeStudent("Ivan", "Biomechanical", 2002);
        printAllStudents(students);
        System.out.println("------------");
        findAllByFacultyYear("Theoretical mechanics", 2020);
    }

    public static Map<String, List<Student>> getAllStudents(List<Student> students) {
        Map<String, List<Student>> resultMap = new HashMap<>();
        for (Student student : students) {
            String facultyYearField = student.getFaculty() + " " + student.getYear();
            if (!resultMap.containsKey(facultyYearField)) {
                resultMap.put(facultyYearField, new ArrayList<>(List.of(student)));
            } else {
                List<Student> currentStudents = resultMap.get(facultyYearField);
                currentStudents.add(student);
                resultMap.put(facultyYearField, currentStudents);
            }
        }
        return resultMap;
    }

    public static void addStudent(Student student) {
        students.add(student);
    }

    public static void removeStudent(String name, String faculty, int year) {
        students.remove(new Student(name, faculty, year));
    }

    public static void printAllStudents(List<Student> students) {
        Map<String, List<Student>> studentMap = getAllStudents(students);
        for (var entry : studentMap.entrySet()) {
            System.out.println(entry.getKey() + ":");
            List<Student> currentValue = entry.getValue();
            currentValue.forEach(student -> System.out.println(student.getName()));
        }
    }

    public static void findAllByFacultyYear(String faculty, int year) {
        Map<String, List<Student>> studentMap = getAllStudents(students);
        System.out.println("Students of " + faculty + " " + year);
        for (var entry : studentMap.entrySet()) {
            if (entry.getKey().equals(faculty + " " + year)) {
                List<Student> currentValue = entry.getValue();
                currentValue.forEach(student -> System.out.println(student.getName()));
            }
        }
    }
}
