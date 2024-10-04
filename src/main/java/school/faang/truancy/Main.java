package school.faang.truancy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class Main {

    private static final List<Student> STUDENTS = new ArrayList<>();
    private static final Set<Student> addedStudents = new HashSet<>();

    public static void main(String[] args) {
        addStudent(new Student("Alex", "IVT", 2));
        addStudent(new Student("John", "MRM", 3));
        addStudent(new Student("Ivan", "IVT", 2));
        printAllStudents();
        addStudent(new Student("Petr", "MRM", 3));
        printAllStudents();
        System.out.println(getStudentsByFacultyAndYear("IVT", 2));
        removeStudent("Petr", "MRM", 2);
        printAllStudents();
    }

    public static void addStudent(Student student) {
        if (student == null) {
            throw new IllegalArgumentException("Student cannot be null");
        }
        if (addedStudents.add(student)) {
            STUDENTS.add(student);
        }
    }

    public static void removeStudent(String name, String faculty, int year) {
        Student studentToRemove = new Student(name, faculty, year);
        if (addedStudents.remove(studentToRemove)) {
            STUDENTS.remove(studentToRemove);
        }
    }

    public static List<Student> getStudentsByFacultyAndYear(String faculty, int year) {
        Map<GroupKey, List<Student>> groupedStudents = groupStudents();
        GroupKey key = new GroupKey(faculty, year);

        return groupedStudents.get(key);
    }

    public static void printAllStudents() {
        Map<GroupKey, List<Student>> groupedStudents = groupStudents();
        for (Map.Entry<GroupKey, List<Student>> entry : groupedStudents.entrySet()) {
            System.out.printf(
                    "Faculty/Year: %s/%d; Students: %s%n",
                    entry.getKey().faculty,
                    entry.getKey().year,
                    entry.getValue()
            );
        }
    }

    private static Map<GroupKey, List<Student>> groupStudents() {
        Map<GroupKey, List<Student>> groups = new HashMap<>();
        for (Student student : STUDENTS) {
            if (student == null) {
                continue;
            }
            GroupKey key = new GroupKey(student.getFaculty(), student.getYear());
            groups.computeIfAbsent(key, k -> new ArrayList<>()).add(student);
        }

        return groups;
    }

    private record GroupKey(String faculty, int year) {

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof GroupKey groupKey)) return false;
            return year == groupKey.year && Objects.equals(faculty, groupKey.faculty);
        }

        @Override
        public int hashCode() {
            return Objects.hash(faculty, year);
        }
    }
}
