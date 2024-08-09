package faang.school.godbless.BJS2_19386;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Main {
    private static List<Student> students = new ArrayList<>();

    private static void addStudent(String name, String faculty, int admissionYear) {
        Student student = new Student(name, faculty, admissionYear);
        students.add(student);
    }

    private static void removeStudent(String name, String faculty, int admissionYear) {
        Student student = new Student(name, faculty, admissionYear);
        students.remove(student);
    }

    private static Map<FacultyAndAdmissionYearPair, List<Student>> groupByFacultyAndAdmissionYear() {
        Map<FacultyAndAdmissionYearPair, List<Student>> studentGroups = new HashMap<>();
        for (Student student : students) {
            FacultyAndAdmissionYearPair pair = new FacultyAndAdmissionYearPair(student.getFaculty(), student.getAdmissionYear());
            studentGroups.computeIfAbsent(pair, key -> new ArrayList<>()).add(student);
        }
        return studentGroups;
    }

    private static void viewAllStudentsByGroup() {
        Map<FacultyAndAdmissionYearPair, List<Student>> studentGroups = groupByFacultyAndAdmissionYear();
        studentGroups.forEach((pair, studentGroup) -> {
            System.out.println(pair.getFaculty() + " " + pair.getAdmissionYear() + ":");
            studentGroup.forEach(student -> System.out.println("\t" + student));
        });
    }

    private static void searchStudentsByFacultyAndAdmissionYear(FacultyAndAdmissionYearPair pair) {
        Map<FacultyAndAdmissionYearPair, List<Student>> studentGroups = groupByFacultyAndAdmissionYear();
        if (studentGroups.containsKey(pair)) {
            List<Student> studentGroup = studentGroups.get(pair);
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

        removeStudent("Tina Young", "Engineering", 2023);
        System.out.println();

        viewAllStudentsByGroup();
        System.out.println();

        searchStudentsByFacultyAndAdmissionYear(new FacultyAndAdmissionYearPair("Mathematics", 2021));
    }
}

