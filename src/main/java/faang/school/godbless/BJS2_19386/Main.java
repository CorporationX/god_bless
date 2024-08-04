package faang.school.godbless.BJS2_19386;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Main {
    private static List<Student> students = new ArrayList<>();
    private static Map<Student, Integer> studentsIndexes = new HashMap<>();
    private static int index = 0;
    private static Map<FacultyAndAdmissionYearPair, List<Student>> studentGroups = new HashMap<>();

    private static void addStudent(String name, String faculty, int admissionYear) {
        Student student = new Student(name, faculty, admissionYear);
        students.add(student);
        studentsIndexes.put(student, index++);
    }

    private static void removeStudent(String name, String faculty, int admissionYear) {
        Student student = new Student(name, faculty, admissionYear);
        Integer studentIndex = studentsIndexes.get(student);
        if (Objects.nonNull(studentIndex)) {
            students.remove(studentIndex.intValue());
        }
    }

    private static void viewAllStudent() {
        students.forEach(System.out::println);
    }

    private static void groupByFacultyAndAdmissionYear() {
        for (Student student: students) {
            FacultyAndAdmissionYearPair pair = new FacultyAndAdmissionYearPair(student.getFaculty(), student.getAdmissionYear());
            List<Student> studentGroup = studentGroups.getOrDefault(pair, new ArrayList<>());
            studentGroup.add(student);
            studentGroups.put(pair, studentGroup);
        }
    }

    private static void viewAllStudentsByGroup() {
        studentGroups.forEach((pair, studentGroup) -> {
            System.out.println(pair.getFaculty() + " " + pair.getAdmissionYear() + ":");
            studentGroup.forEach(student -> System.out.println("\t" + student));
        });
    }

    private static void searchStudentsByFacultyAndAdmissionYear(String faculty, int admissionYear) {
        FacultyAndAdmissionYearPair pair = new FacultyAndAdmissionYearPair(faculty, admissionYear);
        List<Student> studentGroup = studentGroups.get(pair);
        if (Objects.nonNull(studentGroup)) {
            System.out.println(pair.getFaculty() + " " + pair.getAdmissionYear() + ":");
            studentGroup.forEach(student -> System.out.println("\t" + student));
        } else {
            System.out.println("Students not found :(");
        }
    }

    public static void main(String[] args) {
        addStudent("Alice Johnson", "Computer Science", 2021);
        addStudent("Bob Smith", "Mathematics", 2022);
        addStudent("Carol White", "Physics", 2023);
        addStudent("David Brown", "Engineering", 2024);
        addStudent("Eva Green", "Computer Science", 2022);
        addStudent("Frank Black", "Mathematics", 2023);
        addStudent("Grace Miller", "Physics", 2024);
        addStudent("Henry Moore", "Engineering", 2021);
        addStudent("Ivy Wilson", "Computer Science", 2023);
        addStudent("Jack Taylor", "Mathematics", 2024);
        addStudent("Katie Lewis", "Physics", 2021);
        addStudent("Liam Clark", "Engineering", 2022);
        addStudent("Mia Walker", "Computer Science", 2024);
        addStudent("Noah Hall", "Mathematics", 2021);
        addStudent("Olivia King", "Physics", 2022);
        addStudent("Paul Adams", "Engineering", 2023);
        addStudent("Quinn Scott", "Computer Science", 2024);
        addStudent("Rachel Turner", "Mathematics", 2021);
        addStudent("Sam Lee", "Physics", 2022);
        addStudent("Tina Young", "Engineering", 2023);
        viewAllStudent();
        System.out.println();

        removeStudent("Tina Young", "Engineering", 2023);
        viewAllStudent();
        System.out.println();

        groupByFacultyAndAdmissionYear();
        viewAllStudentsByGroup();
        System.out.println();

        searchStudentsByFacultyAndAdmissionYear("Mathematic", 2021);
    }
}

