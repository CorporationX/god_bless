package faang.school.godbless.countingtruancy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static List<Student> students = new ArrayList<>();
    private static Map<String, List<Student>> groupedStudents = new HashMap<>();

    public static void main(String[] args) {
        HashMap<String, List<Student>> groupedStudents = groupStudentsByFacultyAndYear(students);

        addStudent(students, new Student("Alice", "Engineering", 1));
        addStudent(students, new Student("Bob", "Engineering", 2));
        addStudent(students, new Student("Charlie", "Science", 1));
        addStudent(students, new Student("Andre", "Science", 1));
        addStudent(students, new Student("Dave", "Science", 2));
        addStudent(students, new Student("Eve", "Arts", 1));
        addStudent(students, new Student("Rob", "Science", 4));
        addStudent(students, new Student("Lukas", "Science", 1));
        addStudent(students, new Student("Frank", "Engineering", 1));
        System.out.println("Complete Students list:");
        System.out.println(students);

        removeStudent(students, "Bob", "Engineering", 2);
        System.out.println("\nStudents list after removing Bob:");
        System.out.println(students);

        List<Student> scienceFirstYearStudents = findStudentsByFacultyAndYear(groupedStudents, "Science", 1);
        System.out.println("\nStudents at the first year of the Science faculty:");
        System.out.println(scienceFirstYearStudents);

        System.out.println("\nPrinting out all students grouped by Faculty and Year:");
        printAllStudents(groupedStudents);
    }

    public static HashMap<String, List<Student>> groupStudentsByFacultyAndYear(List<Student> students) {
        for (Student student : students) {
            String key = student.getFaculty() + "-" + student.getYear();
            groupedStudents.computeIfAbsent(key, k -> new ArrayList<>()).add(student);
        }
        return (HashMap<String, List<Student>>) groupedStudents;
    }

    public static void addStudent(List<Student> students, Student student) {
        students.add(student);
        String key = student.getFaculty() + "-" + student.getYear();
        groupedStudents.computeIfAbsent(key, k -> new ArrayList<>()).add(student);
    }

    public static void removeStudent(List<Student> students, String name, String faculty, int year) {
        students.removeIf(student -> {
            boolean toRemove = student.getName().equals(name)
                    && student.getFaculty().equals(faculty)
                    && student.getYear() == year;

            if (toRemove) {
                String key = faculty + "-" + year;
                List<Student> groupedList = groupedStudents.get(key);
                if (groupedList != null) {
                    groupedList.removeIf(s -> s.getName().equals(name)
                            && s.getFaculty().equals(faculty)
                            && s.getYear() == year);
                    if (groupedList.isEmpty()) {
                        groupedStudents.remove(key);
                    }
                }
            }
            return toRemove;
        });
    }

    public static List<Student> findStudentsByFacultyAndYear(HashMap<String, List<Student>> groupedStudents,
                                                             String faculty, int year) {
        String key = faculty + "-" + year;
        return groupedStudents.get(key);
    }

    public static void printAllStudents(HashMap<String, List<Student>> groupedStudents) {
        for (Map.Entry<String, List<Student>> entry : groupedStudents.entrySet()) {
            System.out.println(entry.getKey());
            for (Student student : entry.getValue()) {
                System.out.println("  " + student.getName());
            }
        }
    }
}
